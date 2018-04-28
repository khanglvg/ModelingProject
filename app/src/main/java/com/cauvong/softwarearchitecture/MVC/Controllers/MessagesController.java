package com.cauvong.softwarearchitecture.MVC.Controllers;

import com.cauvong.softwarearchitecture.MVC.Factories.MessageFactory;
import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVC.Models.MessagesModel;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessagesController
{
    private MessagesModel _messages;

    public MessagesController()
    {
        _messages = new MessagesModel();
    }

    public void sendMessage(String content)
    {
        if(content.equals(""))
        {
            return;
        }
        MessageItemModel message = MessageFactory.createMessage(content);
        FirebaseManager.getInstance().sendMessageToFirebase(message, message.getMessageKey());
    }

    public void setOnMessageChangeListener(IMessageListener listener)
    {
        _messages.setOnMessageChangeListener(listener);
    }

    public void destroy()
    {
        _messages.destroy();
    }
}
