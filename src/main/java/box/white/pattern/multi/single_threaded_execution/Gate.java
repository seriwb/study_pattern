package box.white.pattern.multi.single_threaded_execution;

/**
 * SharedResource役
 * 複数スレッドからアクセスされる。
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    /**
     * unsafeMethod
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    /**
     * unsafeMethod
     */
    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    /**
     * safeMethod
     */
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
