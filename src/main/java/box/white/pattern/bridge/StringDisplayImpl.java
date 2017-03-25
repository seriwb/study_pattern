package box.white.pattern.bridge;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 実装のクラス階層
 * 「文字列を使って表示する」クラス
 *
 * ConcreteImplementor（具体的な実装者）の役
 */
public class StringDisplayImpl extends DisplayImpl {

    /**
     * 表示すべき文字列
     */
    private String string = "";

    /**
     * バイト単位で計算した文字列の幅
     */
    private int width = 0;

    public StringDisplayImpl(String string) {

        Optional.ofNullable(string).ifPresent(str -> {
            this.string = str;
            this.width = str.getBytes().length;
        });
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    /**
     * 枠の表示
     */
    private void printLine() {
        System.out.print("+");
        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println("+");
    }
}
