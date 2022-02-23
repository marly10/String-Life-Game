package math;/*
Ricky McKenzie
Lab6 - #2
*/

import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Lab6Part2 extends Application {

   //ComboBox
   ComboBox lineQuantity;
   //GraphicsContext
   GraphicsContext contGraph;
   //RadioButton
   RadioButton noSpace;
   RadioButton oneSpace;
   //TextField
   TextField theBox;
   //CheckBox
   CheckBox checkBoxThick;
   //Label
   Label radioButtonlabel = new Label();

   //valueAtY and other variables used in file
   int valueAtY = 0;
   int bold = 1;
   boolean itemSelected = true;
   //start void 
   public void start(Stage stage) {

      //building rootBase pane to add
      FlowPane rootBase = new FlowPane();
      rootBase.setPrefSize(400, 300);

      Canvas canvas = new Canvas(400, 300);
      contGraph = canvas.getGraphicsContext2D();
      //building graphic contGraph to draw on pane

      //instantiating comboBox object
      lineQuantity = new ComboBox();
      contGraph.setFill(Color.BLACK);
      //event Listener/command execution
      lineQuantity.setOnAction(new ComboBoxListener());

      //specify entries:
      lineQuantity.getItems().add("10");
      lineQuantity.getItems().add("50");
      lineQuantity.getItems().add("100");

      //seeting the initial values of combobox("10")
      lineQuantity.setValue("10");

      valueAtY = 20;

      for (int i = 0; i < 10; i++) {
         contGraph.fillRect(0, valueAtY, 100, 1);
         valueAtY += 12;
      } //seeting the initial values of combobox("10") ends here

      //checkboxes start
      checkBoxThick = new CheckBox("Thick");

      //event Listener/command execution
      checkBoxThick.setOnAction(new CheckBoxListener());
      //checkboxes ends 

      //radiobutton start 
      noSpace = new RadioButton("No space");
      oneSpace = new RadioButton("1 space");

      //event Listener/command execution
      noSpace.setOnAction(new RadioButtonListener());
      oneSpace.setOnAction(new RadioButtonListener());

      //sets the 1 space radio button as defaul
      noSpace.setSelected(true);

      //radiobutton ends 

      //ToggleGroup used to group button selection
      ToggleGroup group = new ToggleGroup();
      noSpace.setToggleGroup(group);
      oneSpace.setToggleGroup(group);

      //TextField start
      theBox = new TextField(" an A or an I");
      theBox.setOnAction(new TextFieldListener());
      //TextField ends

      rootBase.setHgap(10);
      rootBase.getChildren().addAll(lineQuantity, checkBoxThick, noSpace, oneSpace, theBox);

      //start adding elements created to the canvas
      rootBase.getChildren().add(canvas);
      Scene scene = new Scene(rootBase, 400, 300);
      
      stage.setScene(scene);
      stage.setTitle("Lab#6");
      stage.show();
   }//start ends here

   //event Listener/command execution ComboBoxListener
   public class ComboBoxListener implements EventHandler < ActionEvent > {

      public void handle(ActionEvent e) {

         int valueAtY = 0;

         //switch case the value of the combobox text
         switch ((String) lineQuantity.getValue()) {

            case "100":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 100 lines
               for (int i = 0; i < 100; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 2;
               } //for loop used to draw 100 lines ends here
               break;

            case "50":
               //clears the canvas at set location
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 50 lines
               for (int i = 0; i < 50; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 3;

               } //for loop used to draw 50 lines ends here
               break;

            case "10":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 10 lines
               for (int i = 0; i < 10; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }
                  valueAtY += 12;

               } //for loop used to draw 10 lines ends here
               break;

         } //end switch statment
      }
   } // ComboBoxListener ends here

   //event Listener/command execution RadioButtonListener
   public class RadioButtonListener implements EventHandler < ActionEvent > {

      public void handle(ActionEvent e) {

         int valueAtY = 0;

         //set boolean to true or false based on selection method
         if (noSpace.isSelected()) {
            itemSelected = true;
         }
         if (oneSpace.isSelected()) {
            itemSelected = false;
         } //set boolean to true or false based on selection method ends here

         //switch case the value of the combobox text
         switch ((String) lineQuantity.getValue()) {

            case "100":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 100 lines
               for (int i = 0; i < 100; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 2;
               } //for loop used to draw 100 lines ends here
               break;

            case "50":
               //clears the canvas at set location
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 50 lines
               for (int i = 0; i < 50; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 3;

               } //for loop used to draw 50 lines ends here
               break;

            case "10":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 10 lines
               for (int i = 0; i < 10; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }
                  valueAtY += 12;

               } //for loop used to draw 10 lines ends here
               break;
         } //end switch statment
      }
   } //radio button ends here RadioButtonListener

   //event Listener/command execution TextFieldListener
   public class TextFieldListener implements EventHandler < ActionEvent > {

      public void handle(ActionEvent e) {


         if (theBox.getText().equals("A")) {
            //if A is selected param changes to select comboBox 100, 1 space, and the thick checkBox
            bold = 2;
            lineQuantity.setValue("100");
            oneSpace.setSelected(true);
            checkBoxThick.setSelected(true);

            contGraph.clearRect(0, 0, 500, 500);

            valueAtY = 20;
            //for loop used to draw 100 lines
            for (int i = 1; i <= 100; i++) {

               contGraph.fillRect(0, valueAtY, 45, bold);
               contGraph.fillRect(70, valueAtY, 45, bold);

               valueAtY += 2;
            } //end for loop 100
         } // end if statement here for letter A

 //if statement which is used to change nuneric values
         if (theBox.getText().equals("I")) {

            contGraph.clearRect(0, 0, 500, 500);

            bold = 1;
            lineQuantity.setValue("10");
            noSpace.setSelected(true);
            checkBoxThick.setSelected(false);

            valueAtY = 20;

            for (int i = 0; i < 10; i++) {

               contGraph.fillRect(0, valueAtY, 90, bold);

               valueAtY += 12;
            } //end for loop 100

         } // end if statement here for letter I

      }
   } // TextFieldListener ends here   

   //event Listener/command execution CheckBoxListener
   public class CheckBoxListener implements EventHandler < ActionEvent > {


      public void handle(ActionEvent e) {

         bold = 1;
         if (checkBoxThick.isSelected()) {
            bold = 2;
         }

         int valueAtY = 0;

         switch ((String) lineQuantity.getValue()) {

            case "100":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 100 lines
               for (int i = 0; i < 100; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 2;
               } //for loop used to draw 100 lines ends here
               break;

            case "50":
               //clears the canvas at set location
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 50 lines
               for (int i = 0; i < 50; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }

                  valueAtY += 3;

               } //for loop used to draw 50 lines ends here
               break;

            case "10":
               contGraph.clearRect(0, 0, 500, 500);

               valueAtY = 20;
               //for loop used to draw 10 lines
               for (int i = 0; i < 10; i++) {

                  if (itemSelected) {
                     contGraph.fillRect(0, valueAtY, 100, bold);
                  } else {
                     contGraph.fillRect(0, valueAtY, 45, bold);
                     contGraph.fillRect(70, valueAtY, 45, bold);
                  }
                  valueAtY += 12;

               } //for loop used to draw 10 lines ends here
               break;
         } //end switch statment

      }
   } // CheckBoxListener ends here

   public static void main(String[] args) {
      launch(args); // launch start
   }

}