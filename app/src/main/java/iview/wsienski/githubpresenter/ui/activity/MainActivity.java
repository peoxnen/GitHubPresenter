package iview.wsienski.githubpresenter.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import iview.wsienski.githubpresenter.GitHubPresenterApp;
import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.di.compontent.ActivityComponent;
import iview.wsienski.githubpresenter.di.compontent.DaggerActivityComponent;
import iview.wsienski.githubpresenter.ui.fragment.UserFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApp().getAppComponent()).build();
        activityComponent.inject(this);

        if (savedInstanceState == null) {
            setContent(new UserFragment() ,false);
        }
    }

    protected GitHubPresenterApp getApp() {
        return (GitHubPresenterApp) getApplicationContext();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_users) {
            fragment = new UserFragment();
        } else if (id == R.id.nav_repositories) {
            fragment = new UserFragment();
        } else {
            fragment = new UserFragment();
        }
        setContent(fragment, false);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Zmienia zawartość strony na zadany Fragment.
     *
     * @param fragment fragment, który ma zostać dodany w miejsce bieżącej zawartości
     */
    public void setContent(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.fragment_container, fragment);
        if (addToBackStack)
            trans.addToBackStack(null);
        trans.commit();

    }

    public ActivityComponent getActivityCompontent() {
        return activityComponent;
    }
}
