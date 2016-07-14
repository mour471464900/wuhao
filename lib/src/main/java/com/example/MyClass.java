package com.example;

public class MyClass {
    private  int c;
    private  IOkCallback callback;

    public MyClass(IOkCallback callback) {
        this.callback = callback;
    }

    public  int addNum(int a, int b){
        return  c;
    };

    public void setOnCallback(){
        callback.OnSucss(c);
    }


}
