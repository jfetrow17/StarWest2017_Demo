package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class SelectFlight_API extends ExecutionContext {

	public static StarWestFlightSearch.ObjectLibrary OL;
	public static StarWestFlightSearch.LoggingFunctions LF;
	public static String Flight;
	public static int FlightNum;
	static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	static Date date = new Date();
	public static String TodaysDate=dateFormat.format(date);
	public static String Description;
	public static String Expected;
	public static String Result;
	
	
	public void v_Execute_Search(){
		
	}
	
	public void v_SelectFlightPage(){
		//Verifies flight page displayed
		Result="Pass";
		LF.AddActualResult(Result);
	}
	
	public void v_SelectFlight() throws InterruptedException{
		//Verifies Flight Selected
		//OL.VerifySelectedFlight(FlightNum);
	}
	
	public void v_Error() throws InterruptedException{
		//Verifies Error Displayed
		Expected="No Flight was selected:  Error Displayed";
		Result=OL.VerifyFlightSelectError();
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
	}
	
	public void v_GuestRegistration(){
		Expected="Guest Registration Page Displayed";
		LF.AddExpectedResult(Expected);
	}
	
	public void e_Select() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Flight=TrimAction(ActionValue, "Flight=");
		FlightNum=Integer.parseInt(Flight);
		OL.SelectFlight(FlightNum);
		if(FlightNum==0){
			Description="User does not select a flight.";
			Expected="No flights are selected";
		}else{
			Description="User Select flight option:  "+FlightNum;
			Expected="Flight # "+FlightNum+" is selected";
		}
		Result="Pass";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
	}
	
	public void e_Submit() throws InterruptedException{
		//Submits Selectd flight
		OL.SubmitFlightSelection();
		Description="User clicks the continue button on the select a flight page.";
		LF.AddStepToTestLog(Description);
	}
	
	public void v_Logic_1(){
		//For Nav
	}
	
	public void v_Logic_2(){
		//For Nav
	}
	
	public void v_ReturnHome3(){
		//For Nav
	}
	
	public void v_ReturnHome2(){
		//For Nav
	}
	
	public void e_state(){
		//For Nav
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
}
