package box.white.pattern.strategy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 前回の勝負に勝ったら次も同じ手を出す
 */
public class WinningStrategy implements Strategy {

    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy() {}

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(ThreadLocalRandom.current().nextInt(Hand.HANDS));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }

}
