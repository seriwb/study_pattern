package box.white.pattern.memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Gamerの状態を表すクラス
 *
 * role:Memento（記念品）
 */
public class Memento {

    /**
     * 所持金
     */
    int money;

    /**
     * フルーツ
     */
    ArrayList<String> fruits;

    /**
     * 所持金を得る（narrow interface）
     * @return 所持金
     */
    public int getMoney() {
        return money;
    }

    /**
     * コンストラクタ（wide interface）
     * @param money 所持金
     */
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    /**
     * フルーツを追加する（wide interface）
     * @param fruit 追加するフルーツ
     */
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    /**
     * フルーツを得る（wide interface）
     * @return 取得しているフルーツ
     */
    @SuppressWarnings("unchecked")
    List<String> getFruits() {
        return (List<String>)fruits.clone();
    }
}
