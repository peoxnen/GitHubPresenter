package iview.wsienski.githubpresenter.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import iview.wsienski.githubpresenter.R;
import iview.wsienski.githubpresenter.data.remote.model.User;
import iview.wsienski.githubpresenter.util.Utility;

/**
 * Created by Witold Sienski on 24.07.2016.
 */
public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.ViewHolder> {

    Context context;
    List<User> userList;

    public UserCardAdapter(Context context, List<User> userList) {
        this.context = context;
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
        final User user = userList.get(position);
        holder.getTitle().setText(user.getLogin());
        holder.getDesc().setText(user.getHtml_url());
        holder.getRightIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.openBrowser(context, user.getHtml_url());
            }
        });
        Picasso.with(context).load(user.getAvatar_url()).into(holder.getAvatar());

        //holder.getAvatar().setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.right_icon)
        ImageView rightIcon;

        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cardView = itemView;
        }

        public CardView getCardView() {
            return cardView;
        }

        public void setCardView(CardView cardView) {
            this.cardView = cardView;
        }

        public TextView getDesc() {
            return desc;
        }

        public void setDesc(TextView desc) {
            this.desc = desc;
        }

        public ImageView getAvatar() {
            return avatar;
        }

        public void setAvatar(ImageView avatar) {
            this.avatar = avatar;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public ImageView getRightIcon() {
            return rightIcon;
        }

        public void setRightIcon(ImageView rightIcon) {
            this.rightIcon = rightIcon;
        }
    }
}
