import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // initialize game board as a 2D array of charactesr and fill it with spaces
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        // Save what position the user wants to select, the position the computer wants
        // to select, and a boolean "gameOver" variable that will be useful in
        // determining if the game is over or not
        int userPositionSelected = 0;
        int computerPositionSelected = 0;
        boolean gameOver = false;

        // Value can either be Person or Computer. Should also start as Person.
        String currentPlayer = "Person";

        // print the board at the start
        printgameBoard(board);

        // Game loop. If the game is over "gameOver" will be true and the loop will stop
        while (!gameOver) {
            // Check which player needs to go
            if (currentPlayer == "Person") {
                // Get input from the user
                userPositionSelected = getInputFromUser(board);
                // Then place the valid position they selected
                placeInputPosition(board, userPositionSelected, currentPlayer);
                // Change the curernt player so that the next iteration of the game loop know
                // the player changed
                currentPlayer = "Computer";
            } else {
                // Same as above, but for the computer
                computerPositionSelected = generateComputerMove(board);
                placeInputPosition(board, computerPositionSelected, currentPlayer);
                currentPlayer = "Person";
            }

            // always print the board before checking if the game ends
            printgameBoard(board);

            // Call checkWinner() to see if there is a winner and save it into a string
            String winner = checkWinner(board);

            // If checkWinner() return either Person or Computer, then print who won and
            // change "gameOver" to true
            if (winner == "Person" || winner == "Computer") {
                System.out.println(winner + " Wins!");
                gameOver = true;
                // If checkWinner() returned "Draw" then print that the game was a draw and make
                // "gameOver" to true
            } else if (winner == "Draw") {
                System.out.println("It is a Draw");
                gameOver = true;
            }
        }
    }

    public static void printgameBoard(char[][] gameBoard) {
        // Made it so the board printing was a little easier on the eyes

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

        // If the user is a user
        if (user == "Person") {
            // We change the position they want to go to into an x,y
            int[] position = indexOf2DArray(pos);
            // Place their correct character into the x,y we got earlier
            gameBoard[position[0]][position[1]] = 'X';
            // If the user is a computer
        } else {
            // Do exactly what is described above for Player
            int[] position = indexOf2DArray(pos);
            gameBoard[position[0]][position[1]] = 'O';
        }
    }

    public static String checkWinner(char[][] gameBoard) {
        // winner can either be empty (""), Player, Computer, or Draw
        // and this is all handled in the main game loop

        String winner = "";

        // Checks row 1, 2, 3
        if (gameBoard[0][0] == 'X' && gameBoard[0][1] == 'X' && gameBoard[0][2] == 'X') {
            winner = "Person";
            // Checks row 4, 5, 6
        } else if (gameBoard[1][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[1][2] == 'X') {
            winner = "Person";
            // Checks row 7, 8, 9
        } else if (gameBoard[2][0] == 'X' && gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X') {
            winner = "Person";
            // Checks column 1, 4, 7
        } else if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            winner = "Person";
            // Checks column 2, 5, 8
        } else if (gameBoard[0][1] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][1] == 'X') {
            winner = "Person";
            // Checks column 3, 6, 9
        } else if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            winner = "Person";
            // Checks diagonal 1, 5, 9
        } else if (gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X') {
            winner = "Person";
            // Checks diagonal 3, 5, 7
        } else if (gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X') {
            winner = "Person";
            // Checks row 1, 2, 3
        } else if (gameBoard[0][0] == 'O' && gameBoard[0][1] == 'O' && gameBoard[0][2] == 'O') {
            winner = "Computer";
            // Checks row 4, 5, 6
        } else if (gameBoard[1][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[1][2] == 'O') {
            winner = "Computer";
            // Checks row 7, 8, 9
        } else if (gameBoard[2][0] == 'O' && gameBoard[2][1] == 'O' && gameBoard[2][2] == 'O') {
            winner = "Computer";
            // Checks column 1, 4, 7
        } else if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            winner = "Computer";
            // Checks column 2, 5, 8
        } else if (gameBoard[0][1] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][1] == 'O') {
            winner = "Computer";
            // Checks column 3, 6, 9
        } else if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            winner = "Computer";
            // Checks diagonal 1, 5, 9
        } else if (gameBoard[0][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][2] == 'O') {
            winner = "Computer";
            // Checks diagonal 3, 5, 7
        } else if (gameBoard[0][2] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][0] == 'O') {
            winner = "Computer";
        } else {
            // count how many open spots there are by looping through the board
            // and if there are none, then return the winner as "Draw"
            int openSpots = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameBoard[i][j] == ' ') {
                        openSpots++;
                    }
                }
            }

            if (openSpots == 0) {
                winner = "Draw";
            }
        }
        return winner;
    }

    public static int generateComputerMove(char[][] gameBoard) {
        // Saved the current position the comuter can pick, generate the Random object
        int currentComputerPositionSelected = 0;
        Random r = new Random();
        boolean pickedValidMove = false;

        while (!pickedValidMove) {
            // Let the computer pick a number between 1 and 9
            int move = r.nextInt(9) + 1;
            // Get the correct x, y of the move it picked and save it
            int[] position = indexOf2DArray(move);
            // If the position it picked is blank, then save the move and allow it to break
            // the loop
            if (gameBoard[position[0]][position[1]] == ' ') {
                currentComputerPositionSelected = move;
                pickedValidMove = true;
            } else {
                // If the move is not valid, then print out what move the computer made and tell
                // it to try again
                System.out.println("Computer tried to pick spot " + move + ", but it is taken!");
                System.out.println("Try again!");
            }
        }

        return currentComputerPositionSelected;
    }

    public static int getInputFromUser(char[][] gameBoard) {

        // Save the current move the user wants to pick
        int currentPositionSelected = 0;
        boolean pickedAValidPos = false;

        while (!pickedAValidPos) {

            // Ask the user to enter a number and create a Scanner object
            System.out.println("Enter a position you want to move to (1-9)");
            Scanner scanner = new Scanner(System.in);

            // Make a try, catch block in case the user inputs something other than a valid
            // number
            try {
                // Grab the number the user selected
                currentPositionSelected = scanner.nextInt();
                // Get the correct x, y of the move they picked and save it
                int[] position = indexOf2DArray(currentPositionSelected);
                // If the number they picked is between 1 and 9 and is a free spot then break
                // out of the loop
                if (currentPositionSelected < 10 && currentPositionSelected > 0
                        && gameBoard[position[0]][position[1]] == ' ') {
                    pickedAValidPos = true;
                } else {
                    // If the number they chose is not valid, tell them it is not valid and to try
                    // again
                    System.out.println("That spot cannot be picked!");
                    System.out.println("Try again!");
                }
            } catch (Exception e) {
                // Print if the user inputted an invalid number or character
                System.out.println("Invalid number or character! ...Enter a number between (1-9)");
            }
        }

        return currentPositionSelected;
    }

    public static int[] indexOf2DArray(int pos) {

        // This is just used to turn a position the user enters
        // "9" into board[3][3],
        // "2" into board[0][1],
        // etc...

        // Index is used to iterate over the 2D array
        int index = 1;
        // This will hold the correct value in the 2D arary as a x, y
        int[] position = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // when iterating over the array, if the user position value is equal to the
                // index value, then we know where they want to stop
                if (index == pos) {
                    // Save this position as a x, y value so we can look it up later
                    position[0] = i;
                    position[1] = j;
                    return position;
                } else {
                    // If the value the user entered is not equal to the index value, then we know
                    // we need to continue to go through the array until we find the spot we're
                    // looking for
                    index++;
                    continue;
                }
            }
        }
        return position;
    }
}
