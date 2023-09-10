import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExtendedTruthAndDareGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        initializePlayers(players, scanner);

        boolean continuePlaying = true;
        while (continuePlaying) {
            List<String> truthQuestions = new ArrayList<>();
            List<String> dareTasks = new ArrayList<>();
            initializeQuestionsAndTasks(truthQuestions, dareTasks);

            Collections.shuffle(truthQuestions);
            Collections.shuffle(dareTasks);

            for (Player player : players) {
                System.out.println("\n" + player.getName() + "'s turn:");
                System.out.println("1. Truth");
                System.out.println("2. Dare");
                System.out.println("3. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    if (!truthQuestions.isEmpty()) {
                        String truth = truthQuestions.remove(0);
                        System.out.println(player.getName() + ", Truth: " + truth);
                        player.incrementScore();
                    } else {
                        System.out.println("No more truth questions available.");
                    }
                } else if (choice == 2) {
                    if (!dareTasks.isEmpty()) {
                        String dare = dareTasks.remove(0);
                        System.out.println(player.getName() + ", Dare: " + dare);
                        player.incrementScore();
                    } else {
                        System.out.println("No more dare tasks available.");
                    }
                } else if (choice == 3) {
                    System.out.println("Thanks for playing!");
                    continuePlaying = false;
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            }

            // Display scores at the end of each round
            System.out.println("\nScores:");
            for (Player player : players) {
                System.out.println(player.getName() + ": " + player.getScore());
            }

            // Ask if the players want to play another round
            System.out.print("\nDo you want to play another round with the same players? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                continuePlaying = false;
            }
        }

        // Display final scores and winner
        System.out.println("\nFinal Scores:");
        Player winner = players.get(0);
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        System.out.println("Winner: " + winner.getName());

        scanner.close();
    }

    private static void initializeQuestionsAndTasks(List<String> truthQuestions, List<String> dareTasks) {
        // Truth questions (at least 20)
        truthQuestions.add("Have you ever cheated on a test?");
        truthQuestions.add("What is the most embarrassing thing you've done in public?");
        truthQuestions.add("Have you ever pretended to be sick to avoid an obligation?");
        truthQuestions.add("What's your most significant pet peeve?");
        truthQuestions.add("Have you ever lied to your parents about where you were going?");
        truthQuestions.add("What's the strangest dream you've ever had?");
        truthQuestions.add("Have you ever stolen something?");
        truthQuestions.add("What's the most expensive item you've broken by accident?");
        truthQuestions.add("What's the silliest thing you've cried about?");
        truthQuestions.add("Have you ever had a crush on a teacher?");
        truthQuestions.add("What's the worst meal you've ever had to eat?");
        truthQuestions.add("Have you ever eavesdropped on someone's conversation?");
        truthQuestions.add("What's the most childish thing you still do?");
        truthQuestions.add("Have you ever pretended to like a gift you didn't like?");
        truthQuestions.add("What's the most embarrassing nickname you've ever had?");
        truthQuestions.add("Have you ever skipped school or work without telling anyone?");
        truthQuestions.add("What's the most trouble you've ever been in at school?");
        truthQuestions.add("Have you ever had a secret admirer?");
        truthQuestions.add("What's the most embarrassing text message you've sent by mistake?");
        truthQuestions.add("Have you ever been caught talking to yourself?");

        // Dare tasks (at least 20)
        dareTasks.add("Sing 'Happy Birthday' in an opera style.");
        dareTasks.add("Call a random contact and tell them a joke.");
        dareTasks.add("Do your best impression of a celebrity.");
        dareTasks.add("Dance to your favorite song for one minute.");
        dareTasks.add("Put an ice cube down your shirt and leave it there for a minute.");
        dareTasks.add("Wear socks on your hands for the next three rounds.");
        dareTasks.add("Call a pizza place and order a hamburger.");
        dareTasks.add("Speak in an accent of your choice for the next five minutes.");
        dareTasks.add("Brush your teeth with mustard.");
        dareTasks.add("Wear a toilet paper hat for the rest of the game.");
        dareTasks.add("Text your crush and confess your love for them.");
        dareTasks.add("Try to do a handstand for at least 10 seconds.");
        dareTasks.add("Wear a blindfold and try to draw a cat.");
        dareTasks.add("Speak like a robot for the next three rounds.");
        dareTasks.add("Put on lipstick without using a mirror.");
        dareTasks.add("Call your mom and sing 'I'm a Little Teapot'.");
        dareTasks.add("Wear a funny hat for the rest of the game.");
        dareTasks.add("Do 10 push-ups right now.");
        dareTasks.add("Eat a spoonful of hot sauce.");
        dareTasks.add("Call a local store and ask if they sell dragon food.");
    }

    private static void initializePlayers(List<Player> players, Scanner scanner) {
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
    }

    private static class Player {
        private String name;
        private int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void incrementScore() {
            score++;
        }
    }
}
