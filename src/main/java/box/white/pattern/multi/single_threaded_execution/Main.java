package box.white.pattern.multi.single_threaded_execution;

/**
 * Single Threaded Executionパターン
 *
 * 以下の条件を満たす時にデッドロックとなる
 * ・複数のSharedResourceがある
 * ・あるSharedResourceのロックを取ったまま、別のSharedResourceのロックを取りに行く
 * ・SharedResourceのロックを取る順序が定まっていない
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
