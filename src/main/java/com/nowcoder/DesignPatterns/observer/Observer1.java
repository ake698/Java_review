package com.nowcoder.DesignPatterns.observer;

/**
 * 订阅者们
 */
public class Observer1 implements Observer {

    private Subject subject;

    Observer1(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(this.getClass().getName()+"得到可靠消息："+msg);
    }

    public static void main(String[] args) {
        WXPublic wxPublic = new WXPublic();

        //关注者
        Observer1 observer1 = new Observer1(wxPublic);
        Observer2 observer2 = new Observer2(wxPublic);

        wxPublic.setMsg("first");
        wxPublic.setMsg("second");

    }
}

class Observer2 implements Observer {

    private Subject subject;

    Observer2(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(this.getClass().getName()+"得到可靠消息："+msg);
    }
}
