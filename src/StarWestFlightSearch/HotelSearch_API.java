package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class HotelSearch_API extends ExecutionContext{

	public static StarWestFlightSearch.ObjectLibrary OL;
	
	public static String City;
	public static String ArrivalDate;
	public static Calendar AD;
	public static String AD_str;
	public static String LOS;
	public static int LengthOfStay;
	public static String DepartDate;
	public static String Guests;
	
	public void e_Start(){
		
	}
	
	public void v_HotelSearch(){
		
	}
	
	public void e_Destination() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		City=TrimAction(ActionValue, "City=");
		OL.Hotel_SelectDestination(City);
	}
	
	public void v_Destination() throws InterruptedException{
		OL.Hotel_VerifyDestination(City);
	}
	
	public void v_ArrivalDate() throws InterruptedException{
		OL.Hotel_VerifyArrivalDate(ArrivalDate);
	}
	
	public void e_ArrivalDate() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		ArrivalDate=TrimAction(ActionValue, "Date=");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime(); 
		String AD = df.format(today);
		if(ArrivalDate.equals("Today")){
			AD=AD;
		}else if(ArrivalDate.equals("Yesterday")){
		
			c.add(Calendar.DATE, -1);
			AD=df.format(c);
			
		}else{
			c.add(Calendar.DATE, (RandomNumber(2,31)));
			AD=df.format(c);
			
		}
		
		OL.Hotel_EnterArrival(AD);
	}
	
	public void e_LengthOfStay() throws NumberFormatException, InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LOS=TrimAction(ActionValue, "LOS=");
		System.out.println("Hey there!!!, LOS="+LOS);
		LengthOfStay=Integer.parseInt(LOS);
		System.out.println("Length of Stay="+LengthOfStay+".  This was Derived from LOS="+LOS);
		OL.Hotel_SelectLengthOfStay(Integer.parseInt(LOS));
	}
	
	public void v_LenghtOfStay() throws NumberFormatException, InterruptedException{
		OL.Hotel_VerifyLengthOfStay(Integer.parseInt(LOS));
	}
	
	public void v_DepartDate() throws NumberFormatException, ParseException, InterruptedException{
		OL.Hotel_VerifyDepartDate(Integer.parseInt(LOS), ArrivalDate);
	}
	
	public void e_Guests() throws NumberFormatException, InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Guests=TrimAction(ActionValue, "Guests=");
		OL.Hotel_SelectGuests(Integer.parseInt(Guests));
	
	}
	
	public void v_Guests() throws NumberFormatException, InterruptedException{
		
		OL.Hotel_VerifyGuests(Integer.parseInt(Guests));
	}
	
	public void e_Search() throws InterruptedException{
		OL.Hotel_Search();
	}
	
	public void v_Logic_1(){
		
	}
	
	
	public void v_SearchError() throws InterruptedException{
		OL.Hotel_ErrorMsg();
	}
	
	public void v_Home(){
		
	}
	
	/**
	 * Support functions
	 */
	
	public static String TrimAction(String Action, String Value){
		int StrLgth=Value.length();
		String ReturnString=Action.substring(StrLgth).replaceAll("'", "").replace(";", "");
		
		System.out.println("/n/r Action Passed:  "+Action);
		System.out.println("Trimed Value is:  :"+ReturnString+"/n/r");
		
		return ReturnString;
	}
	
	public static String ReturnDateString(Calendar DepartDate){
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String DatePass = df.format(DepartDate);
		return DatePass;
		
	}
	
	public static int RandomNumber(int minimum, int maximum){
		int Result =0;
		Random rn = new Random();
		int range = maximum - minimum + 1;
		Result=  rn.nextInt(range) + minimum;
		return Result;
	}
}
