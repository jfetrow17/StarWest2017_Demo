package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class SWFLIGHT_Logon_Home extends ExecutionContext{

	public static StarWestFlightSearch.ObjectLibrary OL;
	public static StarWestFlightSearch.LoggingFunctions LF;
	
	public static String UN;
	public static String PW;
	static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	static Date date = new Date();
	public static String TodaysDate=dateFormat.format(date);
	public static String Description;
	public static String Expected;
	public static String Result;
	
	public void e_Start() throws InterruptedException{
		//Launch website
		
		
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		Date date = new Date();
		String TodaysDate=dateFormat.format(date);
		
		LF.CreateExecutionLog(TodaysDate);
		
		OL.LaunchSite();
		Description="User Launches the Flight Search Website.";
		Expected="Website is launched.";
		Result="Pass";
		//LF.CreateExecutionLog2(TodaysDate, Description);
		LF.AddStepToTestLog(Description);
		
		LF.AddExpectedResult(Expected);
		
		LF.AddActualResult(Result);
		
	}
	
	public void v_Logon(){
		//Verifies logon page comes up
		//No Verification in place
	}
	
	public void e_User() throws InterruptedException{
		//enters Username in username field
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		UN=TrimAction(ActionValue, "UN=");
		OL.EnterUserName(UN);
		Description="User Enters \""+UN+"\" in the User Name field.";
		Expected="\""+UN+"\" is displayed.";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
	}
	
	public void v_UserName() throws InterruptedException{
		//Verifies the username is entered correctly
		Result=OL.VerifyUserName(UN);
		LF.AddActualResult(Result);
		
		
	}
	
	public void e_Password() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		PW=TrimAction(ActionValue, "PW=");
		OL.EnterPassword(PW);
		Description="User Enters \""+PW+"\" in the Password field.";
		Expected="\""+PW+"\" is displayed.";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
	}
	
	
	public void v_Password() throws InterruptedException{
		//Verifies the Password is entered correctly
		Result=OL.VerifyPassword(PW);
		LF.AddActualResult( Result);
	}
	
	public void e_Logon() throws InterruptedException{
		//Clicks logon button
		OL.Logon();
		Description="The user clicks the logon button";
		LF.AddStepToTestLog(Description);
	}
	
	public void v_Logic_1(){
		//a decision point based on the model input
	}
	
	public void v_Logic_2(){
		//a decision point based on the model input
	}
	
	public void v_Error_Logon() throws InterruptedException{
		//Verifies an error message is displayed if the proper conditions are met
		Result=OL.LogonError();
		Expected="An Error msg is displayed on the logon page.";
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
	}
	
	public void v_Home(){
		//verifies that the home page is displayed
		Expected="The Flight Search Home page is displayed";
		Result="Pass";
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);
	}
	
	public void e_Flight() throws InterruptedException{
		//Click the flight link
		OL.Flight_Link();
		Description="User Clicks on the Flight Search Link";
		LF.AddStepToTestLog(Description);
	}
	
	public void e_Hotel() throws InterruptedException{
		//Click the hotel link
		OL.Hotel_Link();
		Description="User Clicks on the Hotel Search Link";
		LF.AddStepToTestLog(Description);
	}
	
	public void  v_FlightSearch(){
		//Verifies the flight Search page is displayed
		Expected="The Flight Search Page is displayed";
		LF.AddExpectedResult(Expected);
	}
	
	public void v_HotelSearch(){
		//Verifies the hotel search page is displayed
		Expected="The Hotel Search Page is displayed";
		LF.AddExpectedResult(Expected);
	}
	
	public void v_GuestRegistration(){
		//Verifies the guest registration page is displayed
	}
	
	public void e_Logout() throws InterruptedException{
		//Click Logout
		OL.Logout();
		Description="Uesr Logs out.";
		Expected="User is logged out.";
		Result="Pass";
		LF.AddStepToTestLog(Description);
		LF.AddExpectedResult(Expected);
		LF.AddActualResult(Result);;
	}
	
	public void v_ReturnHome1(){
		
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
