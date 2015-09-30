
import java.util.*;

class MyDate{
	private int day;
	private int month;
	private int year;
	
	public MyDate(int d, int m, int y){
		if(d<=31 && d>=1)
			this.setDay(d);
		if(m<=12 && m>=1)
			this.setMonth(m);
		if(y<=3000 && y>=1)
			this.setYear(y);
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean greaterThan (MyDate date){
		if(this.year>date.year)
			return true;
		else if(this.year<date.year)
			return false;
		else
		{
			if(this.month>date.month)
				return true;
			else if (this.month<date.month)
				return false;
			else
			{
				if(this.day>date.day)
					return true;
				else if(this.day<date.day)
					return false;
				else
					return false;
			}
		}
	}
	
	public int calculateFine(MyDate date){
		if(this.year>date.year)
			return 10000;
		else if(this.year<=date.year)
		{
			if(this.month>date.month)
				return 500*(this.month-date.month);
			else if (this.month<=date.month)
			{
				if(this.day>date.day)
					return (this.day-date.day)*15;
				else if(this.day<=date.day)
					return 0;

			}
		}
		return 0;
	}
}

public class LibraryFine {
	
	public static void main(String[] args) {
		//Date
		int fine = 0;
		Scanner sn = new Scanner (System.in);
		
		int d = sn.nextInt();
		int m = sn.nextInt();
		int y = sn.nextInt();		
		MyDate returnDate = new MyDate(d,m,y);
		
		int d1 = sn.nextInt();
		int m1 = sn.nextInt();
		int y1 = sn.nextInt();		
		MyDate expectedDate = new MyDate(d1,m1,y1);

//		MyDate expectedDate = new MyDate(6,6,2015);
//		MyDate returnDate = new MyDate(9,6,2015);
		
		if(returnDate.greaterThan(expectedDate))
			fine = returnDate.calculateFine(expectedDate);
		
		System.out.println(fine);
		
		sn.close();
		
	}

}
