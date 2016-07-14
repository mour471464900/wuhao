package com.example;

/**
 * Created by hao on 2016/7/14.
 */
public class MyAdd {
    public  static   void  main(String [] args){
          new MyClass(new IOkCallback() {
              @Override
              public void OnSucss(int c) {
                  System.out.println(c);
              }
          });
    }
}
