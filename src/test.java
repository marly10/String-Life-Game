
import java.util.Scanner;

public class test
{
    //we create our variables first so they can be accessed everywhere in the code
    static int boardWidth = 7;
    static int boardHeight = 7;
    static int bottomRow = boardHeight - 1;

    //game board double array
    static char[][] gameBoard = new char[boardWidth][boardHeight];

    //create our scanner for inputs
    static Scanner ourInputs = new Scanner(System.in);

    public static void main(String[] args)
    {
        //creates our board
        boardCreation();

        //tell player how to play
        System.out.println("Use 1-7 to choose which column to drop into!\n");

        //print our board
        boardPrintOut();

        //game status
        boolean flag = true;

        while(flag)
        {
            //player 1
            player1turn();

            //print board
            boardPrintOut();

            //checks if player 1 wins
            if(!DidPlayer1Win())
            {
                flag = false;
                break;
            }

            //player 2
            player2turn();
            //print board
            boardPrintOut();

            //checks if player 2 wins
            if(!DidPlayer2Win())
            {
                flag = false;
                break;
            }
        }
    }

    //creates our board
    public static void boardCreation()
    {
        for(int i = 0; i < boardWidth; i++)
        {
            for(int j = 0; j < boardHeight; j++)
            {
                gameBoard[i][j] = '.';
            }
        }
    }

