package com.cauvong.softwarearchitecture.MVP.Models;

/**
 * Created by ijuin on 12/4/2017.
 */

public class MessageItemModel
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
    public String getSenderId()
    {
        return _senderId;
    }

    public void setSenderId(String senderId)
    {
        _senderId = senderId;
    }

    public String getMessageKey()
    {   return _messageKey;    }

    public void setMessageKey(String messageKey)
    {   this._messageKey = messageKey;  }

    public String getSenderName()
    {   return _senderName;    }

    public void setSenderName(String senderName)
    {   this._senderName = senderName;  }

    public String getContent()
    {   return _content;    }

    public void setContent(String content)
    {   this._content = content;    }

    public long getTimeStamp()
    {   return _timeStamp;    }

    public void setTimeStamp(long timeStamp)
    {   this._timeStamp = timeStamp;   }
    //endregion
}
