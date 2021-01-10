import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class AIGame extends VBox {

    Pane pane;
    //GraphicsContext
    GraphicsContext contGraph;
    //radionn buttons
    RadioButton coinButton1, coinButton2, coinButton3, coinButton4;

    //label for players
    Label playerBoard = new Label();
    int myCount = 0, aiCount = 0, totalValues = 0, totalValueDraw = 15;
    //add button
    Button addCoinButton;
    Label title = new Label("");

    public AIGame()
    {
        Canvas canvas = new Canvas(400, 300);
        pane = new Pane();

        //building root to add components too
        FlowPane root = new FlowPane();
        root.setPrefSize(400, 300);
        contGraph = canvas.getGraphicsContext2D();

        playerBoard = new Label("My coins: " + myCount + " Oppenents Coins: " + aiCount);

        //radiobutton start
        coinButton1 = new RadioButton("1 coin");
        coinButton2 = new RadioButton("2 coin");
        coinButton3 = new RadioButton("3 coin");
        coinButton4 = new RadioButton("4 coin");

        ToggleGroup group1 = new ToggleGroup();

        //adding coin to toggle
        coinButton1.setToggleGroup(group1);
        coinButton2.setToggleGroup(group1);
        coinButton3.setToggleGroup(group1);
        coinButton4.setToggleGroup(group1);

        //coin locations on canvas
        coinButton1.relocate(80, 30);
        coinButton2.relocate(140, 30);
        coinButton3.relocate(205, 30);
        coinButton4.relocate(270, 30);

        //adding label to pane
        pane.getChildren().add(playerBoard);
        //adding location of player label
        playerBoard.relocate(120, 5);

        //creating add coin button
        addCoinButton = new Button("Add coins");

        //button event listen
        addCoinButton.setOnAction(new addCoinButtonButtonListener());

        //button location
        addCoinButton.relocate(170, 50);

        //adding button to pane
        pane.getChildren().add(addCoinButton);

        //fill color float
        contGraph.setFill(Color.BLACK);

        //draws 15 buttons
        drawCircle(30);


        pane.getChildren().addAll(coinButton1, coinButton2, coinButton3, coinButton4);
        root.getChildren().add(pane);
        root.getChildren().add(canvas);
        getChildren().add(root);

    }

    //method to draw the circle
    public void drawCircle(int valueAdded) {

        int location = 60;

        //deletes the circle
        contGraph.clearRect(0, 0, 400, 200);

        for (int i = 0; i < valueAdded; i++) {
            contGraph.fillOval(location, 10, 10, 10);
            location += 20;
        }

    }

    //event Listener/command execution TextFieldListener
    public class addCoinButtonButtonListener implements EventHandler< ActionEvent > {

        public void handle(ActionEvent event) {

            //if radio button 1 selected
            if (coinButton1.isSelected()) {
                totalValueDraw -= 2;
                myCount += 1; //user count
                aiCount += 1; //AI count
                playerBoard.setText("My coins: " + myCount + " Oppenents Coins: " + aiCount); //adds new data to label

                drawCircle(totalValueDraw); //redr
            }
            //if radio button 2 selected
            if (coinButton2.isSelected()) {

                totalValueDraw -= 3;

                myCount += 2;
                aiCount += 1;
                playerBoard.setText("My coins: " + myCount + " Oppenents Coins: " + aiCount);
                drawCircle(totalValueDraw);

            }

            //if radio button 2 selected
            if (coinButton3.isSelected()) {
                totalValueDraw -= 4;
                myCount += 3;
                aiCount += 1;
                playerBoard.setText("My coins: " + myCount + " Oppenents Coins: " + aiCount);
                drawCircle(totalValueDraw);

            }
            //if radio button 3 selected
            if (coinButton4.isSelected()) {
                totalValueDraw -= 5;

                myCount += 4;
                aiCount += 1;
                playerBoard.setText("My coins: " + myCount + " Oppenents Coins: " + aiCount);
                drawCircle(totalValueDraw);

            }

            //selects the losser user
            if (totalValueDraw < 0) {

                pane.getChildren().remove(addCoinButton); //removes the button
                playerBoard.setText("You loss! you took the last coin"); //userClass.User lost
            }
            //selects the winner AI
            if (totalValueDraw == 0) {
                pane.getChildren().remove(addCoinButton); //removes the button
                playerBoard.setText("AI losses! it took the last coin"); //AI losty
            }

        } // SaveButtonListener handle ends here

    } // SaveButtonListener ends here


}
