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
	static StarWestFlightSearch.DealWithDates dd;
	public static StarWestFlightSearch.ObjectLibrary OL;
	public static StarWestFlightSearch.LoggingFunctions LF;
	
	public static String City;
	public static String ArrivalDate;
	public static String AD;
	
	public static String LOS;
	public static int LengthOfStay;
	public static String DepartDate;
	public static String Guests;
	static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	static Date date = new Date();
	public static String TodaysDate=dateFormat.format(date);
	public static String Description;
	public static String Expected;
	public static String Result;
	
	public void e_Start(){
		
	}
	
	public void v_HotelSearch(){
		
	}
	
	public void e_Destination() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		City=TrimAction(ActionValue, "City=");
		OL.Hotel_SelectDestination(City);
		Description="User selects "+City+" as their destination";
		Expected=City+" is selected.";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
	}
	
	public void v_Destination() throws InterruptedException{
		Result=OL.Hotel_VerifyDestination(City);
		LF.AddActualResult(Result);
	}
	
	public void v_ArrivalDate() throws InterruptedException{
		
		Result=OL.Hotel_VerifyArrivalDate(ArrivalDate);
		
		LF.AddActualResult(Result);
	}
	
	public void e_ArrivalDate() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		ArrivalDate=TrimAction(ActionValue, "Date=");
		AD=dd.DealWithDates(ArrivalDate, "none", "none");
		
		OL.Hotel_EnterArrival(AD);
		Description="User selects "+ArrivalDate+" as their arrival date";
		Expected=ArrivalDate+" is selected";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
		
	}

	
	public void e_LengthOfStay() throws InterruptedException{
		
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LOS=TrimAction(ActionValue, "LOS=");
		LengthOfStay=Integer.parseInt(LOS);
		OL.Hotel_SelectLengthOfStay(LengthOfStay);
		Description="The uses selects their length of stay as:  "+LengthOfStay;
		Expected=LengthOfStay+" is selected.";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
	}
	
	public void v_LengthOfStay() throws NumberFormatException, InterruptedException{
		
		
		Result=OL.Hotel_VerifyLengthOfStay(LengthOfStay);
		LF.AddActualResult(Result);
	}
	
	public void v_DepartDate() throws NumberFormatException, ParseException, InterruptedException{
		Description="The system displays the departure date.";
		Expected="The depature date is displayed";
		Result=OL.Hotel_VerifyDepartDate(Integer.parseInt(LOS), AD);
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
	}
	
	public void e_Guests() throws NumberFormatException, InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Guests=TrimAction(ActionValue, "Guests=");
		OL.Hotel_SelectGuests(Integer.parseInt(Guests));
		Description="The user selects the number of guests as:  "+Guests;
		Expected=Guests+" is selected";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
	
	}
	
	public void v_Guests() throws NumberFormatException, InterruptedException{
		
		Result=OL.Hotel_VerifyGuests(Integer.parseInt(Guests));
		LF.AddActualResult(Result);
	}
	
	public void e_Search() throws InterruptedException{
		OL.Hotel_Search();
		Description="The user executes the hotel search.";
	}
	
	public void v_Logic_1(){
		
	}
	
	
	public void v_SearchError() throws InterruptedException{
		Result=OL.Hotel_ErrorMsg();
		Expected="Error Messag is displayed.";
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
		
	}
	
	public void v_Home(){
		Result="Pass";
		LF.AddActualResult(Result);
	}
	
	public void v_Nav(){
		
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
