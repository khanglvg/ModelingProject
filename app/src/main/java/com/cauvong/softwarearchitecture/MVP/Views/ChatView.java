package com.cauvong.softwarearchitecture.MVP.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.cauvong.softwarearchitecture.MVP.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVP.Presenters.ChatPresenter;
import com.cauvong.softwarearchitecture.R;

import java.util.ArrayList;

/**
 * Created by ijuin on 12/4/2017.
 */

public class ChatView extends AppCompatActivity {
    private ChatPresenter _chatPresenter;

    private EditText _chatText;

    private RecyclerView _recyclerView;
    private ChatAdapter _adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_chat_activity);

        _chatText = findViewById(R.id.edittext_chat_message);

        _recyclerView = findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        _adapter = new ChatAdapter(this);
        _recyclerView.setAdapter(_adapter);

        _chatPresenter = new ChatPresenter();
        _chatPresenter.setView(this);
    }

    public void updateMessageList(ArrayList<MessageItemModel> messages)
    {
        _adapter.setMessages(messages);
        _recyclerView.scrollToPosition(messages.size()-1);
    }

    public void onSendMessage(View v)
    {
        _chatPresenter.sendMessage(_chatText.getText().toString());
    }

    public void clearText(){
        _chatText.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _chatPresenter.destroy();
    }
}
