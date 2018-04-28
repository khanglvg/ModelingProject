package com.cauvong.softwarearchitecture.MVVM.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cauvong.softwarearchitecture.BR;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class MessageItemModel extends BaseObservable
{
    private String _senderId;
    private String _messageKey;
    private String _senderName;
    private String _content;
    private long _timeStamp;

    public MessageItemModel()
    {    }

    public MessageItemModel(String senderId, String messageKey, String senderName, String content, long timeStamp)
    {
        this._senderId = senderId;
        this._messageKey = messageKey;
        this._senderName = senderName;
        this._content = content;
        this._timeStamp = timeStamp;
    }

    //region GET-SET
    @Bindable
    public String getSenderId()
    {
        return _senderId;
    }

    public void setSenderId(String senderId)
    {
        _senderId = senderId;
    }

    @Bindable
    public String getMessageKey()
    {   return _messageKey;    }

    public void setMessageKey(String messageKey)
    {
        this._messageKey = messageKey;
        notifyPropertyChanged(BR.messageKey);
    }

    @Bindable
    public String getSenderName()
    {   return _senderName;    }

    public void setSenderName(String senderName)
    {
        this._senderName = senderName;
        notifyPropertyChanged(BR.senderName);
    }

    @Bindable
    public String getContent()
    {   return _content;    }

    public void setContent(String content)
    {
        this._content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public long getTimeStamp()
    {   return _timeStamp;    }

    public void setTimeStamp(long timeStamp)
    {
        this._timeStamp = timeStamp;
        notifyPropertyChanged(BR.timeStamp);
    }

    @Bindable
    public boolean isMine()
    {
        return _senderId.equals(FirebaseAuth.getInstance().getUid());
    }
    //endregion
}
