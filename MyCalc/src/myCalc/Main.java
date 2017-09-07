

package myCalc;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

//TO DO figure out decimal places. 1.23-1 should return 0.23

public class Main extends Application implements Initializable{

    @FXML TextField textField;
    Double a;
    String inputStr="";
    char lastOperation='x';

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MyCalc.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("ButtonApp.fxml"));
        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(Main.class.getResource("Calc.css").toExternalForm());
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

        textField.textProperty().addListener(
                (observable,oldValue,newValue)->{
                    if(newValue.matches("\\S|^-?\\d*\\.?\\d*$|ERROR")){
                    }
                    else{
                        textField.setText(oldValue);
                        inputStr=oldValue;
                    }
                });
    }
    public void keyPressed(KeyEvent e) {
        String key= String.valueOf(e.getCode());
            if(key.equals("ENTER")||key.equals("EQUALS"))  equalsPressed();
            else if(key.equals("BACK_SPACE")||key.equals("DELETE")) delPressed();
            else if(key.equals("ADD")) addPressed();
            else if(key.equals("SUBTRACT")||key.equals("MINUS")) subtractPressed();
            else if(key.equals("MULTIPLY")) multiplyPressed();
            else if(key.equals("DIVIDE")||key.equals("SLASH")) dividePressed();
            else if(key.equals("DECIMAL")||key.equals("PERIOD")) decimalPressed();
            else if(key.startsWith("NUMPAD")||key.startsWith("DIGIT")) numPressed(e);
            else if(key.equals("ESCAPE")){
                Stage sb = (Stage) textField.getScene().getWindow();
                sb.close();
            }
    }



    @FXML void numPressed(Event event){
        if(lastOperation=='e')
            clc();
        if(event instanceof KeyEvent)
            inputStr += ((KeyEvent) event).getText();
        else
            inputStr += ((Button) event.getSource()).getId();
        textField.setText(inputStr);
        //displayInfo();
    }

    @FXML void decimalPressed(){
        if(lastOperation=='e')
            clc();
        inputStr += ".";
        textField.setText(inputStr);
        //displayInfo();
    }
    @FXML void addPressed() {
        if(inputStr.length()==0){
            lastOperation='a';
        }
        else{
            if(a==null) {
                a = Double.parseDouble(inputStr);
                textField.setText(String.valueOf(a));
            }
            else{
                a=operate(a,Double.parseDouble(inputStr));
                textField.setText(String.valueOf(a));
            }
            lastOperation='a';
            inputStr="";
        }
        //displayInfo();
    }
    @FXML void subtractPressed() {
        if (inputStr.length()==0&&textField.getText().length()==0) {
            inputStr += "-";
            lastOperation = 's';
            textField.setText(inputStr);
        }
        else {
            if (a == null) {
                a = Double.parseDouble(inputStr);
                textField.setText(String.valueOf(a));
            } else {
                if(inputStr.equals("")){lastOperation='s'; return;}
                a = operate(a, Double.parseDouble(inputStr));
                textField.setText(String.valueOf(a));
            }
            lastOperation = 's';
            inputStr = "";
        }
        //displayInfo();
    }
    @FXML void multiplyPressed() {
        if (inputStr.length()==0) {
            lastOperation = 'm';
        } else {
            if (a == null) {
                a = Double.parseDouble(inputStr);
                textField.setText(String.valueOf(a));
            } else {
                a = operate(a, Double.parseDouble(inputStr));
                textField.setText(String.valueOf(a));
            }
            lastOperation = 'm';
            inputStr = "";
        }
        //displayInfo();
    }
    @FXML void dividePressed() {
        if(inputStr.length()==0){
            lastOperation='d';
        }
        else{
            if(a==null) {
                a = Double.parseDouble(inputStr);
                textField.setText(String.valueOf(a));
            }
            else{
                a=operate(a,Double.parseDouble(inputStr));
                textField.setText(String.valueOf(a));
            }
            lastOperation='d';
            inputStr="";
        }
        //displayInfo();
    }
    @FXML void equalsPressed() {
        if(inputStr.length()==0){
            lastOperation='x';
        }

        else if(inputStr.equals("-")) clc();
        else{
            if(inputStr.indexOf(".")!=inputStr.lastIndexOf("."))  {clc(); textField.setText("ERROR"); return;}
            if(a==null) {
                a = Double.parseDouble(inputStr);
                textField.setText(String.valueOf(a));
            }
            else{
                if(Double.parseDouble(inputStr)==0&&lastOperation=='d'){
                    clc(); textField.setText("ERROR"); return;}
                if(lastOperation=='x')
                    a=Double.parseDouble(inputStr);
                else a=operate(a,Double.parseDouble(inputStr));
                textField.setText(String.valueOf(a));
            }
            inputStr="";
            lastOperation='e';
        }
        //displayInfo();
    }
    @FXML void delPressed(){
        if(textField.getText().length()!=0) {
            inputStr=textField.getText().substring(0,textField.getText().length()-1);
            textField.setText(inputStr);
            lastOperation='x';
            if(textField.getText().length()==0) clc();
        }
    }
    @FXML void clearPressed() {
        clc();
    }

    private void clc(){
        textField.setText("");
        inputStr="";
        a=null;
        lastOperation='x';
        //System.out.println("Clear called");
        //displayInfo();
    }

    private  double operate(double x, double y) {
        switch (lastOperation) {
            case 'a':
                return (double)Math.round((x+y)*1000000000)/1000000000;
            case 's':
                return (double)Math.round((x-y)*1000000000)/1000000000;
            case 'm':
                return (double)Math.round((x*y)*1000000000)/1000000000;
            case 'd':
                return (double)Math.round((x/y)*1000000000)/1000000000;
            case 'x':
                clc();
                return x;
        }
        System.out.print("check last operation");
        return-1.0;
    }

    private void displayInfo(){
        System.out.println("a: "+a+", inputStr: "+inputStr+", textField: "+textField.getText()+", lastOperation: "+lastOperation);
    }
}

