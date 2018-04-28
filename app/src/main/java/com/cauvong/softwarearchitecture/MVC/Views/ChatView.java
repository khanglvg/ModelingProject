package com.cauvong.softwarearchitecture.MVC.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.cauvong.softwarearchitecture.MVC.Controllers.MessagesController;
import com.cauvong.softwarearchitecture.MVC.Interfaces.IMessageListener;
import com.cauvong.softwarearchitecture.MVC.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.R;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatView extends AppCompatActivity
        implements IMessageListener
{
    private EditText _edtContent;
    private MessagesController _controller;
    private RecyclerView _recyclerView;
    private ChatAdapter _adapter;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.mvc_chat_activity);

        _edtContent = findViewById(R.id.edittext_chat_message);

        _recyclerView = findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        _adapter = new ChatAdapter(this);
        _recyclerView.setAdapter(_adapter);

        _controller = new MessagesController();
        _controller.setOnMessageChangeListener(ChatView.this);
    }

    public void onSend(View v)
    {
        _controller.sendMessage(_edtContent.getText().toString());
        clearText();
    }

    @Override
    public void onMessageChange(ArrayList<MessageItemModel> messages)
    {
        _adapter.setMessages(messages);
        _recyclerView.scrollToPosition(messages.size()-1);
    }


    public void clearText(){
        _edtContent.setText("");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        _controller.destroy();
    }

}
