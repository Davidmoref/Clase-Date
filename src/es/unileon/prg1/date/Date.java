package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public int getDay() {
		return this.day;
	}

	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}

	public int getMonth() {
		return this.month;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}

	public int getYear() {
		return this.year;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}


	public boolean isSameDay(Date other){
		return this.day == other.getDay();
	}
	
	public boolean isSameMonth(Date other){
		return this.month == other.getMonth();
	}

	public boolean isSameYear(Date other){
		return this.year == other.getYear();
	}

	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}

	public String getMonthName(){
		String name = null;
		switch (this.month){
		case 1:
			name = "January";
			break;
		case 2:
			name = "February";
			break;
		case 3:
			name = "March";
			break;
		case 4:
			name = "April";
			break;
		case 5:
			name = "May";
			break;
		case 6:
			name = "June";
			break;
		case 7:
			name = "July";
			break;
		case 8:
			name = "August";
			break;
		case 9:
			name = "September";
			break;
		case 10:
			name = "October";
			break;
		case 11:
			name = "November";
			break;
		case 12:
			name = "December";
			break;
		}
		return name;
	}

	private boolean isDayRight(int day){
		return (( day > 0 ) && (day <= this.getDaysOfMonth()));
	}

	public String getSeasonName(){
		String name = null;
		switch (this.month){
		case 1: 
		case 2: 
		case 3: 
			name = "Winter";
			break;
		case 4: 
		case 5: 
		case 6:
			name = "Spring";
			break;
		case 7: 
		case 8: 
		case 9:
			name = "Summer";
			break;
		case 10:
		case 11: 
		case 12:
			name = "Autumn";
			break;
		}
		
		return name;
	}

	public String getMonthsLeft() throws DateException{
		Date aux = new Date(day, month, year);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for (int i = this.month + 1; i <= 12; i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName() + " ");
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return monthsLeft.toString();
	}

	public String dateToString(){
		StringBuffer dateStr = new StringBuffer();
		dateStr.append(this.day + " of " + this.getMonthName() + " of "+ this.year);
		return dateStr.toString();
	}

	public String getDaysLeftOfMonth() throws DateException{
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = this.getDay(); isDayRight(i); i++) {
				this.setDay(i);
				daysLeft.append(this.toString() + " ");
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return daysLeft.toString();
	}

	public String getMonthsSameDays() throws DateException{
		Date aux = new Date(day, month, year);
		StringBuffer months = new StringBuffer();

		try{
			for ( int i = 1; i <= 12; i++) {
				aux.setMonth(i);
				if ( aux.getDaysOfMonth() == this.getDaysOfMonth() ) {
					months.append(aux.getMonthName() + " ");
				}
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		return months.toString();
	}

	public int getDaysPast() throws DateException{
		int resultado = 0;
		
		try{
			Date aux = new Date(1,1,this.year);
		
			for ( int i = 1; i < this.month; i++ ) {
				resultado += aux.getDaysOfMonth();
				aux.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}
		
		return resultado + this.day - 1;
	}

	public int intentosRandomEqualsDate() throws DateException{
        int intentos = 0, d, m, y;
        
        try{
			//WHILE
			//	intentos++
			// while (!this.isSame(new Date(d,m,y)));{
			// 	d = (int) (Math.random()*this.getDaysOfMonth()) + 1;
        	// 	m = (int) (Math.random()*12) + 1;
        	// 	y = this.year;
        	// 	intentos++;

        	// } 

			//DO-WHILE
        	do{
				d = (int) (Math.random()*this.getDaysOfMonth()) + 1;
        		m = (int) (Math.random()*12) + 1;
        		y = this.year;
        		intentos++;

        	} while (!this.isSame(new Date(d,m,y)));

		} catch (DateException e){
			System.err.println(e.getMessage());
		}
        return intentos;
    }

	private String nameOfDay(int day) {
		String dayName;
		switch (day) {
		case 1: 
			dayName = "Monday";
			break;
		case 2: 
			dayName = "Tuesday";
			break;
		case 3: 
			dayName = "Wednesday";
			break;
		case 4: 
			dayName = "Thursday";
			break;
		case 5: 
			dayName = "Friday";
			break;
		case 6: 
			dayName = "Saturday";
			break;
		case 7: 
			dayName = "Sunday";
			break;
		default:
			dayName = "Wrong day";
		}
		return dayName;
	}

	public String getDayOfWeek(int firstOfJanuary) throws DateException{
		int dayNumber = (this.getDaysPast() % 7 + firstOfJanuary ) % 7;		
		return nameOfDay(dayNumber);
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
