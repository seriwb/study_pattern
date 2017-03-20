package box.white.pattern.strategy;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 出す手は乱数だが、過去の勝ち負けの履歴で出す確率を変える
 * history[前回出した手][今回出す手]：勝数
 */
public class ProbStrategy implements Strategy {

    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
    };

    public ProbStrategy() {}

    @Override
    public Hand nextHand() {
        int bet = ThreadLocalRandom.current().nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][Hand.HANDVALUE_GUU]) {
            handvalue = Hand.HANDVALUE_GUU;
        } else if (bet < history[currentHandValue][Hand.HANDVALUE_GUU] + history[currentHandValue][Hand.HANDVALUE_CHO]) {
            handvalue = Hand.HANDVALUE_CHO;
        } else {
            handvalue = Hand.HANDVALUE_PAA;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;

        return Hand.getHand(handvalue);
    }

    private int getSum(int hv) {
        return IntStream.range(0, Hand.HANDS).map(i -> history[hv][i]).sum();
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++;
        } else {
            history[prevHandValue][(currentHandValue + 1) % Hand.HANDS]++;
            history[prevHandValue][(currentHandValue + 2) % Hand.HANDS]++;
        }
    }

}
