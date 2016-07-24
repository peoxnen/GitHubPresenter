package iview.wsienski.githubpresenter.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class Utility {

    public static void openBrowser(Context context, String url){
        url=changeToHttpUrl(url);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    public static String changeToHttpUrl(String url){
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        return url;
    }
}
