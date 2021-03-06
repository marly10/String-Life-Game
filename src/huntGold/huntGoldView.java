package huntGold;

import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class huntGoldView extends VBox implements EventHandler<InputEvent>
{

    private int width, height;
    private huntGold hunt;
    private GraphicsContext gc;

    /** Constructor
     * @param hunt the model reference
     * @param width the width of the Canvas rendering the game
     * @param height the height of the Canvas rendering the game
     */

    public huntGoldView( huntGold hunt, int width, int height )
    {
        this.hunt = hunt;
        this.width = width;
        this.height = height;
        Canvas canvas = new Canvas( width, height );
        getChildren( ).add( canvas );
        gc = canvas.getGraphicsContext2D( );

        this.setOnMouseMoved( this );
        this.setOnTouchMoved( this );
    }

    /** handle method
     * @param event the InputEvent generated by the user
     */
    public void handle( InputEvent event )
    {
        int x = -100, y = -100;

        if ( event.getEventType( ) == MouseEvent.MOUSE_MOVED )
        {
            MouseEvent mEvent = ( MouseEvent ) event ;
            x = ( int ) mEvent.getSceneX( );
            y = ( int ) mEvent.getSceneY( );
        }

        else if ( event.getEventType( ) == TouchEvent.TOUCH_MOVED )
        {
            TouchEvent tEvent = ( TouchEvent ) event ;
            x = ( int ) tEvent.getTouchPoint( ).getSceneX( );
            y = ( int ) tEvent.getTouchPoint( ).getSceneY( );
        }

        hunt.play( x, y );

        hunt.draw( gc, x , y );
        if ( hunt.isGameOver( ) )
        {
            this.setOnMouseMoved( null );
            this.setOnTouchMoved( null );
            Stage stage = ( Stage ) getScene( ).getWindow( );
            stage.setTitle( "Thank you for playing" );
        }
    }


}
