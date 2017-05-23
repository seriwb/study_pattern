package box.white.pattern.memento;

import box.white.pattern.memento.game.Gamer;
import box.white.pattern.memento.game.Memento;

/**
 * role:Caretaker（世話をする人）
 */
public class Main {

    /**
     * フルーツを集めていくサイコロゲーム
     * ・ゲームは自動で進む
     * ・ゲームの主人公はサイコロを振り、その目が次の状態を決定する
     * ・いい目が出ると主人公のお金が増える
     * ・悪い目が出るとお金が減る
     * ・特にいい目が出ると、主人公はフルーツを貰う
     * ・お金がなくなったら終了
     *
     * @param args
     */
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();    // 最初の状態保持

        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);    // 回数表示
            System.out.println("現状：" + gamer);

            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

            // Mementoの取扱の決定
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("     （だいぶ増えたので、現在の状態を保存しておこう）");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("     （だいぶ減ったので、以前の状態に復帰しよう）");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }

}
