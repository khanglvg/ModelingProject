package com.cauvong.softwarearchitecture.MVP.Presenters;

import com.cauvong.softwarearchitecture.MVP.Factories.MessageFactory;
import com.cauvong.softwarearchitecture.MVP.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVP.Models.MessagesModel;
import com.cauvong.softwarearchitecture.MVP.Views.ChatView;
import com.cauvong.softwarearchitecture.interfaces.FirebaseCallbacks;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatPresenter implements IMessageListener {
    private ChatView _view;
    private MessagesModel _messages;

    public void setView(ChatView view) {
        _view = view;
        _messages = new MessagesModel();
        _messages.setOnMessageChangeListener(this);
    }

    public void sendMessage(String content)
    {
        if(content.equals(""))
        {
            return;
        }
        MessageItemModel message = MessageFactory.createMessage(content);
        FirebaseManager.getInstance().sendMessageToFirebase(message, message.getMessageKey());
        _view.clearText();
    }

    public void destroy(){
        _messages.destroy();
    }

    @Override
    public void onMessageChange(ArrayList<MessageItemModel> messages) {
        _view.updateMessageList(messages);
    }
}
