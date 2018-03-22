package org.alliswell.demo.hashmapdemo;

/**
 * Created by Administrator on 2018/3/2.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class RemoveTask implements Runnable {

//    private ConcurrentLinkedDeque<String> list;
    private ArrayList<String> list;

//    public RemoveTask(ConcurrentLinkedDeque<String> list) {
    public RemoveTask(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 5000; i++) {
////            list.pollFirst();
////            list.pollLast();
//            list.remove(list.size() - 1);
//            list.remove(list.size() - 1);
//        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            list.remove(s);
        }
    }
}
