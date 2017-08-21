package StarWestFlightSearch;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class SelectFlight_API extends ExecutionContext {

	public static StarWestFlightSearch.ObjectLibrary OL;
	public static String Flight;
	public static int FlightNum;
	
	
	public void v_Execute_Search(){
		
	}
	
	public void v_SelectFlightPage(){
		//Verifies flight page displayed
	}
	
	public void v_SelectFlight() throws InterruptedException{
		//Verifies Flight Selected
		OL.VerifySelectedFlight(FlightNum);
	}
	
	public void v_Error() throws InterruptedException{
		//Verifies Error Displayed
		OL.VerifyFlightSelectError();
	}
	
	public void v_GuestRegistration(){
		
	}
	
	public void e_Select() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Flight=TrimAction(ActionValue, "Flight=");
		FlightNum=Integer.parseInt(Flight);
		OL.SelectFlight(FlightNum);
	}
	
	public void e_Submit() throws InterruptedException{
		//Submits Selectd flight
		OL.SubmitFlightSelection();
	}
	
	public void v_Logic_1(){
		
	}
	
	public void v_Logic_2(){
		
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
