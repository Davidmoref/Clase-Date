package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		Date other;
		//today = new Date(11,11,2020);
		
		try {
			today = new Date(3,01,2020);
			other = new Date(11,11,2020);
			int firstOfJanuary = 3;

			System.out.println(today);
			System.out.println(other);


			System.out.println(today.getMonthName());
			System.out.println(today.getSeasonName());
			//System.out.println(today.isDayRight());



			System.out.println(other.isSame(today));
			System.out.println(other.isSameDay(today));
			System.out.println(other.isSameMonth(today));
			System.out.println(other.isSameYear(today));

			System.out.println(today.getMonthsLeft());
			System.out.println(today.dateToString());
			System.out.println(today.getDaysLeftOfMonth());
			System.out.println(today.getMonthsSameDays());
			System.out.println(today.getDaysPast());

			System.out.println(today.intentosRandomEqualsDate());
			System.out.println(today.getDayOfWeek(firstOfJanuary));

		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	
		
	}


}
