package application.controller;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/*
Names: Paul Carrizales
UTSA IDs: pja691
Class Description: This controller class contains the action IDs and execution code for buttons
of the Main/home view.
*/
public class MainController {

    @FXML
    private Button nextMonth;
    
    @FXML
    private Button resetButton;
    
    @FXML
    private Button saver;
    
    @FXML
    private Button loader;

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

    private application.model.CalendarModel calendar = new application.model.CalendarModel();
    
    
    /* This method allows users to select a day to edit */
    @FXML
    void selectDay(MouseEvent event) {
    	
    	int day;
    	TextArea clicked = (TextArea) event.getSource();
    	Scanner intFinder = new Scanner(clicked.getText());
    	try {
    		//day = Integer.parseInt(clicked.getText());
    		day= intFinder.nextInt();
    		calendar.setDay(day);
    		System.out.println("Day " + day + " selected");
    	} catch (Exception e){
    		System.out.println("Warning -- no integer found");
    	}
    	//setDaysText();
    }
    
    /* This method switches from the current month viewed to the previous month */
    @FXML
    void prevMonth(ActionEvent event) {
    	System.out.println("Previous Month");
    	calendar.prevMonth();
    	setView();
    	
    }
    
    /* This method switches from the current month viewed to the next month */
    @FXML
    void nextMonth(ActionEvent event) {
    	System.out.println("Next Month");
    	calendar.nextMonth();
    	setView();
    }
    
    /* This method loads the calendar event data */
    @FXML
    void saveCalendarData(ActionEvent event) {
    	calendar.saveDataToFile();
    	System.out.println("Calendar data saved");
    	setView();
    }
    
    /* This method loads the calendar event data */
    @FXML
    void loadCalendarData(ActionEvent event) {
    	System.out.println("Calendar data loaded");
    	calendar.loadDataToMap();
    	setView();
    }
    
    /* This method sets/resets the calendar view to current month */
    @FXML
    void resetView(ActionEvent event) {
    	System.out.println("Calendar view set to current month");
    	calendar.generateCalendarData();
    	setMonthText();
    	setDaysText();
    }
    
    /* This method submits the changes to the currently selected day (day 1 by default) */
    @FXML
    void submitChanges(ActionEvent event) {
    	calendar.saveDataToMap(eventTextArea.getText());
    	System.out.println("Changes submitted");
    	setView();
    }
    
    /* Sets up the view label with the current month information */
    void setMonthText() {
    	monthLabel.setText(calendar.getMonth());
    }
    
    /* Sets/resets the view label with the current days information */
    void setDaysText() {
    	TextArea t[] = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11,
    			text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22,
    			text23, text24, text25, text26, text27, text28, text29, text30, text31, text32, text33, 
    			text34, text35, text36, text37, text38, text39, text40, text41, text42};
    	String[] notes = calendar.getNotes();
    	int day = 1;
    	int calStart = calendar.getStartDay();
    	int daysInMonth = calendar.maxDaysInMonth();
    	for(int i = 0; i < t.length; i++) {
    		if(i >= calStart && i < (daysInMonth + calStart)) {
    			t[i].setText(""+ day);
    			if(notes[day-1] != null) {
    				t[i].appendText("\n");
    				t[i].appendText(notes[day-1]);
    			}
    			day++;
    		} else {
    			t[i].clear();
    		}
    	}
    }

    /* General method for setting view data */
    void setView() {
    	setMonthText();
    	calendar.loadDataToMonthNotes();
    	setDaysText();
    }
}
