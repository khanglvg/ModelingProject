package com.cauvong.softwarearchitecture.MVVM.BindingAdapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;

import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.Views.ChatAdapter;


/**
 * Created by ijuin on 1/6/2018.
 */

public class MessageBindingAdapter
{
    @BindingAdapter({"app:messages"})
    public static void loadMessages(RecyclerView recyclerView, ObservableArrayList<MessageItemModel> messages)
    {
        ChatAdapter adapter = (ChatAdapter) recyclerView.getAdapter();
        adapter.setChatList(messages);
    }
}
