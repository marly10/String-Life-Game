package math;


import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class MathGame extends VBox{

    public HashMap<String, String> capitalCities = new HashMap<String, String>();

    Image image;
    ImageView imageView;


    public MathGame()
    {

        capitalCities.put("math/image/img.png", "−0.035");

        String gg = capitalCities.get("USA");

        image = new Image("math/image/img.png");
        imageView = new ImageView(image);

        imageView.setX(50);
        imageView.setY(25);

        Canvas canvas = new Canvas(500, 500);
        FlowPane root = new FlowPane();

        root.setPrefSize(500, 500);
        root.getChildren().add(imageView);

        root.getChildren().add(canvas);

        getChildren().add(root);


       /* // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
*/
       // String gg = capitalCities.get("USA");
    }

}
