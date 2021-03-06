package observer.java;

import observer.java.subject.WeatherSubject;
import observer.java.observer.MobileObserver;
import observer.java.observer.TVObserver;

import java.util.Observer;

/**
 * @author qingju.yao
 * @date 2020/4/9
 */
public class Main {

    public static void main(String[] args) {

        WeatherSubject subject = new WeatherSubject();
        subject.notice();

        new TVObserver(subject);
        subject.notice("add TVObserver");

        Observer observer = new MobileObserver(subject);
        subject.notice("add MobileObserver");

        subject.deleteObserver(observer);
        subject.notice("del MobileObserver");
    }
}
