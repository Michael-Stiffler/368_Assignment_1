import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        // initialize game board as a 2D array of charactesr and fill it with spaces
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        // Value can either be Person or Computer. Should also start as Person.
        String currentPlayer = "Person";
        printgameBoard(board);
        boolean gameOver = false;
        int currentPositionSelected = 0;

        while (!gameOver) {
            if (currentPlayer == "Person") {

                Scanner scanner = new Scanner(System.in);
                boolean pickedAValidPos = false;

                while (!pickedAValidPos) {

                    System.out.println("Enter a position you want to move to (1-9)");
                    currentPositionSelected = scanner.nextInt();
                    int[] position = indexOf2DArray(currentPositionSelected);
                    if (currentPositionSelected < 10 && currentPositionSelected > 0
                            && board[position[0]][position[1]] == ' ') {
                        pickedAValidPos = true;
                    } else {
                        System.out.println("That spot cannot be picked!");
                        System.out.println("Try again!");
                    }
                }
                placeInputPosition(board, currentPositionSelected, currentPlayer);
                // currentPlayer = "Computer";
            } else {
                currentPlayer = "Person";
            }
            printgameBoard(board);
        }
    }

    public static void printgameBoard(char[][] gameBoard) {
        System.out.println("+-----------+");
        System.out.println("| " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2] + " |");
        System.out.println("+-----------+");
        System.out.println();

    }

    public static void placeInputPosition(char[][] gameBoard, int pos, String user) {
        if (user == "Person") {
            int[] position = indexOf2DArray(pos);
            gameBoard[position[0]][position[1]] = 'X';
        } else {

        }
    }

    public static String checkWinner() {
        String winner = "";
        return winner;
    }

    public static int[] indexOf2DArray(int pos) {
        int index = 1;
        int[] position = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index == pos) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                } else {
                    index++;
                    continue;
                }
            }
        }
        return position;
    }
}
