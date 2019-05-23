package com.neobric_assessment_test;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Nagaraju P on 21-12-2016.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private final List<ItemsModelClass> dataList;
    private final Activity parentActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTV, subjectTV;
        final ImageView chatIV;
        final LinearLayout fileLL;

        MyViewHolder(View view) {
            super(view);
            titleTV = view.findViewById(R.id.titleTV);
            subjectTV = view.findViewById(R.id.subjectTV);
            chatIV = view.findViewById(R.id.chatIV);
            fileLL = view.findViewById(R.id.fileLL);
        }
    }


    public ItemsAdapter(Activity parentActivity,
                        List<ItemsModelClass> dataList) {
        this.dataList = dataList;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ItemsModelClass dataItem = dataList.get(position);

        holder.titleTV.setText(dataItem.getFirstName() + " " + dataItem.getLastName());

        switch (dataItem.getMessageType()) {
            case "EMAIL":
                holder.subjectTV.setText(Html.fromHtml(dataItem.getContent()));
                holder.fileLL.setVisibility(View.VISIBLE);

                break;
            case "CHAT":
                holder.subjectTV.setText(dataItem.getContent());
                holder.fileLL.setVisibility(View.GONE);

                break;
            case "OFFNETEMAIL":
                holder.subjectTV.setText(Html.fromHtml(dataItem.getContent()));
                holder.fileLL.setVisibility(View.GONE);

                break;
            case "CHATEMOJI":
                holder.chatIV.setVisibility(View.VISIBLE);
                holder.fileLL.setVisibility(View.GONE);
                Glide.with(parentActivity).load(dataItem.getContent())
                        .placeholder(R.drawable.ic_launcher_background).centerCrop().into(holder.chatIV);

                break;
            case "CHATGIPHY":
                holder.chatIV.setVisibility(View.VISIBLE);
                holder.fileLL.setVisibility(View.GONE);
                Glide.with(parentActivity).load(dataItem.getContent())
                        .placeholder(R.drawable.ic_launcher_background).centerCrop().into(holder.chatIV);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}