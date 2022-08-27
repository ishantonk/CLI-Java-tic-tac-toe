import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char player, user, computer;
    public static void main (String[] args) {
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        Scanner input = new Scanner(System.in);

        getUserSymbol(input);

        do userMove(board, input); while (isGameNotOver(board));

    }


    private static boolean isGameNotOver(char[][] board) {
        if (isWinner(board, user)) {
            System.out.println("User wins!");
            return false;
        }if (isWinner(board, computer)) {
            System.out.println("Computer wins!");
            return false;
        }
        for (int i=0; i<3; i++) {
            if (board[i][0] == ' ') {
                return true;
            }
            if (board[i][1] == ' ') {
                return true;
            }
            if (board[i][2] == ' ') {
                return true;
            }
        }
        System.out.println("It's a tie!");
        return false;
    }

    private static boolean isWinner(char[][] board, char player) {
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||

                (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
                (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||

                (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isNotValidMove(char[][] board, String position) {
        return !switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    private static void computerMover(char[][] board) {
        Random rand = new Random();
        player = computer;
        String position;
        do {
            int ranNum = rand.nextInt(9) + 1;
            position = Integer.toString(ranNum);
        } while (isNotValidMove(board, position));
        playMove(board, position, player);
        System.out.println("Computer choose : "+ position);
    }

    private static void userMove(char[][] board, Scanner input) {
        player = user;
        System.out.print("It's your turn choose (1-9)?");
        String position;
        do {
            position = input.nextLine();
        } while (isNotValidMove(board, position));
        playMove(board, position, player);
        computerMover(board);
        printBoard(board);
    }

    private static void getComputerSymbol() {
        if (user == 'x') {
            computer = 'o';
        } else {
            computer = 'x';
        }
    }

    private static void getUserSymbol(Scanner input) {
        System.out.print("choose your symbol (press 1 for x anc press 2 for o ) : ");
        String symbol = input.nextLine();

        switch (symbol) {
            case "1" -> {
                user = 'x';
                System.out.println("Your symbol : x");
                getComputerSymbol();
            }
            case "2" -> {
                user = 'o';
                System.out.println("Your symbol : o");
                getComputerSymbol();
            }
            default -> {
                System.out.println("Enter a valid key.");
                getUserSymbol(input);
            }
        }
    }

    private static void playMove(char[][] board, String position, char player) {
        switch (position) {
            case "1" -> board[0][0] = player;
            case "2" -> board[0][1] = player;
            case "3" -> board[0][2] = player;
            case "4" -> board[1][0] = player;
            case "5" -> board[1][1] = player;
            case "6" -> board[1][2] = player;
            case "7" -> board[2][0] = player;
            case "8" -> board[2][1] = player;
            case "9" -> board[2][2] = player;
            default -> System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

}
