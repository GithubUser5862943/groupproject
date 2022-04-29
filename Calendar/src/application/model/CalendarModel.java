 package application.model;

import java.util.Calendar;

/*
Name: Paul Carrizales
UTSA IDs: pja691
Class Description: This class provides the functionality model behind the operation 
of the "Calendar" group project application.
*/
public class CalendarModel {

	Calendar calen = Calendar.getInstance();
	
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
	
	/* method to load saved calendar data to calendar view */
	public void loadData() {
		
	}
	
	/* method to save calendar data to file from calendar view */
	public void saveDataToFile() {
		System.out.println();
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
}
