import java.util.*;

public class RockPaperScissors {

    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMove = new String[5];
        String[] computerMove = new String[5];
        String[] result = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) +
                             " - Enter Rock/Paper/Scissors: ");
            playerMove[i] = sc.next();

            computerMove[i] = moves[r.nextInt(3)];
            result[i] = playRound(playerMove[i], computerMove[i]);

            System.out.println("Computer: " + computerMove[i]);
            System.out.println("Result: " + result[i]);

            if (result[i].equals("Player Wins"))
                wins++;
            else if (result[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\n----- Final Summary -----");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                          "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++)
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                              i + 1, playerMove[i],
                              computerMove[i], result[i]);

        double winPercentage = wins * 100.0 / 5;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");

        sc.close();
    }
}