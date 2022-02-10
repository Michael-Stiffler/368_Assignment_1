import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        // initialize game board as a 2D array of charactesr and fill it with spaces
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        int userPositionSelected = 0;
        int computerPositionSelected = 0;
        boolean gameOver = false;

        // Value can either be Person or Computer. Should also start as Person.
        String currentPlayer = "Person";

        //print the board at the start
        printgameBoard(board);

        while (!gameOver) {
            if (currentPlayer == "Person") {
                userPositionSelected = getInputFromUser(board);
                placeInputPosition(board, userPositionSelected, currentPlayer);
                // currentPlayer = "Computer";
            } else {
                //TODO

                //Make it so the computer can make a move
                computerPositionSelected = generateComputerMove(board);
                
                placeInputPosition(board, computerPositionSelected, currentPlayer);
                //currentPlayer = "Person";
            }

            //always print the board before checking if the game ends
            printgameBoard(board);

            //checkWinner();
        }
    }

    public static void printgameBoard(char[][] gameBoard) {
        //This method is complete

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
        // This method is complete

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


    public static int generateComputerMove(char[][] board) {
        int currentComputerPositionSelected = 0;
        return currentComputerPositionSelected;
    }

    public static int getInputFromUser(char[][] board) {
        //This method is complete

        //Implements the flow to get what position the user wants
        //and checks if that spot is taken or not 
        
        int currentPositionSelected = 0;
        boolean pickedAValidPos = false;

        while (!pickedAValidPos) {

            System.out.println("Enter a position you want to move to (1-9)");
            Scanner scanner = new Scanner(System.in);
            try {
                currentPositionSelected = scanner.nextInt();
                int[] position = indexOf2DArray(currentPositionSelected);
                if (currentPositionSelected < 10 && currentPositionSelected > 0
                        && board[position[0]][position[1]] == ' ') {
                    pickedAValidPos = true;
                } else {
                    System.out.println("That spot cannot be picked!");
                    System.out.println("Try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid number or character! ...Enter a number between (1-9)");
            }
        }
        
        return currentPositionSelected;
    }

    public static int[] indexOf2DArray(int pos) {
        // This method is complete

        // This is just used to turn a position the user enters
        // like "9" into board[3][3]

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