    //prints our board
    public static void boardPrintOut()
    {
        for(int i = 0; i < boardWidth; i++)
        {
            for(int j = 0; j < boardHeight; j++)
            {
                System.out.print(" " + gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------\n");
    }

    //player 1's movement
    public static void player1turn()
    {
        //counter
        int counter = 0;

        System.out.println("Player 1, it is your turn!");

        //input column
        int column = ourInputs.nextInt();
        //decrement by 1 as a safety for converting to the proper number from what the user is entering
        column--;

        while(true)
        {
            //check column number
            if(column > boardWidth)
            {
                System.out.println("That is not a valid column number.");
                break;
            }
            //checks if empty
            if(gameBoard[bottomRow][column] == '.')
            {
                gameBoard[bottomRow][column] = '1';
                break;
            }
            //checks if something below, will place above
            else if(gameBoard[bottomRow][column] == '1' || gameBoard[bottomRow][column] == '2')
            {
                if(gameBoard[bottomRow - counter][column] == '.')
                {
                    gameBoard[bottomRow - counter][column] = '1';
                    break;
                }
            }
            //add counter
            counter ++;
            //full column
            if(counter == boardWidth)
            {
                System.out.println("That column is full.");
                break;
            }
        }

    }

    //player 2's movement
    public static void player2turn()
    {
        //counter
        int counter = 0;

        System.out.println("Player 2, it is your turn!");

        //input column
        int column = ourInputs.nextInt();
        //decrement by 1 as a safety for converting to the proper number from what the user is entering
        column--;

        while(true)
        {
            //check column number
            if(column > boardWidth)
            {
                System.out.println("That is not a valid column number.");
                break;
            }
            //checks if empty
            if(gameBoard[bottomRow][column] == '.')
            {
                gameBoard[bottomRow][column] = '2';
                break;
            }
            //checks if something below, will check above
            else if(gameBoard[bottomRow][column] == '1' || gameBoard[bottomRow][column] == '2')
            {
                if(gameBoard[bottomRow - counter][column] == '.')
                {
                    gameBoard[bottomRow - counter][column] = '2';
                    break;
                }
            }
            //add counter
            counter++;

            //column full
            if(counter == boardWidth)
            {
                System.out.println("That column is full.");
                break;
            }
        }
    }

    //player 1 horizontal win check
    public static boolean checkPlayer1Horizontal()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        while(flag)
        {
            //horizontally checks board
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '1')
                    {
                        counter++; //finds 1, adds 1
                    }
                    else
                    {
                        counter = 0; //no 1, sets to 0
                    }
                    if(counter >= 4)
                    {
                        System.out.println("Player 1, you win!");
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    //player 2 horizontal win check
    public static boolean checkPlayer2Horizontal()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        while(flag)
        {
            //horizontally checks board
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '2')
                    {
                        counter++; //finds 2, adds 1
                    }
                    else
                    {
                        counter = 0; //no 2, sets to 0
                    }
                    if(counter >= 4)
                    {
                        System.out.println("Player 2, you win!");
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    //player 1 vertical win check
    public static boolean checkPlayer1Vertical()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        while(flag)
        {
            //vertically checks board
            for(int i = 0; i < boardHeight; i++)
            {
                for(int j = 0; j < boardWidth; j++)
                {
                    if(gameBoard[j][i] == '1')
                    {
                        counter++; //finds 1, adds 1
                    }
                    else
                    {
                        counter = 0; //no 1, sets to 0
                    }
                    if(counter >= 4)
                    {
                        System.out.println("Player 1, you win!");
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    //player 2 vertical win check
    public static boolean checkPlayer2Vertical()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        while(flag)
        {
            //vertically check board
            for(int i = 0; i < boardHeight; i++)
            {
                for(int j = 0; j < boardWidth; j++)
                {
                    if(gameBoard[j][i] == '2')
                    {
                        counter++; //finds 2, adds 1
                    }
                    else
                    {
                        counter = 0; //no 2, sets to 0
                    }
                    if(counter >= 4)
                    {
                        System.out.println("Player 2, you win!");
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    //player 1 diagonal left win check
    public static boolean checkPlayer1DiagonalLeft()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int columnCheck = 1;
        int rowCheck = 1;

        //looks for player 1
        while(flag)
        {
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '1')
                    {
                        counter++; //finds 1, adds 1
                        check = true;
                        while(check)
                        {
                            //goes through diagonally looking for 1
                            if(i - columnCheck >= 0 && j - rowCheck >= 0)
                            {
                                if(gameBoard[i - columnCheck][j - rowCheck] == '1')
                                {
                                    counter++; //finds 1, adds 1
                                }
                            }

                            //adds 1 to checkers
                            columnCheck++;
                            rowCheck++;

                            //breaks if outside of the board
                            if(columnCheck == 0 || rowCheck == boardHeight - 1)
                            {
                                check = false;
                                break;
                            }
                            if(counter >= 4)
                            {
                                System.out.println("Player 1, you win!");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4)
                    {
                        flag = false;
                        break;
                    }

                    //resets our counter and checkers
                    counter = 0;
                    columnCheck = 1;
                    rowCheck = 1;
                }
            }
            break;
        }
        return flag;
    }

    //player 2 diagonal left win check
    public static boolean checkPlayer2DiagonalLeft()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int columnCheck = 1;
        int rowCheck = 1;

        //finds player 2
        while(flag)
        {
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '2')
                    {
                        counter++; //finds 2, adds 1
                        check = true;
                        while(check)
                        {
                            //goes through diagonally looking for 2
                            if(i - columnCheck >= 0 && j - rowCheck >= 0)
                            {
                                if(gameBoard[i - columnCheck][j - rowCheck] == '2')
                                {
                                    counter++; //finds 2, adds 1
                                }
                            }

                            //adds 1 to checkers
                            columnCheck++;
                            rowCheck++;

                            //breaks if outside board
                            if(columnCheck == 0 || rowCheck == boardHeight - 1)
                            {
                                check = false;
                                break;
                            }
                            if(counter >= 4)
                            {
                                System.out.println("Player 2, you win!");
                                check = false;
                                flag = false;
                                break;
                            }

                        }
                    }
                    if(counter >= 4)
                    {
                        flag = false;
                        break;
                    }

                    //resets our counter and checkers
                    counter = 0;
                    columnCheck = 1;
                    rowCheck = 1;
                }
            }
            break;
        }
        return flag;
    }

    //NOTE: Diagonal Right for both player 1 and player 2 seem to check for the same as Diagonal Left and I couldn't discover why
    //player 1 diagonal right win check
    public static boolean checkPlayer1DiagonalRight()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int columnCheck = 1;
        int rowCheck = 1;

        //looks for player 1
        while(flag)
        {
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '1')
                    {
                        counter++; //finds 1, adds 1
                        check = true;
                        while(check)
                        {
                            //diagonally checks for player 1
                            if(columnCheck + i <= boardWidth - 1 && rowCheck + j <= boardHeight - 1)
                            {
                                if(gameBoard[i + columnCheck][j + rowCheck] == '1')
                                {
                                    counter++; //finds 1, adds 1
                                }
                            }

                            //adds 1 to checkers
                            columnCheck++;
                            rowCheck++;

                            //breaks if out of board
                            if(columnCheck == boardWidth - 1 || rowCheck == boardHeight - 1)
                            {
                                check = false;
                                break;
                            }
                            if(counter >= 4)
                            {
                                System.out.println("Player 1, you win!");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4)
                    {
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    columnCheck = 1;
                    rowCheck = 1;
                }
            }
            break;
        }
        return flag;
    }

    //NOTE: Diagonal Right for both player 1 and player 2 seem to check for the same as Diagonal Left and I couldn't discover why
    //player 2 diagonal right win check
    public static boolean checkPlayer2DiagonalRight()
    {
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int columnCheck = 1;
        int rowCheck = 1;

        //looks for player 2
        while(flag)
        {
            for(int i = 0; i < boardWidth; i++)
            {
                for(int j = 0; j < boardHeight; j++)
                {
                    if(gameBoard[i][j] == '2')
                    {
                        counter++; //finds 2, adds 1
                        check = true;
                        while(check)
                        {
                            //diagonally checks for player 2
                            if(columnCheck + i <= boardWidth - 1 && rowCheck + j <= boardHeight - 1)
                            {
                                if(gameBoard[i + columnCheck][j + rowCheck] == '2')
                                {
                                    counter++; //finds 2, adds 1
                                }
                            }

                            //adds 1 to checkers
                            columnCheck++;
                            rowCheck++;

                            //breaks if out of board
                            if(columnCheck == boardWidth - 1 || rowCheck == boardHeight - 1)
                            {
                                check = false;
                                break;
                            }
                            if(counter >= 4)
                            {
                                System.out.println("Player 2, you win!");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4)
                    {
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    columnCheck = 1;
                    rowCheck = 1;
                }
            }
            break;
        }
        return flag;
    }

    //checks if player 1 wins (from the checks above)
    public static boolean DidPlayer1Win()
    {
        //flag
        boolean flag = true;

        //checks if any of our player checks found a win
        if(!checkPlayer1Horizontal() || !checkPlayer1Vertical() || !checkPlayer1DiagonalLeft() || !checkPlayer1DiagonalRight())
        {
            flag = false;
        }
        return flag;
    }

    //checks if player 2 wins (from checks above)
    public static boolean DidPlayer2Win()
    {
        //flag
        boolean flag = true;

        //checks if any of our player checks found a win
        if(!checkPlayer2Horizontal() || !checkPlayer2Vertical() || !checkPlayer2DiagonalLeft() || !checkPlayer2DiagonalRight())
        {
            flag = false;
        }
        return flag;
    }
}