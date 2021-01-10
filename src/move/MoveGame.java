package move;

import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.animation.*;
import java.util.*;
import java.net.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.shape.*;

public class MoveGame extends Canvas {

    MoveGameLevel level;

    private int X = 160;
    private int Y = 110;

    private int newX = 0;
    private int newY = 0;
    private long preTime = 0;

    //instance of the AnimationHandler

    GraphicsContext gc = getGraphicsContext2D();

    Rectangle rectangle;

    KeyHandler os = new KeyHandler();


    public MoveGame(String firstLevel) {
        setWidth(9 * 50);
        setHeight(9 * 50);

        level = new MoveGameLevel(firstLevel);
        draw(gc);
        drawPlayer(gc);

        setOnKeyPressed(os);

    } //class constructor being used

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, 450, 450);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 450, 450);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int k = level.getData(j, i);
                if (k == 1) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(j * 50, i * 50, 50, 50);
                } else if (k == 0) {
                    gc.setFill(Color.CYAN);
                    gc.fillRect(j * 50, i * 50, 50, 50);
                }
            }
        } //end of the for loop

    } //end of the draw method

    //GETS THE PLAYER
    public void drawPlayer(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(X, Y, 50, 50);

        //String imagePath = "d.jpg";
        //Image image = new Image(imagePath);
        // gc.drawImage(image, X + 5, Y + 5, 40, 40);
    }
    //event Listener/command execution KeyHandler
    public class KeyHandler implements EventHandler < KeyEvent > {

        public void handle(KeyEvent event) {

            //prints the letter being pressed to the terminal for debug
            System.out.println("You pressed: " + event.getCode());
            System.out.println("X: " + X + " Y: " + Y);

            //event listener to start then animation
            if (event.getCode() == KeyCode.RIGHT) {
                //deletes
                draw(gc);
                //increase movement
                X += 5;

                if (X >= 425) {
                    //get the level
                    String gameLevel = level.getNextFileName(3);

                    //if ! none in file
                    if (!(gameLevel.equals("NONE"))) {

                        //gets the new level
                        level = new MoveGameLevel(gameLevel);
                        //draws lavel create
                        draw(gc);
                        X -= 435;
                        drawPlayer(gc);
                    }
                    //add player made
                    else {
                        X -= 5;
                        drawPlayer(gc);
                    }


                } else {
                    //add player made
                    drawPlayer(gc);
                }

                //add player made

            } //if ends event.getCode() == KeyCode.RIGHT

            //event listener to stop then animation
            if (event.getCode() == KeyCode.LEFT) {

                draw(gc);
                //increase movement
                X -= 5;

                if (X < 25) {
                    //get the level
                    String gameLevel = level.getNextFileName(1);

                    //if ! none in file
                    if (!(gameLevel.equals("NONE"))) {

                        //gets the new level
                        level = new MoveGameLevel(gameLevel);
                        //draws lavel create
                        draw(gc);
                        X += 405;
                        drawPlayer(gc);
                    }
                    //add player made
                    else {
                        X-= 25;
                        drawPlayer(gc);
                    }


                } else {
                    //add player made
                    drawPlayer(gc);
                }



            } //if ends event.getCode() == KeyCode.LEFT

            //event listener to stop then animation
            if (event.getCode() == KeyCode.DOWN) {

                draw(gc);

                Y += 5;

                if (Y >= 425) {

                    String gameLevel = level.getNextFileName(2);

                    if (!(gameLevel.equals("NONE"))) {

                        level = new MoveGameLevel(gameLevel);

                        draw(gc);
                        Y -= 415;
                        //add player made
                        drawPlayer(gc);
                    } else {
                        Y -= 5;
                        drawPlayer(gc);
                    }

                } else {
                    drawPlayer(gc);
                }

            } //if ends event.getCode() == KeyCode.DOWN

            //event listener to stop then animation
            if (event.getCode() == KeyCode.UP) {

                draw(gc);

                Y -= 5;

                if (Y < 25) {

                    String gameLevel = level.getNextFileName(0);

                    if (!(gameLevel.equals("NONE"))) {

                        level = new MoveGameLevel(gameLevel);

                        draw(gc);
                        Y += 400;
                        drawPlayer(gc);

                    } else {
                        Y -= 25;
                        //add player made
                        drawPlayer(gc);
                    }

                } else {
                    drawPlayer(gc);
                }

            } //if ends event.getCode() == KeyCode.UP
        }
    } // KeyListenerDown ends here

} //lab ends here