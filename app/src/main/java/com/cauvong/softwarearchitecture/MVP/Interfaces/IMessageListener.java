package com.cauvong.softwarearchitecture.MVP.Interfaces;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;

import java.util.ArrayList;

/**
 * Created by ijuin on 1/6/2018.
 */

public interface IMessageListener {
    void onMessageChange(ArrayList<MessageItemModel> messages);
}
