package com.cauvong.softwarearchitecture.MVC.Interfaces;

import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public interface IMessageListener
{
    void onMessageChange(ArrayList<MessageItemModel> messages);
}
