import javafx.scene.layout.VBox;
import java.util.*;
import java.text.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;

public class GuessingGame extends VBox {

    //GraphicsContext being used
    GraphicsContext contGraph;
    //label to declare the winner
    Label gameLabel;

    //2d array that holds the buttons
    Button[][] buttonArray;
    GridPane paneForGameButton;

    public GuessingGame()
    {
        gameLabel = new Label("Welcome to the Game!");
        buttonArray = new Button[4][4];
        //building rootBase pane to add
        paneForGameButton = new GridPane();

        //building rootBaseBase pane to add
        FlowPane rootBase = new FlowPane(); //building rootBase pane to add
        rootBase.setPrefSize(500, 500);

        //building graphic contGraph to draw on pane
        Canvas canvas = new Canvas(500, 500);
        contGraph = canvas.getGraphicsContext2D();

        //game label being create
        gameLabel.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        rootBase.setAlignment(Pos.TOP_CENTER);
        gameLabel.setPrefSize(500, 10);
        rootBase.setVgap(30);
        rootBase.getChildren().add(gameLabel);

        //filling the 2d array with buttons using a nested for loop
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttonArray[i][j] = new Button();
                buttonArray[i][j].setPrefSize(100, 100);
                paneForGameButton.add(buttonArray[i][j], j, i);
                buttonArray[i][j].setOnAction(new gameButtonListener());

            }
        }

        //adding all the component in gridpane button to the rootBasepane
        rootBase.getChildren().add(paneForGameButton);
        //start adding elements created to the canvas
        rootBase.getChildren().add(canvas);

        //adds to root in Main.java
        getChildren().add(rootBase);

    }

    //event Listener/command execution gameButtonListener
    public class gameButtonListener implements EventHandler < ActionEvent > {

        public void handle(ActionEvent event) {
//looks for the node of each row and selects the even happening there that gets stored as an int
            int row = paneForGameButton.getRowIndex((Node) event.getSource());
            //looks for the node of each column and selects the even happening there that gets stored as an int

            int column = paneForGameButton.getColumnIndex((Node) event.getSource());

            buttonArray[row][column].setVisible(false);
            int countMoves = 0;

            //looking at the buttons on the right of the clicked button
            if (column + 1 <= 3 && buttonArray[row][column + 1].isVisible()) {
                buttonArray[row][column + 1].setVisible(false);
                countMoves += 1;
            } else if (column + 1 <= 3 && buttonArray[row][column + 1].isVisible() == false) {
                buttonArray[row][column + 1].setVisible(true);
                countMoves -= 1;
            }

            //looking at the buttons on the top of the clicked button
            if (row + 1 <= 3 && buttonArray[row + 1][column].isVisible()) {
                buttonArray[row + 1][column].setVisible(false);
                countMoves += 1;
            } else if (row + 1 <= 3 && buttonArray[row + 1][column].isVisible() == false) {
                buttonArray[row + 1][column].setVisible(true);
                countMoves -= 1;
            }

            //looking at the buttons on the bottom of the clicked button
            if (row - 1 >= 0 && buttonArray[row - 1][column].isVisible()) {
                buttonArray[row - 1][column].setVisible(false);
                countMoves += 1;

            } else if (row - 1 >= 0 && buttonArray[row - 1][column].isVisible() == false) {
                buttonArray[row - 1][column].setVisible(true);
                countMoves -= 1;
            }

            //looking at the buttons on the left of the clicked button
            if (column - 1 >= 0 && buttonArray[row][column - 1].isVisible()) {
                buttonArray[row][column - 1].setVisible(false);
                countMoves += 1;
            } else if (column - 1 >= 0 && buttonArray[row][column - 1].isVisible() == false) {
                buttonArray[row][column - 1].setVisible(true);
                countMoves -= 1;
            }

            countMoves += countMoves;

            System.out.println(countMoves + countMoves);

            //booelan expr to test if all the button are invisible, if they are set the win label on
            boolean pass = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!(buttonArray[i][j].isVisible() == false)) {
                        pass = false;
                    }
                }

                if (pass == true) {
                    //set the text to you win
                    gameLabel.setText("You Win!");
                }

            }
        }

    } // gameButtonListener ends here

}
