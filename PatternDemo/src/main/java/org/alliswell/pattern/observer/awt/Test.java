package org.alliswell.pattern.observer.awt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/7.
 */
public class Test {

    public static void main(String[] args) {
        Button b = new Button();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.pressed();
    }
}

class Button {

    private List<ActionListener> actionListeners = new ArrayList<ActionListener>();

    public void pressed() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        for (ActionListener l : actionListeners) {
            l.actionPerformed(event);
        }
    }

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }
}

interface ActionListener {

     void actionPerformed(ActionEvent event);
}

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Button pressed!" + event.getWhen() + event.getSource());
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Button pressed 2!" + event.getWhen() + event.getSource());
    }
}

class ActionEvent {
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }
}


class Test2 {
    static int i = 0, j = 0;
    static synchronized void one() { i++; j++; }
    static synchronized void two() {
        System.out.println("i=" + i + " j=" + j);
    }
}