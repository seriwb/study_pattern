package box.white.pattern.strategy;

/**
 *
 * 役割：
 * @author seri
 */
public class Hand {

    public static final int HANDVALUE_GUU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;
    public static final int HANDS = 3;

    public static final Hand[] hand = {
        new Hand(HANDVALUE_GUU),
        new Hand(HANDVALUE_CHO),
        new Hand(HANDVALUE_PAA),
    };

    private static final String[] name = {
        "グー", "チョキ", "パー"
    };

    /** じゃんけんの手の値 */
    private int handvalue;

    public Hand(int handvalue) {
        this.handvalue = handvalue;
    }

    public static Hand getHand(int handvalue) {
        return hand[handvalue];
    }

    public boolean isStrongerThen(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThen(Hand h) {
        return fight(h) == -1;
    }

    /**
     * @param h 相手の手
     * @return win:1, even:0, lose:-1
     */
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % HANDS == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handvalue];
    }
}
