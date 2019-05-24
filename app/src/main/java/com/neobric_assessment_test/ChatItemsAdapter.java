package com.neobric_assessment_test;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.text.SpannedString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.neobric_assessment_test.emoji_utils.EmojiUtils;

import java.util.List;

public class ChatItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static String EMAIL_STRING = "EMAIL";
    public static String CHAT_STRING = "CHAT";
    public static String OFFNETEMAIL_STRING = "OFFNETEMAIL";
    public static String CHATGIPHY_STRING = "CHATGIPHY";
    public static String CHATEMOJI_STRING = "CHATEMOJI";

    private static final int TYPE_EMAIL = 1;
    private static final int TYPE_CHAT = 2;
    private static final int TYPE_OFFNETEMAIL = 3;
    private static final int TYPE_CHATGIPHY = 4;
    private static final int TYPE_CHATEMOJI = 5;
    private final Activity parentActivity;

    private List<ItemsModelClass> itemList;

    private static final String gifPlaceHolderImage = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7360e81d-2e05-46eb-8d5d-3b1fdc0e20a3/d61wi32-baeae2c9-ddbb-4826-8c65-d7c30f4baaff.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzczNjBlODFkLTJlMDUtNDZlYi04ZDVkLTNiMWZkYzBlMjBhM1wvZDYxd2kzMi1iYWVhZTJjOS1kZGJiLTQ4MjYtOGM2NS1kN2MzMGY0YmFhZmYuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.aQMJhniKkDEX1SQ_tpQpc1DBLbRv08ZPw7U3pKLcX24";

    // Constructor of the class
    public ChatItemsAdapter(
            Activity parentActivity, List<ItemsModelClass> itemList) {
        this.parentActivity = parentActivity;
        this.itemList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    // determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
        ItemsModelClass item = itemList.get(position);
        if (item.getMessageType().equals(EMAIL_STRING)) {
            return TYPE_EMAIL;
        } else if (item.getMessageType().equals(CHAT_STRING)) {
            return TYPE_CHAT;
        }
        if (item.getMessageType().equals(OFFNETEMAIL_STRING)) {
            return TYPE_OFFNETEMAIL;
        }
        if (item.getMessageType().equals(CHATGIPHY_STRING)) {
            return TYPE_CHATGIPHY;
        }
        if (item.getMessageType().equals(CHATEMOJI_STRING)) {
            return TYPE_CHATEMOJI;
        } else {
            return -1;
        }
    }


    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_EMAIL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_email, parent, false);
            return new ViewHolderEmail(view);
        } else if (viewType == TYPE_CHAT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_chat, parent, false);
            return new ViewHolderChat(view);
        } else if (viewType == TYPE_OFFNETEMAIL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_offnetemail, parent, false);
            return new ViewHolderOffneteMail(view);
        } else if (viewType == TYPE_CHATGIPHY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_giphy, parent, false);
            return new ViewHolderChatGiphy(view);
        } else if (viewType == TYPE_CHATEMOJI) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_emoji, parent, false);
            return new ViewHolderChatEmoji(view);
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int listPosition) {
        switch (holder.getItemViewType()) {
            case TYPE_EMAIL:
                initLayoutEmail((ViewHolderEmail) holder, listPosition);
                break;
            case TYPE_CHAT:
                initLayoutChat((ViewHolderChat) holder, listPosition);
                break;
            case TYPE_OFFNETEMAIL:
                initLayoutOffneteMail((ViewHolderOffneteMail) holder, listPosition);
                break;
            case TYPE_CHATGIPHY:
                initLayoutGiphy((ViewHolderChatGiphy) holder, listPosition);
                break;
            case TYPE_CHATEMOJI:
                initLayoutEmoji((ViewHolderChatEmoji) holder, listPosition);
                break;
            default:
                break;
        }
    }

    private void initLayoutEmail(ViewHolderEmail holder, int pos) {
        holder.titleTV.setText(itemList.get(pos).getFirstName() + " " + itemList.get(pos).getLastName());
        holder.subjectTV.setText(Html.fromHtml(itemList.get(pos).getContent()));
    }

    private void initLayoutChat(ViewHolderChat holder, int pos) {
        holder.titleTV.setText(itemList.get(pos).getFirstName() + " " + itemList.get(pos).getLastName());
        holder.contentTV.setText(itemList.get(pos).getContent());
    }

    private void initLayoutOffneteMail(ViewHolderOffneteMail holder, int pos) {
        holder.titleTV.setText(itemList.get(pos).getFirstName() + " " + itemList.get(pos).getLastName());
        holder.mailContentTV.setText(Html.fromHtml(itemList.get(pos).getContent()));
    }

    private void initLayoutGiphy(ViewHolderChatGiphy holder, int pos) {
        holder.titleTV.setText(itemList.get(pos).getFirstName() + " " + itemList.get(pos).getLastName());
        String contentValue = itemList.get(pos).getContent();
        if (contentValue.startsWith("<")) {
            contentValue = contentValue.substring(1);
        }
        if (contentValue.endsWith(">")) {
            contentValue = contentValue.substring(0, contentValue.length() - 1);
        }
        String[] splitValues = contentValue.split("\\|");
        String[] splitImages = splitValues[1].split(":480X206:360X155:");
        if (splitValues.length >= 2) {
            Glide.with(parentActivity).load(splitImages[0])
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.giphyIV);
        }

    }

    private void initLayoutEmoji(ViewHolderChatEmoji holder, int pos) {
        holder.titleTV.setText(itemList.get(pos).getFirstName() + " " + itemList.get(pos).getLastName());
        LoadEmojis(itemList.get(pos).getContent(), holder);

    }

    private void LoadEmojis(final String emojiData, final ViewHolderChatEmoji holder) {

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                holder.emojiTV.setText(message.obj.toString());
            }
        };

        Thread thread = new Thread() {
            @Override
            public void run() {
                //TODO : set imageView to a "pending" image
                Spanned text = new SpannedString(EmojiUtils.emojify(emojiData));
                Message message = handler.obtainMessage(1, text);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }

    // Static inner class to initialize the views of rows
    static class ViewHolderEmail extends RecyclerView.ViewHolder {
        public TextView titleTV, subjectTV;

        public ViewHolderEmail(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            subjectTV = itemView.findViewById(R.id.subjectTV);
        }
    }

    static class ViewHolderChat extends RecyclerView.ViewHolder {
        public TextView titleTV, contentTV;

        public ViewHolderChat(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            contentTV = itemView.findViewById(R.id.contentTV);
        }
    }

    static class ViewHolderOffneteMail extends RecyclerView.ViewHolder {
        public TextView titleTV, mailContentTV;

        public ViewHolderOffneteMail(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            mailContentTV = itemView.findViewById(R.id.mailContentTV);
        }
    }

    static class ViewHolderChatGiphy extends RecyclerView.ViewHolder {
        public TextView titleTV;
        private ImageView giphyIV;

        public ViewHolderChatGiphy(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            giphyIV = itemView.findViewById(R.id.giphyIV);
        }
    }

    static class ViewHolderChatEmoji extends RecyclerView.ViewHolder {
        public TextView titleTV;
        public TextView emojiTV;

        public ViewHolderChatEmoji(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            emojiTV = itemView.findViewById(R.id.emojiTV);
        }
    }
}