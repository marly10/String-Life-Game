package userClass;

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


public class UserInput extends VBox {

    // instantiating Singleton class with variable userSingleton
    static User userSingleton = User.getInstance();

    //TextField
    TextField userName, userAge, userColor;
    //GraphicsContext
    GraphicsContext contGraph;

    Canvas canvas;

    public UserInput()
    {
        //building rootBase pane to add
        FlowPane rootBase = new FlowPane();
        rootBase.setPrefSize(400, 300);

        Canvas canvas = new Canvas(400, 300);
        contGraph = canvas.getGraphicsContext2D();
        //building graphic contGraph to draw on pane

        canvas = new Canvas(400, 300);
        //TextField start
        userName = new TextField(" an A or an I");
        userName.setOnAction(new TextFieldListener());

        rootBase.getChildren().addAll(userName,canvas);
        getChildren().add(rootBase);

    }
    //event Listener/command execution TextFieldListener
    public class TextFieldListener implements EventHandler < ActionEvent > {

        public void handle(ActionEvent e) {

            //handles the string entered in box
            String userNameE = userName.getText();
            String userAgeE = userAge.getText();
            int num = Integer.parseInt(userAgeE);
            String userColorE = userColor.getText();

            userSingleton.collectUserData(userNameE, num, userColorE);

            }


    } // TextFieldListener ends here
}
