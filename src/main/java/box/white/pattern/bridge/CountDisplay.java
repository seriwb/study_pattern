package box.white.pattern.bridge;

import java.util.stream.IntStream;

/**
 * 機能のクラス階層
 * 「指定回数だけ表示する」という機能を追加したクラス
 *
 * RefinedAbstraction（改善した抽象化）の役
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 指定の回数繰り返して表示する。
     *
     * @param times 繰り返し回数
     */
    public void multiDisplay(int times) {
        open();
        IntStream.range(0, times).forEach(i -> print());
        close();
    }
}
