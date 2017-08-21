package StarWestFlightSearch;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class SWFLIGHT_Logon_Home extends ExecutionContext{

	public static StarWestFlightSearch.ObjectLibrary OL;
	
	public static String UN;
	public static String PW;
	public void e_Start() throws InterruptedException{
		//Launch website
		OL.LaunchSite();
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
	}
	
	public void v_UserName() throws InterruptedException{
		//Verifies the username is entered correctly
		OL.VerifyUserName(UN);
	}
	
	public void e_Password() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		PW=TrimAction(ActionValue, "PW=");
		OL.EnterPassword(PW);
	}
	
	
	public void v_Password() throws InterruptedException{
		//Verifies the Password is entered correctly
		OL.VerifyPassword(PW);
	}
	
	public void e_Logon() throws InterruptedException{
		//Clicks logon button
		OL.Logon();
		
	}
	
	public void v_Logic_1(){
		//a decision point based on the model input
	}
	
	public void v_Logic_2(){
		//a decision point based on the model input
	}
	
	public void v_Error_Logon() throws InterruptedException{
		//Verifies an error message is displayed if the proper conditions are met
		OL.LogonError();
	}
	
	public void v_Home(){
		//verifies that the home page is displayed
		
	}
	
	public void e_Flight() throws InterruptedException{
		//Click the flight link
		OL.Flight_Link();
	}
	
	public void e_Hotel() throws InterruptedException{
		//Click the hotel link
		OL.Hotel_Link();
	}
	
	public void  v_FlightSearch(){
		//Verifies the flight Search page is displayed
	}
	
	public void v_HotelSearch(){
		//Verifies the hotel search page is displayed
	}
	
	public void v_GuestRegistration(){
		//Verifies the guest registration page is displayed
	}
	
	public void e_Logout() throws InterruptedException{
		//Click Logout
		OL.Logout();
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
