package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Action;

public class GuestReg_Details_API extends ExecutionContext {

	public static StarWestFlightSearch.ObjectLibrary OL;
	
	public static int GuestRow;
	public static String FN;
	public static String LN;
	public static String DOB;
	public static String Passport;
	public static String Gender;
	public static String LC;
	public static String FirstName;
	public static String LastName;
	public static String DateOfBirth;
	public static String PassportID;
	static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	static Date date = new Date();
	public static String TodaysDate=dateFormat.format(date);
	public static String Description;
	public static String Expected;
	public static String Result;
	
	public void v_CompleteDetails(){
		//Nav only
	}
	
	public void v_Guest1(){
		GuestRow=1;
	}
	
	public void v_Guest2(){
		GuestRow=2;
	}
	
	public void v_Guest3(){
		GuestRow=3;
	}
	
	public void v_Guest4(){
		GuestRow=4;
	}
	
	public void v_Guest5(){
		GuestRow=5;
	}
	
	public void v_Guest6(){
		GuestRow=6;
	}
	
	public void v_Guest7(){
		GuestRow=7;
	}
	
	public void v_Guest8(){
		GuestRow=8;
	}
	
	public void v_Guest9(){
		GuestRow=9;
	}
	
	public void v_Guest10(){
		GuestRow=10;
	}
	
	public void v_Guest11(){
		GuestRow=11;
	}
	
	public void v_Guest12(){
		GuestRow=12;
	}
	
	public void v_Nav(){
	//Nav Only	
	}
	
	public void e_FName() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		FN=TrimAction(ActionValue, "FName=");
		if(FN!="null"){
		FirstName=ChooseFirstName(RandomNumber(0,9));
		OL.EnterFirstName(GuestRow, FirstName);
		}else{
		//Do Nothing
			FirstName=null;
		}
			
	}
	
	public void e_LastNameName() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LN=TrimAction(ActionValue, "LName=");
		if(LN!="null"){
			LastName=ChooseLastName(RandomNumber(0,9));
			OL.EnterLastName(GuestRow, LastName);
		}else{
		//Do Nothing	
		}
		
	}
	
	public void e_DOB() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		DOB=TrimAction(ActionValue, "DOB=");
		if(DOB!="null"){
			int Month =RandomNumber(1,9);
			int Day= RandomNumber(10,28);
			int Yr= RandomNumber(1950, 2016);
			String mm=null;
			String dd=null;
			
			
			DateOfBirth="0"+Month+"/"+Day+"/"+Yr;
			OL.EnterDOB(GuestRow, DateOfBirth);
		}else{
		//Do Nothing	
			DateOfBirth=null;
		}
	}
	
	public void e_Passport() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Passport=TrimAction(ActionValue, "PP=");
		if(Passport!="null"){
			OL.EnterPasspot(GuestRow, GeneratePassport());
		}else{
		//Do Nothing	
		}
	}
	
	public void e_Gender() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Gender=TrimAction(ActionValue, "S=");
		if(Gender.equalsIgnoreCase("F")){
			Gender="Female";
			
		}else if(Gender.equalsIgnoreCase("M")){
			Gender="Male";
		}else{
			//Do Nothing
		}
		OL.SelectGender(GuestRow, Gender);
	}
	
	public void e_LC() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LC=TrimAction(ActionValue, "LC=");
		if(LC=="Y"){
			OL.SelectLC(GuestRow, "True");
		}else{
		//Do Nothing	
		}
	}
	
	
	public void v_FirstName() throws InterruptedException{
		//FirstName
		OL.VerifyFirstName(GuestRow, FirstName);
	}
	
	public void v_LastName() throws InterruptedException{
		//LastName
		OL.VerifyLastName(GuestRow, LastName);
	}
	
	public void v_DOB() throws InterruptedException{
		//DateOfBirth
		OL.VerifyDOB(GuestRow, DateOfBirth);
	}
	
	public void v_Passport() throws InterruptedException{
		//PassportID
		OL.VerifyPassport(GuestRow, PassportID);
	}
	
	public void v_Gender() throws InterruptedException{
		//Gender
		OL.VerifyGender(GuestRow, Gender);
	}
	
	public void v_LapChild(){
		//LC
		//Not in Scope Right now
	}
	
	/**
	 * 
	 *Supporting Functions
	 */
	
	
	public static String TrimAction(String Action, String Value){
		int StrLgth=Value.length();
		String ReturnString=Action.substring(StrLgth).replaceAll("'", "").replace(";", "");
		
		System.out.println("/n/r Action Passed:  "+Action);
		System.out.println("Trimed Value is:  :"+ReturnString+"/n/r");
		
		return ReturnString;
	}
	
	public static int RandomNumber(int minimum, int maximum){
		int Result =0;
		Random rn = new Random();
		int range = maximum - minimum + 1;
		Result=  rn.nextInt(range) + minimum;
		return Result;
	}
	
	public static String ReturnDateString(Calendar DepartDate){
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String DatePass = df.format(DepartDate);
		return DatePass;
		
	}
	
	public static String ChooseFirstName(int x){
		String y=null;
		ArrayList <String> FirstName= new ArrayList<String>();
		FirstName.add("Mary");
		FirstName.add("John");
		FirstName.add("Gary");
		FirstName.add("Katy");
		FirstName.add("Sam");
		FirstName.add("Robert");
		FirstName.add("Pam");
		FirstName.add("Ryan");
		FirstName.add("Billy");
		FirstName.add("Molly");
		y=FirstName.get(x);
		return y;
	}
	
	public static String  ChooseLastName(int x){
		ArrayList<String> LastName=new ArrayList<String>();
		LastName.add("Smith");
		LastName.add("Jones");
		LastName.add("Thompson");
		LastName.add("Lee");
		LastName.add("Fitzgerald");
		LastName.add("McDonald");
		LastName.add("Peterson");
		LastName.add("Lewis");
		LastName.add("Meyers");
		LastName.add("Wilson");
		return LastName.get(x);
	}
	
	public static String GeneratePassport(){
		return "x"+RandomNumber(10,99)+"-"+RandomNumber(10,99)+"-"+RandomNumber(10,99)+"-"+RandomNumber(10,99);
	}
}
	

