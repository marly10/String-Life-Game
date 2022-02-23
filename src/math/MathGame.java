package math;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class MathGame extends VBox{


    Hashtable<Integer, String> source = new Hashtable<Integer,String>();
    HashMap<Integer, String>  map = new HashMap(source);
    Image image;
    ImageView imageView;


    public MathGame()
    {

        Scanner keyInput = new Scanner(System.in);

        //variables declaration
        int number1, number2;
        boolean twoEntered = true;
        String badInput, badInput2, name;

        System.out.println("Select the Range");
  /*
            //values 1-2 for [RANGE] entered
            System.out.println("Range 1: ");
            //validate if values entered are correct[INTEGERS]
            while (!keyInput.hasNextInt())
            {
                badInput = keyInput.next();
                System.out.println("[ERROR]Enter a Number for Range 1");
            }
            number1 = keyInput.nextInt();

            System.out.println("Range 2: ");
            //validate if values entered are correct[INTEGERS]
            while (!keyInput.hasNextInt())
            {
                badInput2 = keyInput.next();
                System.out.println("[ERROR]Enter a Number for Range 2");
            }
            number2 = keyInput.nextInt();

            twoEntered = false;

            //validate if values entered are correct[INTEGERS]
            //check of values are entered properly num1 < num2 || num2 > num1
            //if values are not good, ask user for new values


            //define the number to guess in the game [RANDOM]

            //define a number within a scope of [ > 2 || 6]
            //let the user know a number has been defined
            //define number of guesses [5 GUESS]
            //let user know if the number entered [GUESS] is > than number to guess || < han number to guess
                //check if value if correct
            //update how much guesses they have.






        map = new HashMap<Integer, String>();
        map.put(4, "2+2");
        Integer key = 4;
        String value = map.get(key);
        System.out.println("Key: " + key +" value: "+ value);
        Canvas canvas = new Canvas(500, 500);
        FlowPane root = new FlowPane();
        root.setPrefSize(500, 500);
        root.getChildren().add(canvas);
        getChildren().add(root);
     // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
       // String gg = capitalCities.get("USA");
        //create an array or map of equations and result
        //read from txt, let user add numbers and result in the txt file
        //draw - paint them on the canvas
        //user gets to "check" 5 equations
        //keep track of the right & wrong answers
        //user input believed result
        //check in array db is result is correct
        //move (show another equation)*/
    }

}
