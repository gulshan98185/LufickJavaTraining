package com.lufick.training.call_back;

public interface MyCallBack {
    void click(int position);

    default void clickItem(String name){
        //some function
    }
}
