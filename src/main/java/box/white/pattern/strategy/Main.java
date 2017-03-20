package box.white.pattern.strategy;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Taro", new WinningStrategy());
        Player player2 = new Player("Hana", new ProbStrategy());

        IntStream.range(0, 10000).forEach(i -> fight(player1, player2));

        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }

    static void fight(Player player1, Player player2) {
        Hand nextHand1 = player1.nextHand();
        Hand nextHand2 = player2.nextHand();

        if (nextHand1.isStrongerThen(nextHand2)) {
            System.out.println("Winner:" + player1);
            player1.win();
            player2.lose();
        } else if (nextHand2.isStrongerThen(nextHand1)) {
            System.out.println("Winner:" + player2);
            player1.lose();
            player2.win();
        } else {
            System.out.println("Even...");
            player1.even();
            player2.even();
        }
    }
}
