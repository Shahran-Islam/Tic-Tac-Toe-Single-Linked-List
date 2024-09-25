import java.util.Scanner;

public class TicTacToe {

    private final LinkedList board;
    private String currentPlayer;

    public TicTacToe() {
        this.board = new LinkedList();
        this.currentPlayer = "X";
    }

    public void switchPlayer() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!board.isBoardFull() && !gameWon) {
            board.displayBoard();
            System.out.println("Player " + this.currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (move >= 1 && move <= 9 && board.getPositionValue(move).equals(" ")) {
                board.updatePosition(move, this.currentPlayer);
                gameWon = board.checkWinCondition();

                if (!gameWon) {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        board.displayBoard();

        if (gameWon) {
            System.out.println("Player " + this.currentPlayer + " wins!");
        } else {
            System.out.println("Draw");
        }

        System.out.println("Do you want to play again? (y/n): ");
        char playAgain = scanner.next().charAt(0);
        if (playAgain == 'y' || playAgain == 'Y') {
            board.resetBoard();
            this.currentPlayer = "X";
            playGame();
        } else {
            System.out.println("Bye Bye");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
