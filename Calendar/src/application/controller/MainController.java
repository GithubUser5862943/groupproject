package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/*
Names: Paul Carrizales, Angel Galicia
UTSA IDs: pja691
Class Description: This controller class contains the action IDs and execution code for buttons
of the Main/home view.
*/
public class MainController {

    @FXML
    private Button nextMonth;

    @FXML
    private TextArea text26;

    @FXML
    private TextArea text25;

    @FXML
    private TextArea text28;

    @FXML
    private TextArea eventTextArea;

    @FXML
    private TextArea text27;

    @FXML
    private TextArea text29;

    @FXML
    private Label monthLabel;

    @FXML
    private TextArea text40;

    @FXML
    private TextArea text20;

    @FXML
    private TextArea text42;

    @FXML
    private TextArea text41;

    @FXML
    private TextArea text22;

    @FXML
    private TextArea text21;

    @FXML
    private Button prevMonth;

    @FXML
    private TextArea text24;

    @FXML
    private TextArea text23;

    @FXML
    private Button submitButton;

    @FXML
    private TextArea text15;

    @FXML
    private TextArea text37;

    @FXML
    private TextArea text14;

    @FXML
    private TextArea text36;

    @FXML
    private TextArea text17;

    @FXML
    private TextArea text39;

    @FXML
    private TextArea text16;

    @FXML
    private TextArea text38;

    @FXML
    private TextArea text19;

    @FXML
    private TextArea text18;

    @FXML
    private TextArea text31;

    @FXML
    private Label addEventLabel;

    @FXML
    private TextArea text30;

    @FXML
    private TextArea text3;

    @FXML
    private TextArea text11;

    @FXML
    private TextArea text33;

    @FXML
    private TextArea text4;

    @FXML
    private TextArea text10;

    @FXML
    private TextArea text32;

    @FXML
    private TextArea text1;

    @FXML
    private TextArea text13;

    @FXML
    private TextArea text35;

    @FXML
    private TextArea text2;

    @FXML
    private TextArea text12;

    @FXML
    private TextArea text34;

    @FXML
    private TextArea text7;

    @FXML
    private TextArea text8;

    @FXML
    private TextArea text5;

    @FXML
    private TextArea text6;

    @FXML
    private TextArea text9;

    /* This method allows users to select a day to edit */
    @FXML
    void selectDay(MouseEvent event) {
    	System.out.println("Day selected");
    }
    
    /* This method switches the current month viewed to the previous month */
    @FXML
    void prevMonth(ActionEvent event) {
    	System.out.println("Previous Month");
    }
    
    /* This method switches the current month viewed to the next month */
    @FXML
    void nextMonth(ActionEvent event) {
    	System.out.println("Next Month");
    }
    
    /* This method submits the changes to the currently selected month */
    @FXML
    void submitChanges(ActionEvent event) {
    	System.out.println("Changes submitted");
    }

}
