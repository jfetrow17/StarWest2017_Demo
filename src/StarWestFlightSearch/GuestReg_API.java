package StarWestFlightSearch;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class GuestReg_API extends ExecutionContext {

	public static StarWestFlightSearch.ObjectLibrary OL;
	public static StarWestFlightSearch.DealWithDates DD;
	public static String NumOfGuests;
	public static int GuestRow;
	
	public void e_Start(){
		//For Nav only
	}
	
	public void v_GuestRegistration(){
		//Verifies Guest Reg Page Displayed
	}
	
	public void v_Verify_Guest1_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest2_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest2_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest3_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest3_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest4_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest4_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest5_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest5_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest6_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest6_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest7_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest7_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest8_Displayed(){
		//Verifies Guest is dis8played  
	}
	
	public void v_Verify_Guest8_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest9_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest9_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest10_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest10_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest11_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest11_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void v_Verify_Guest12_Displayed(){
		//Verifies Guest is displayed  
	}
	
	public void v_Verify_Guest12_Hidden(){
		//Verifies Guest is hidden
	}
	
	public void e_Guest(){
		//used to control model flow
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		NumOfGuests=TrimAction(ActionValue, "n=");
		GuestRow= Integer.parseInt(NumOfGuests);
	}
	
	public void e_Save() throws InterruptedException{
		OL.ConfirmGuests();
	}
	
	public void v_Home(){
		
	}
	
	public void v_CompleteDetails(){
		//Nav Only
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
