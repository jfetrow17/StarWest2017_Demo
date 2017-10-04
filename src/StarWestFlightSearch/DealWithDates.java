package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DealWithDates {

	public static String DealWithDates (String TypeOfDate, String ExistingDate, String ExistingDateType) throws ParseException{
		String x=null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime(); 
		if(ExistingDate.equalsIgnoreCase("none")){
			if(TypeOfDate.equalsIgnoreCase("Today")){
				x=df.format(today);
			}else if(TypeOfDate.equalsIgnoreCase("Yesterday")){
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); 
				c.add(Calendar.DATE, -1); 
				x = df.format(c.getTime());
			}else if(TypeOfDate.equalsIgnoreCase("Tomorrow")){
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); 
				c.add(Calendar.DATE, 1); 
				x = df.format(c.getTime());
			}else if(TypeOfDate.equalsIgnoreCase("FutureDate")) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); 
				c.add(Calendar.DATE, RandomNumber(2,31)); 
				x = df.format(c.getTime());
			}else{
				x=df.format(today);
			}
		}else{
			Date date = df.parse(ExistingDate);
			Calendar c = Calendar.getInstance(); 
			c.setTime(date); 
			if(ExistingDateType.equals("FutureDate")){
			
				if(TypeOfDate.equalsIgnoreCase("FutureDate+1")){
					c.add(Calendar.DATE, 1);
				}else if(TypeOfDate.equalsIgnoreCase("FutureDate-1")){
					c.add(Calendar.DATE, -1);
				}else{
					c.add(Calendar.DATE, 1);
				}
			}else{
				c.add(Calendar.DATE, RandomNumber(2,31));
			}
			
			
			x=df.format(c.getTime());
			
		}
		
		return x;
	}
	
	public static int RandomNumber(int minimum, int maximum){
		int Result =0;
		Random rn = new Random();
		int range = maximum - minimum + 1;
		Result=  rn.nextInt(range) + minimum;
		return Result;
	}
	
	public static String DOB_65(String TypeOfDOB, String DepartDate) throws ParseException{
		String x=null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = df.parse(DepartDate);
		Calendar c = Calendar.getInstance(); 
		c.setTime(date);
		if(TypeOfDOB.equals("< 65 at Depart")){
			
			c.add(Calendar.YEAR,-RandomNumber(40,60));
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("> 65 at Depart")){
			
			c.add(Calendar.YEAR,-RandomNumber(66,90));
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("65 at Depart")){
			
			c.add(Calendar.YEAR,-65);
			date=c.getTime();
			x=df.format(c.getTime());
		}else{
			//c.add(Calendar.YEAR,-RandomNumber(40,60));
			x="";
		}
		
		
		
		return x;
	}
	
	public static String DOB_2(String TypeOfDOB, String CalcDate) throws ParseException{
		String x=null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = df.parse(CalcDate);
		Calendar c = Calendar.getInstance(); 
		c.setTime(date);
		if(TypeOfDOB.equals(">2 at Return")){
			
			c.add(Calendar.YEAR,-1*(RandomNumber(3,10)));
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("2 at Return")){
			
			c.add(Calendar.YEAR,-2);
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("<2 at Return")){
			
			c.add(Calendar.YEAR,-1);
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("2 at Depart")){
			
			c.add(Calendar.YEAR,-2);
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals("<2 at Depart")){
			
			c.add(Calendar.YEAR,-1);
			date=c.getTime();
			x=df.format(c.getTime());
		}else if(TypeOfDOB.equals(">2 at Depart")){
			
			c.add(Calendar.YEAR,-1*(RandomNumber(3,10)));
			date=c.getTime();
			x=df.format(c.getTime());
			
		}else{
			x="";
		}
		
		return x;
	}
}
