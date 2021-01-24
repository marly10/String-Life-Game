import math.MathGame;
import move.*;

import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.stage.Stage;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    private ArrayList<Button> gameButton;

    VBox root = new VBox();

    Stage theStage, otherStage;

    //buttons in Main(theStage)
    Button futureButton, mathButton, guessingButton, codeButton, aiButton, moveButton, infoButton, restartButton;

    //back buttons to each Scene
    Button backAI, backGuess, backMath, backMove;

    //labels used in main
    Label randomText, subRandomText, space1, space2, space3;

    Text testText;
    //scenes used in the application
    Scene menu, guessGameScene, aiScene, userScene, mathScene, moveScene;

    boolean state = true;

    //private final Canvas gameCanvas = new Canvas(800,600);

    //sets the menu in the program
    public void setMenu(Stage stage)
    {
        stage.setScene(menu);
        stage.setTitle("The String Game");
        stage.show();
    }

    //sets the shop in the program
    public void setShop(Stage stage)
    {
        stage.setScene(userScene);
        stage.show();
    }

    public static void main(String [] args)
    {
        //System.out.println("Hello World!");
        launch(args);
    }

    private void playGame()
    {
        state = false;
    }

    public void start(Stage primaryStage)  {

        //reloads the @runtime apps
        System.out.println( "state is " + state );
        playGame();
        System.out.println( "state is " + state );

        restartButton = new Button( "Restart Games" );

        restartButton.setOnAction( __ ->
        {
            System.out.println( "Restarting apps!" );
            primaryStage.close();
            Platform.runLater(() -> new Main().start( new Stage() ) );
        } );//reloads the @runtime apps(end)

        //arrayList of button
        this.gameButton = new ArrayList<Button>();

        //label text
        randomText = new Label("String Games");
        subRandomText = new Label(" A combination of different games for different users");
        space1 = new Label("");
        space2 = new Label("");
        space3 = new Label("");
        testText = new Text("");


        //button text
        futureButton = new Button("Future Prediction Game(create)");
        mathButton = new Button("Math Game(workOn)");
        guessingButton = new Button("Guessing Game");
        codeButton = new Button("Code Game(create)");
        aiButton = new Button("AI Game");
        moveButton = new Button("Move Game(create)");
        infoButton = new Button("How to play(create)");

        //button back to menu
        backAI = new Button("Main Menu");
        backGuess = new Button("Main Menu");
        backMath = new Button("Main Menu");
        backMove = new Button("Main Menu");

        //add button to array of buttons
        this.gameButton.add(futureButton);
        this.gameButton.add(mathButton);
        this.gameButton.add(guessingButton);
        this.gameButton.add(codeButton);
        this.gameButton.add(aiButton);
        this.gameButton.add(moveButton);
        this.gameButton.add(infoButton);


        //label font
        randomText.setFont(Font.font ("Verdana", 14));
        subRandomText.setFont(Font.font ("Verdana", 14));

        //button font
        for(Button setButtonFont : this.getGameButton()) {
            setButtonFont.setFont(Font.font ("Verdana", 14));
        }

        //button @override size
        for(Button setButtonSize : this.getGameButton()) {
            setButtonSize.setPrefSize(250,30);
            //setButtonSize.setPrefSize(230,30); use this one after completion
        }

        root.setAlignment(Pos.TOP_CENTER);

        //add functionality to buttons on main!
        mathButton.setOnAction(new ButtonListener());
        guessingButton.setOnAction(new ButtonListener());
        aiButton.setOnAction(new ButtonListener());
        moveButton.setOnAction(new ButtonListener());


        //items added to the root
        root.getChildren().addAll(randomText, space1, subRandomText, space2);//text
        root.getChildren().addAll(futureButton, mathButton, guessingButton, codeButton, aiButton, moveButton, infoButton, restartButton);//button
        root.getChildren().addAll(space3, testText);

        //if hovered over is on button changes to HAND
        for(Button loopButtonEnter : this.getGameButton())
        {
            loopButtonEnter.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    menu.setCursor(Cursor.HAND);  //Change the cursor to a Hand
                    testText.setText("Close to Picking a game");
                    if(loopButtonEnter == infoButton)
                    {
                        testText.setText("Information on the different Games");
                    }
                    /*
                    Image math.image = new Image("batman.png");  //pass in the math.image path
                    scene.setCursor(new ImageCursor(math.image));
                    */
                }
            });
        }
        //if hovered over is on button changes to OPEN_HAND
        for(Button loopButtonExit : this.getGameButton()) {
            loopButtonExit.setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    menu.setCursor(Cursor.OPEN_HAND);  //Change the cursor to a OPEN_HAND
                    testText.setText("Pick a game!");//changes the cash player has at Run time
                }
            });
        }

        theStage = primaryStage;
        menu = new Scene(root,800,600);
        setMenu(primaryStage);

        //creating the canvas from other files(FuturePrediction.java) - ToBeMade

        //creating the canvas from other files(math.java)
        FlowPane mathGameH = new FlowPane();
        mathScene = new Scene(mathGameH, 670, 550);
        mathGameH.getChildren().add(backMath);
        backMath.setPrefSize(100,30);
        mathGameH.getChildren().add(new MathGame());
        backMath.setOnAction(new ButtonListener());

        //creating the canvas from other files(GuessingGame.java)
        FlowPane guessGameH = new FlowPane();
        guessGameScene = new Scene(guessGameH, 670, 550);
        guessGameH.getChildren().add(backGuess);
        backGuess.setPrefSize(100,30);
        guessGameH.getChildren().add(new GuessingGame());
        backGuess.setOnAction(new ButtonListener());

        //creating the canvas from other files(CodeGame.java) - ToBeMade

        //creating the canvas from other files(AIGame.java)
        FlowPane aiGameH = new FlowPane();
        aiScene = new Scene(aiGameH, 550, 400);
        aiGameH.getChildren().add(backAI);
        aiGameH.getChildren().add(new AIGame());
        backAI.setOnAction(new ButtonListener());

        //creating the canvas from other files(MoveGame.java)
        FlowPane moveGameH = new FlowPane();
        moveScene = new Scene(moveGameH, 550, 400);
        moveGameH.getChildren().add(backMove);
        moveGameH.getChildren().add(new MoveGameMain());
        backMove.setOnAction(new ButtonListener());

    }



    //handler for the buttons
    public class ButtonListener implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            //guess scene
            if(e.getSource() == guessingButton)
            {
                theStage.setScene(guessGameScene);
            }

            //math scene
            else if(e.getSource() == mathButton)
            {
                theStage.setScene(mathScene);
            }

            //AI scene
            else if(e.getSource() == aiButton)
            {
                theStage.setScene(aiScene);
            }

            //Move scene
            else if(e.getSource() == moveButton)
            {
                //MoveGameMain.getCanvas;
                otherStage = theStage;
                otherStage.setScene(moveScene);
            }

            //back buttom (Home Scene)
            else if((e.getSource() == backAI) || (e.getSource() == backGuess) || (e.getSource() == backMath) || (e.getSource() == backMove))
            {
                setMenu(theStage);
            }
        }
    }

    //returns the button in ArrayList
    public ArrayList<Button>getGameButton()
    {
        return gameButton;
    }
}
