package box.white.pattern.bridge;

/**
 * 実装のクラス階層
 * 「表示する」クラス
 *
 * Implementor（実装者）の役
 */
public abstract class DisplayImpl {

    // 前処理
    public abstract void rawOpen();

    // 表示
    public abstract void rawPrint();

    // 後処理
    public abstract void rawClose();
}
