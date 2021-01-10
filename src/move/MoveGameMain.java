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

public class MoveGameMain extends FlowPane {

    Canvas c;

    public MoveGameMain(){

        FlowPane fp = new FlowPane();
        fp.setAlignment(Pos.CENTER);
        Canvas c = new MoveGame("00.txt");

        Label r = new Label("me");

        fp.getChildren().add(c);


        Scene scene = new Scene(fp, 450, 450);

        c.requestFocus();

        getChildren().add(fp);

    }

    public Canvas getCanvas()
    {
        return c;
    }
}
