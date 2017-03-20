package box.white.pattern.strategy;

public class Player {

    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(name).append(":").append(gamecount).append(" games, ");
        sb.append(wincount).append(" win, ").append(losecount).append(" lose]");

        return sb.toString();
    }
}
