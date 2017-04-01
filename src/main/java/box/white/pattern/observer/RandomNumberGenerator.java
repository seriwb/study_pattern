package box.white.pattern.observer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * ランダムに数を生成するクラス
 *
 * role:ConcreteSubject（具体的な観測される側）
 * 状態が変化したことをObserverに伝える
 */
public class RandomNumberGenerator extends NumberGenerator {

    private int number = 0;

    @Override
    public int getNumber() {
        return number;
    }

    /**
     * 0-49の範囲の整数を20回生成する
     */
    @Override
    public void execute() {

        IntStream.range(0, 20).forEach(i -> {
            number = ThreadLocalRandom.current().nextInt(50);
            notifyObservers();
        });
    }
}
