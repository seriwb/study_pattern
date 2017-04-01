package box.white.pattern.observer;

import java.util.ArrayList;

/**
 * 数を生成するオブジェクトを表す抽象クラス
 *
 * role:Subject（観測される側）
 * Observerに通知する「現在の状態」を取得することができる
 */
public abstract class NumberGenerator {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Observerへ通知する
     */
    public void notifyObservers() {
        observers.stream().forEach(o -> o.update(this));
    }

    /**
     * 数を取得する（現在の状態の取得）
     *
     * @return 数
     */
    public abstract int getNumber();

    /**
     * 数を生成する
     */
    public abstract void execute();
}
