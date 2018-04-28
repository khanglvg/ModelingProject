package com.cauvong.softwarearchitecture.MVVM.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.cauvong.softwarearchitecture.MVVM.Models.MessageItemModel;
import com.cauvong.softwarearchitecture.MVVM.ViewModels.ChatViewModel;
import com.cauvong.softwarearchitecture.databinding.MvvmChatActivityBinding;
import com.cauvong.softwarearchitecture.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by Khang Le on 12/4/2017.
 */

public class ChatView extends AppCompatActivity {

    //region DECLARE VARIABLE
    private MvvmChatActivityBinding _binding;
    private ChatViewModel _viewModel;
    //endregion

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.mvvm_chat_activity);

        _binding = DataBindingUtil.setContentView(this,R.layout.mvvm_chat_activity);
        _viewModel = new ChatViewModel();
        _binding.setViewModel(_viewModel);
        _binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        _binding.recyclerView.setAdapter(new ChatAdapter());
        _binding.setActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _viewModel.destroy();
    }
}
