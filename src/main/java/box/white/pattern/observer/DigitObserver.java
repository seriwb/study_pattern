package box.white.pattern.observer;

/**
 * 数字で数を表示するクラス
 *
 * role:ConcreteObserver（具体的な観測者）
 * Subjectの現在の状態を取得して具体的な処理をする
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {

        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
