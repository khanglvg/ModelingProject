package com.cauvong.softwarearchitecture.interfaces;

/**
 * Created by ijuin on 12/4/2017.
 */

public interface FirebaseCallbacks<T>{
    void onNewMessage(T mesage);

    Class getType();
}
