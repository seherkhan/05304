package myCalc;/**
 * Created by Seher Khan on 8/24/2017.
 */

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Test extends Application {
    @FXML
    Button btn;

    @FXML
    TextField textField;

    @FXML
    Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TestWindow.fxml"));
        primaryStage.setScene(new Scene(root, 500,200));
        primaryStage.show();
    }

    @FXML public void handleBtnEvent(Event e){
        btn.setText("Clicked!");
        textField.setText("Something happened");
        label.setText("Whaddup bud?");
    }

    @FXML public void handleResetEvent(Event e){
        btn.setText("Button");
        textField.setText("");
        label.setText("");
    }
}
