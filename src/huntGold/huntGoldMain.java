package huntGold;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
//new data
public class huntGoldMain extends VBox {

    private final int GAME_SIZE = 500;

//adding v2
    public huntGoldMain()
  {
      huntGold theHunt = new huntGold(GAME_SIZE);
      huntGoldView theHuntView = new huntGoldView(theHunt, GAME_SIZE, GAME_SIZE);

      Canvas canvas = new Canvas(500, 500);
      FlowPane root = new FlowPane();

      root.getChildren().add(theHuntView);
      root.getChildren().add(canvas);
      getChildren().add(root);
  }
}
