package box.white.pattern.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ゲームを行う主人公のクラス
 * Mementoのインスタンスを作る。
 *
 * role:Originator（作成者）
 */
public class Gamer {

    private int money;
    private List<String> fruits = new ArrayList<>();

    /**
     * フルーツの名の表
     */
    private static String[] fruitsname= {
        "リンゴ", "ぶどう", "バナナ", "みかん",
    };

    public Gamer(int money) {
        this.money = money;
    }

    /**
     * @return 現在の所持金
     */
    public int getMoney() {
        return money;
    }

    /**
     * 賭ける（ゲームの進行）
     * サイコロを振って出た目によって、所持金かフルーツが変動する。
     */
    public void bet() {
        int dice = ThreadLocalRandom.current().nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ（" + f + "）をもらいました。");
            fruits.add(f);
        } else {
            System.out.println("何も起こりませんでした。");
        }
    }

    /**
     * おいしいフルーツを保存
     * @return スナップショット
     */
    public Memento createMemento() {
        Memento m = new Memento(money);
        fruits.stream()
            .filter(f -> f.startsWith("おいしい"))
            .forEach(f -> m.addFruit(f));
        return m;
    }

    /**
     * アンドゥの実施
     * @param memento スナップショット
     */
    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    /**
     * おいしいフルーツか普通のフルーツを1つ得る
     * @return フルーツ
     */
    private String getFruit() {
        String prefix = "";
        if (ThreadLocalRandom.current().nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[ThreadLocalRandom.current().nextInt(fruitsname.length)];
    }
}
