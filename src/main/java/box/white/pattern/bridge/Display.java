package box.white.pattern.bridge;

/**
 * 機能のクラス階層
 * 「表示する」クラス
 *
 * Abstraction（抽象化）の役
 */
public class Display {

    // 橋渡しの役割を担う
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
