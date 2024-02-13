package designPatterns;

import java.util.*;

class Observer {
    String observerName;
    NewsObservable newsObservable;

    Observer(String observerName, NewsObservable newsObservable) {
        this.observerName = observerName;
        this.newsObservable = newsObservable;
    }

    void update() {
        String msg = this.newsObservable.getUpdate();
        System.out.println(observerName + " notified " + msg);
    }
    void setObservable(NewsObservable newsObservable) {
        this.newsObservable = newsObservable;
    }
}

class NewsObservable {
    private List<Observer> observersList = null;
    private String message;

    NewsObservable(){
        observersList = new ArrayList<>();
    }

    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observersList.add(observer);
    }

    public void unregister(Observer observer) {
        observersList.remove(observer);
    }

    public void notifyObservers() {
        if (observersList != null && !observersList.isEmpty()) {
            for (Observer observer : observersList) {
                observer.update();
            }
        } else {
            System.out.println("No observers to notify!!!");
        }
    }
    String getUpdate() {
        return message;
    }
    public void postMessage(String message) {
        System.out.println("Message posted on topic : " + message);
        this.message = message;
        notifyObservers();
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        NewsObservable commionerObservable = new NewsObservable();
        Observer batmanObserver = new Observer("batman", commionerObservable);
        Observer jokerObserver = new Observer("joker", commionerObservable);


        commionerObservable.register(batmanObserver);
        batmanObserver.setObservable(commionerObservable);

        commionerObservable.register(jokerObserver);
        jokerObserver.setObservable(commionerObservable);



        commionerObservable.postMessage("Hello Gotham !!!");

    }
}
