package com.cauvong.softwarearchitecture.MVP.Factories;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.managers.FirebaseManager;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ijuin on 1/6/2018.
 */

public class MessageFactory
{
    public static MessageItemModel createMessage(String text)
    {
        MessageItemModel message = new MessageItemModel();
        message.setSenderId(FirebaseAuth.getInstance().getUid());
        message.setContent(text);
        message.setSenderName(FirebaseAuth.getInstance().getCurrentUser().getDisplayName().equals("") ? "Anonymous": FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        message.setTimeStamp(System.currentTimeMillis());
        message.setMessageKey(FirebaseManager.getInstance().getNewKey());

        return message;
    }
}
