package box.white.pattern.observer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * *で数を表示するクラス
 *
 * role:ConcreteObserver（具体的な観測者）
 * Subjectの現在の状態を取得して具体的な処理をする
 */
public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {

        String asters = IntStream.range(0, generator.getNumber())
                .mapToObj(i -> "*")
                .collect(Collectors.joining());
        // ↓と同じこと
        // String asters = StringUtils.repeat("*", generator.getNumber());
        // https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html#repeat-java.lang.String-int-

        System.out.println("GraphObserver:".concat(asters));
    }

}
