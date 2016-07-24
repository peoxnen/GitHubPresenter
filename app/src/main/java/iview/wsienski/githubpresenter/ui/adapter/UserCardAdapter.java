package iview.wsienski.githubpresenter.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.data.remote.model.User;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.ViewHolder> {

    List<User> userList;

    public UserCardAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_user, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(UserCardAdapter.ViewHolder holder, int position) {
        holder.getName().setText(userList.get(position).getLogin());
        //holder.getImageView().setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.info_text)
        TextView name;
        @BindView(R.id.imageView)
        ImageView imageView;

        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cardView = itemView;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }
}
