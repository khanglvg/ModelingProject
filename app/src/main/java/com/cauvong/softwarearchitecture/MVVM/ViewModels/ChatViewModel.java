package com.cauvong.softwarearchitecture.MVVM.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cauvong.softwarearchitecture.BR;
import com.cauvong.softwarearchitecture.MVVM.Factories.MessageFactory;
import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.Models.MessagesModel;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatViewModel extends BaseObservable
{
    private MessagesModel _messages;
    private String _content ="";

    public ChatViewModel()
    {
        _messages = new MessagesModel();
    }

    @Bindable
    public MessagesModel getMessageModel()
    {
        return _messages;
    }

    @Bindable
    public String getContent()
    {
        return _content;
    }

    public void setContent(String content)
    {
        _content = content;
        notifyPropertyChanged(BR.content);
    }

    public void sendMessage()
    {
        if(_content.equals(""))
        {
            return;
        }
        MessageItemModel message = MessageFactory.createMessage(_content);
        FirebaseManager.getInstance().sendMessageToFirebase(message, message.getMessageKey());
        setContent("");
    }

    public void destroy()
    {
        _messages.destroy();
    }
}
