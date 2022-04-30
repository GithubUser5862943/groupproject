 package application.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.*;

/*
Name: Paul Carrizales
UTSA IDs: pja691
Class Description: This class provides the functionality model behind the operation 
of the "Calendar" group project application.
*/
public class CalendarModel {

	Calendar calen = Calendar.getInstance();
	HashMap<Integer, String> events = new HashMap<>();
	String notes[] = new String[31];
	
	String month;
	int currMonth;
	int day; //currently selected day (default is 1)
	int year;
	int startDay; //day of week for start of the month (Mon, Tues, etc.)
	int maxDays; //the amount of days in the current month
	
	/* Sets / resets the calendar to the first day of the current month and year */
	public void generateCalendarData() {

		calen = Calendar.getInstance();
		currMonth = calen.get(Calendar.MONTH);
		year = calen.get(Calendar.YEAR);
		getMonthInfo();
		setMonth();
		
	}
	
	/* method to load saved calendar data to Map */
	public void loadDataToMap() {
		String c = "data/Calendar.sav";
		File calendarYear = new File(c);
		String buff;
		int key = 1;
		String value;
		if(calendarYear.exists()) {
			System.out.println("I AM HERE");
			try {
				Scanner loader = new Scanner(calendarYear);
				while(loader.hasNextLine()) {
					buff = loader.nextLine();
					if(buff.length() > 6) {
						//System.out.println(buff);
						key = Integer.parseInt(buff);
						value = loader.nextLine();
						events.put(key, value);
				}
			}
			loader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File \"" + c +"\" was not found");
			}
		} else {
			System.out.println("ERROR: There is no save data to load. BIRTH ME!!!");
		}
		
	}
	
	/* method to load saved calendar data from Map to notes for injection into view */
	public void loadDataToMonthNotes() {
		Iterator<Entry<Integer, String>> iterator = events.entrySet().iterator();
		int key;
		int monthValue;
		int yearValue;
		int dayValue;
		for(int i = 0; i < notes.length; i++) {
			notes[i]= null;
		}
		while(iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
			key = entry.getKey();
			monthValue = key / 1000000;
			yearValue = key % 10000;
			dayValue = key / 10000;
			dayValue = dayValue % 100;
			if(monthValue == currMonth && yearValue == year) {
				notes[dayValue-1] = entry.getValue();
			}
		}
		
	}
	
	/* method to save calendar data to HashMap */
	public void saveDataToMap(String note) {
		int key = (day * 10000) + (currMonth * 1000000) + year;
		if(note.length() > 0) {
			events.put(key, note);
		}
	}
	
	/* method to save calendar data to file from HashMap */
	public void saveDataToFile() {
		String c = "data/Calendar.sav";
		File calendarYear = new File(c);
		if(calendarYear.exists()) {
			calendarYear.delete();
		}
		try {
		calendarYear.createNewFile();
		PrintStream output = new PrintStream(calendarYear);
		Iterator<Entry<Integer, String>> iterator = events.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
			output.println(entry.getKey());
			output.println(entry.getValue());
		}
		output.close();
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}catch (IOException e) {
			System.out.println("There was an error creating the file");
		}
	}
	
	/* method to set current month text to month string variable */
	public void setMonth() {
		
		if(this.currMonth == 0 ) {
    		this.month = "January";
    	} else if(currMonth == 1 ) {
    		this.month = "February";
    	} else if(currMonth == 2 ) {
    		this.month = "March";
    	} else if(currMonth == 3 ) {
    		month = "April";
    	} else if(currMonth == 4 ) {
    		this.month = "May";
    	} else if(currMonth == 5 ) {
    		month = "June";
    	} else if(currMonth == 6 ) {
    		month = "July";
    	} else if(currMonth == 7 ) {
    		month = "August";
    	} else if(currMonth == 8 ) {
    		month = "September";
    	} else if(currMonth == 9 ) {
    		month = "October" ;
    	} else if(currMonth == 10 ) {
    		month = "November";
    	} else if(currMonth == 11 ) {
    		month = "December";
    	}
	}

	/* Get method for calendar object */
	public Calendar getCalen() {
		return calen;
	}

	/* Get method for month variable */
	public String getMonth() {
		return month;
	}

	/* Get method for currMonth variable */
	public int getCurrMonth() {
		return currMonth;
	}
	
	/* Get method for startDay variable */
	public int getStartDay() {
		return startDay;
	}
	
	/* Get method for maxDays variable */
	public int maxDaysInMonth() {
		return maxDays;
	}

	/* Method to switch current calendar data to next month */
	public void nextMonth() {
		if(currMonth < 11) {
			currMonth = currMonth + 1;
		} else {
			currMonth = 0;
			nextYear();
		}
		getMonthInfo();
		setMonth();
	}
	
	/* Method to switch current calendar data to previous month */
	public void prevMonth() {
		if(currMonth > 0 ) {
			currMonth = currMonth - 1;
		} else {
			currMonth = 11;
			prevYear();
		}
		getMonthInfo();
		setMonth();
	}
	
	/* Calculates starting day of week for current month and maximum days of that month */
	public void getMonthInfo() {
		day = 1;
		calen.set(year, currMonth, day);
		startDay = calen.get(Calendar.DAY_OF_WEEK) - 1;
		maxDays = calen.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/* Set day method for select day method in view */
	public void setDay(int day) {
		this.day = day;
	}

	/* Get method for year variable */
	public int getYear() {
		return year;
	}

	/* increments current year */
	public void nextYear() {
		year++;
	}
	
	/* decrements current year */
	public void prevYear() {
		year--;
	}
	
	
	public String[] getNotes() {
		return this.notes;
	}
}
