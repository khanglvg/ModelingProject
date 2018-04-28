package com.cauvong.softwarearchitecture.MVVM.Models;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesModel implements FirebaseCallbacks<MessageItemModel>
{
    private ObservableArrayList<MessageItemModel> _messages;

    public void addMessage(MessageItemModel messageItemModel)
    {
        _messages.add(messageItemModel);
    }

    public ObservableArrayList<MessageItemModel> getMessages()
    {
        return _messages;
    }

    @Override
    public void onNewMessage(MessageItemModel message)
    {
        addMessage(message);
    }

    @Override
    public Class getType() {
        return MessageItemModel.class;
    }

    public MessagesModel()
    {
        _messages = new ObservableArrayList<>();
        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    public void destroy()
    {
        FirebaseManager.getInstance().removeListeners();
        FirebaseManager.getInstance().destroy();
    }
}
