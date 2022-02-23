
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


public class Main extends Application {

    private ArrayList<Button> gameButton;

    VBox root = new VBox();

    Stage theStage;

    Button futureButton;
    Button mathButton;
    Button guessingButton;
    Button codeButton;
    Button aiButton;
    Button bstButton;
    Button infoButton;

    Button backAI, backGuess;

    Label randomText;
    Label subRandomText;
    Label space1;
    Label space2;
    Label space3;

    Text testText;

    Scene menu;
    Scene game;
    Scene shopScene, guessGameScene, aiScene, userScene;

    private final Canvas gameCanvas = new Canvas(800,600);

    //sets the menu in the program
    public void setMenu(Stage stage)
    {
        stage.setScene(userScene);
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
       System.out.println("Hello World!");
        launch(args);
    }


    public void start(Stage primaryStage)  {

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
        mathButton = new Button("Math Game(create)");
        guessingButton = new Button("Guessing Game(workOn)");
        codeButton = new Button("Code Game(create)");
        aiButton = new Button("AI Game(workOn)");
        bstButton = new Button("BST String to Integer Game");
        infoButton = new Button("How to play(create)");

        backAI = new Button("GcdMain Menu");
        backGuess = new Button("GcdMain Menu");

        //add button to array of buttons
        this.gameButton.add(futureButton);
        this.gameButton.add(mathButton);
        this.gameButton.add(guessingButton);
        this.gameButton.add(codeButton);
        this.gameButton.add(aiButton);
        this.gameButton.add(bstButton);
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

        guessingButton.setOnAction(new ButtonListener());
        aiButton.setOnAction(new ButtonListener());

        //items added to the root
        root.getChildren().addAll(randomText, space1, subRandomText, space2);//text
        root.getChildren().addAll(futureButton, mathButton, guessingButton, codeButton, aiButton, bstButton, infoButton);//button
        root.getChildren().addAll(space3, testText);

        //if hovered over is on button changes to HAND
        for(Button loopButtonEnter : this.getGameButton())
        {
            loopButtonEnter.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    menu.setCursor(Cursor.HAND);  //Change the cursor to a Hand
                    testText.setText("Close to Picking a game");
                    /*
                    Image image = new Image("batman.png");  //pass in the image path
                    scene.setCursor(new ImageCursor(image));
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

        //creating the canvas from other files(user.java)
        FlowPane userGameV = new FlowPane();
        userGameV.getChildren().add(gameCanvas);
        game = new Scene(userGameV, 500, 500);

        FlowPane userGameH = new FlowPane();
        userScene = new Scene(userGameH, 670, 550);
        //userGameH.getChildren().add(backGuess);
        backGuess.setPrefSize(100,30);
        userGameH.getChildren().add(new userInput());
        //backGuess.setOnAction(new ButtonListener());

        //creating the canvas from other files(AIGame.java)
        FlowPane aiGameV = new FlowPane();
        aiGameV.getChildren().add(gameCanvas);
        game = new Scene(aiGameV, 800, 600);

        FlowPane aiGameH = new FlowPane();
        aiScene = new Scene(aiGameH, 550, 400);
        aiGameH.getChildren().add(backAI);
        aiGameH.getChildren().add(new AIGame());
        backAI.setOnAction(new ButtonListener());

        //creating the canvas from other files(GuessingGame.java)
        FlowPane guessGameV = new FlowPane();
        guessGameV.getChildren().add(gameCanvas);
        game = new Scene(guessGameV, 500, 500);

        FlowPane guessGameH = new FlowPane();
        guessGameScene = new Scene(guessGameH, 670, 550);
        guessGameH.getChildren().add(backGuess);
        backGuess.setPrefSize(100,30);
        guessGameH.getChildren().add(new GuessingGame());
        backGuess.setOnAction(new ButtonListener());

    }

    //handler for the buttons
    public class ButtonListener implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            if(e.getSource() == guessingButton)
            {
                theStage.setScene(guessGameScene);
            }

            if(e.getSource() == aiButton)
            {
                //setShop(aiScene);
                theStage.setScene(aiScene);
            }

            if(e.getSource() == backAI || e.getSource() == backGuess)
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
