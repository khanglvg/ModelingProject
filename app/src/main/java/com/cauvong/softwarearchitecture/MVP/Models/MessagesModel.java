package com.cauvong.softwarearchitecture.MVP.Models;

import com.cauvong.softwarearchitecture.MVP.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class MessagesModel implements FirebaseCallbacks<MessageItemModel>
{
    private ArrayList<MessageItemModel> _messages;
    private IMessageListener _onMessageChange;

    public void addMessage(MessageItemModel messageItemModel)
    {
        _messages.add(messageItemModel);

        if(_onMessageChange != null)
        {
            _onMessageChange.onMessageChange(_messages);
        }
    }

    public void setOnMessageChangeListener(IMessageListener listener)
    {
        this._onMessageChange = listener;
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
        _messages = new ArrayList<>();
        FirebaseManager.getInstance().setCallback(this);
        FirebaseManager.getInstance().addMessageListeners();
    }

    public void destroy()
    {
        FirebaseManager.getInstance().removeListeners();
        FirebaseManager.getInstance().destroy();
    }
}
