package myCalc;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML TextField textField;
    Double a;
    String inputStr="";
    Character lastOperation='x';

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MyCalc.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
        /*
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().isDigitKey()){ numberPressed(event); }
                else if(event.getCode().equals(KeyCode.DECIMAL)){ decimalPressed(event); event.consume();}
                else{
                    switch(event.getCode()){
                        case ADD: addPressed(event); event.consume();
                        case SUBTRACT: subtractPressed(event); event.consume();
                        case ASTERISK: multiplyPressed(event); event.consume();
                        case DIVIDE: dividePressed(event); event.consume();
                        case ENTER: equalsPressed(event); event.consume();
                    }
                }
            }
        });
        */
    }

    @FXML void numberPressed(Event event) {if(lastOperation=='e') clc(); inputStr += ((Button) (event.getSource())).getId(); textField.setText(inputStr); displayInfo();}

    @FXML void decimalPressed(Event event) {if(lastOperation=='e') clc(); inputStr+=".";textField.setText(inputStr);displayInfo();}

    @FXML void addPressed(Event event) {
       if(inputStr.length()==0){System.out.println("Do nothing, just store op"); lastOperation='a';}
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
       displayInfo();
    }

    @FXML void subtractPressed(Event event) {

        if (inputStr.length()==0&&textField.getText().length()==0) {
            System.out.println("inputStr='-' and store op");
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
        displayInfo();

    }
    @FXML void multiplyPressed(Event event) {
        if (inputStr.length()==0) {
            System.out.println("Do nothing, just store op");
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
        displayInfo();
    }

    @FXML void dividePressed(Event event) {
        if(inputStr.length()==0){System.out.println("Do nothing, just store op"); lastOperation='d';}
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
        displayInfo();
    }
    @FXML void equalsPressed(Event event) {

        if(inputStr.length()==0){
            System.out.println("Do nothing except clearing lastOperation");
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
                    if(lastOperation==null)
                        a=Double.parseDouble(inputStr);
                    else a=operate(a,Double.parseDouble(inputStr));
                    textField.setText(String.valueOf(a));
                }
            inputStr="";
            lastOperation='e';
        }
        displayInfo();
    }


    @FXML void clearPressed(Event event) {
        clc();
    }

    @FXML
    private void delPressed(){
        System.out.println(textField.getText());
        System.out.println(textField.getText().length());
        if(textField.getText().length()!=0) textField.setText(textField.getText().substring(0,textField.getText().length()-1));
    }

    //helper method for bringing variables to their initial states
    private void clc(){
        textField.setText("");
        inputStr="";
        a=null;
        lastOperation='x';
        System.out.println("Clear called");
        displayInfo();
    }

    //helper method to display state of all variables
    private void displayInfo(){
        System.out.println("a: "+a+", inputStr: "+inputStr+", textField: "+textField.getText()+", lastOperation: "+lastOperation);
    }

    //helper method to perform operation
    private  Double operate(Double x, Double y) {
        switch (lastOperation) {
            case 'a':
                return x + y;
            case 's':
                return x - y;
            case 'm':
                return x * y;
            case 'd':
                return x / y;
            case 'x':
                clc();
                return x;
        }
        System.out.print("check last operation");
        return-1.0;
    }






    public static void main(String[] args) {
        launch(args);
    }
    }

