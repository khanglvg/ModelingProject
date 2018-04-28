package com.cauvong.softwarearchitecture.MVVM.Views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cauvong.softwarearchitecture.BR;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.R;
import com.cauvong.softwarearchitecture.utils.MyUtils;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/5/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.BindingHolder> {
    private ArrayList<MessageItemModel> _chatList;

    public ChatAdapter()
    {
        this._chatList = new ArrayList<>();
    }
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {
        holder.bind(_chatList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.mvvm_chat_row_adapter;
    }

    @Override
    public int getItemCount() {
        return _chatList.size();
    }

    public void setChatList(final ArrayList<MessageItemModel> chatList){
        _chatList.clear();
        _chatList.addAll(chatList);
        notifyDataSetChanged();
    }

    class BindingHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding _binding;

        BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            _binding = binding;
        }

        public void bind(MessageItemModel message)
        {
            _binding.setVariable(BR.chatMessage, message);
            _binding.executePendingBindings();
        }
    }

}