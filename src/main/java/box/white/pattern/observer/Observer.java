package box.white.pattern.observer;

/**
 * 観測者を表すインターフェイス
 *
 * role:Observer（状態の変化を受け取って処理する側）
 */
public interface Observer {

    /**
     * 更新通知の受け取り
     *
     * @param generator 更新処理を行うクラス
     */
    public abstract void update(NumberGenerator generator);
}
