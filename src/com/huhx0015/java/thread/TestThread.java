package com.huhx0015.java.thread;

/**
 * Created by Michael Yoon Huh on 4/21/2017.
 * Example on synchronized threads.
 * http://stackoverflow.com/questions/1085709/what-does-synchronized-mean
 */
public class TestThread extends Thread {

    String name;
    TheDemo theDemo;

    public TestThread(String name,TheDemo theDemo) {
        this.theDemo = theDemo;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        theDemo.test(name);
    }
}
