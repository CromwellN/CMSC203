
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button button1, button2, button3, button4, button5, button6;
	Label label1;
	TextField textfield;
	HBox hbox1, hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	DataManager datamanager = new DataManager();
	Insets insets = new Insets(5);
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("French");
		button6 = new Button("Exit");
		label1 = new Label("Feedback:");
		textfield = new TextField();
		
		// instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//  student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		hbox1.setMargin(textfield, insets);
		hbox2.setMargin(button1, insets);
		hbox2.setMargin(button2, insets);
		hbox2.setMargin(button3, insets);
		hbox2.setMargin(button4, insets);
		hbox2.setMargin(button5, insets);
		hbox2.setMargin(button6, insets);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(label1, textfield);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
		//
		// The method handle(ActionEvent event) 
		button1.setOnAction(new handler());
		button2.setOnAction(new handler());
		button3.setOnAction(new handler());
		button4.setOnAction(new handler());
		button5.setOnAction(new handler());
		button6.setOnAction(new handler());

	   }
	//Task #4:
	//  create a private inner class to handle the button clicks
	class handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			EventTarget X = event.getTarget();
			if (X == button1) {
				textfield.setText(datamanager.getHello());
			} else if (X == button2) {
				textfield.setText(datamanager.getHowdy());
			} else if (X == button3) {
				textfield.setText(datamanager.getChinese());
			} else if (X == button4) {
				textfield.setText("");
			} else if (X== button5) {
				textfield.setText(datamanager.getFrench());
			} else if (X == button6) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}