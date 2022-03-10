package com.lufick.training.call_back;

public interface MyCallBack {
    String click(int position);
    void clickItem(String name);
    default void goForIt(int position){
    }
}
