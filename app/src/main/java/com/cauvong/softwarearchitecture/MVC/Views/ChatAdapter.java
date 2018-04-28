package com.cauvong.softwarearchitecture.MVC.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.R;
import com.cauvong.softwarearchitecture.utils.MyUtils;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.BindingHolder> {
    private ArrayList<MessageItemModel> _chatList;
    private Context _context;

    ChatAdapter(Context context)
    {
        _chatList = new ArrayList<>();
        this._context =context;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(_context).inflate(R.layout.mvp_chat_row_adapter, parent, false);
        return new BindingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {

        if (_chatList.get(position).getSenderId().equals(FirebaseAuth.getInstance().getUid()))
        {
            holder.layoutLeftMessages.setVisibility(View.GONE);
            holder.layoutRightMessages.setVisibility(View.VISIBLE);

            holder.messagesTextRight.setText(_chatList.get(position).getContent());
            holder.timeMessagesRight.setText(MyUtils.convertTime(_chatList.get(position).getTimeStamp()));

        } else
        {
            holder.layoutLeftMessages.setVisibility(View.VISIBLE);
            holder.layoutRightMessages.setVisibility(View.GONE);

            holder.messagesTextLeft.setText(_chatList.get(position).getContent());
            holder.timeMessagesLeft.setText(MyUtils.convertTime(_chatList.get(position).getTimeStamp()));
        }
    }

    @Override
    public int getItemCount() {
        return _chatList.size();
    }

    public void setMessages(ArrayList<MessageItemModel> messages)
    {
        _chatList.clear();
        _chatList.addAll(messages);
        notifyDataSetChanged();
    }


    class BindingHolder extends RecyclerView.ViewHolder
    {

        private TextView messagesTextLeft, timeMessagesLeft, messagesTextRight,timeMessagesRight;
        private LinearLayout layoutLeftMessages, layoutRightMessages;

        BindingHolder(View convertView)
        {
            super(convertView);

            messagesTextLeft = convertView.findViewById(R.id.text_message_left);
            timeMessagesLeft = convertView.findViewById(R.id.text_time_messages_left);
            messagesTextRight = convertView.findViewById(R.id.text_message_right);
            timeMessagesRight = convertView.findViewById(R.id.text_time_message_right);

            layoutLeftMessages = convertView.findViewById(R.id.layout_message_left);
            layoutRightMessages = convertView.findViewById(R.id.layout_message_right);
        }
    }
}
