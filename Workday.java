import java.util.*;
import java.sql.Time;
import java.text.*;
import java.time.LocalTime;

public class Workday {

	private static Date date;
	private LocalTime start;
	private LocalTime end;
	
	public Workday(Date date) {
		 
		this.date = date;
		start = LocalTime.of(9,0,0);
		end = LocalTime.of(17,0,0);
		
	}
	
	
	public  void set_data(Date d) {
		date = d;
		
	}
	public  void set_start( LocalTime start) {
		this.start = LocalTime.of(start.getHour(),start.getMinute(),start.getSecond()); 
		
	}
	
	public  void set_end( LocalTime end) {
		this.end = LocalTime.of(end.getHour(),end.getMinute(),end.getSecond()); 
		
	}
	
	public Date get_data() {
		return date;
	}
	
	public LocalTime get_start() {
		return start; 
	}
	
	public LocalTime get_end() {
		return end; 
	} 
	public double workTime() {
		double sum;
		double s_hour = start.getHour();
		double e_hour = end.getHour();
		double s_minute = start.getMinute();
		double e_minute = end.getMinute();
		if (e_minute >+s_minute ) {

			sum = e_hour - s_hour;
			sum = sum + (e_minute - s_minute)/60;

			return sum;

		
		}
		e_minute += 60;
		e_hour--;
		sum = e_hour - s_hour;
		sum = sum + (e_minute - s_minute)/60;
		return sum;
		
		
	}
	public Boolean isExtra() {
		if (this.workTime() > 8) {
			return true;
		}
		return false;
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      // display time and date using toString()
		LocalTime end, new_end;
		new_end = LocalTime.of(18,45,0);
	      Date dNow = new Date( );
	      SimpleDateFormat ft =  new SimpleDateFormat (" dd.MM.yyyy");
		  Workday day = new Workday(dNow);
		  end = day.get_end();
		  System.out.println(day.isExtra());
		  day.set_end(new_end);
		  System.out.println(day.isExtra());

		  System.out.println(end.getHour() + ":" + end.getMinute()+":"+ end.getSecond());
		  System.out.println(day.workTime()+ "  ood");
	      System.out.println("Current Date: " + ft.format(dNow));           

	}

}
