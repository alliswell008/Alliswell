package org.alliswell.demo.hashmapdemo;

/**
 * Created by Administrator on 2018/3/2.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {

//    private ConcurrentLinkedDeque<String> list;
    private ArrayList<String> list;

//    public AddTask(ConcurrentLinkedDeque<String> list) {
    public AddTask(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}