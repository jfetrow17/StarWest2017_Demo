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

public class FlightSearch_GWAPI extends ExecutionContext{

	public static StarWestFlightSearch.ObjectLibrary OL;
	static StarWestFlightSearch.DealWithDates dd;
	
	public static int SR_Passengers;
	public static int Passenger;
	public static int LapChild_Passengers;
	public static String TripType;
	public static String DepartFrom;
	public static String ArriveIn;
	public static Calendar DepartDate;
	public static String DepartDateType;
	public static String DepartDate_str;
	public static Calendar ReturnDate;
	public static String ReturnDateType;
	public static String ReturnDate_str;
	public static String SeatClass;
	public static String Airline;
	public static String SRDOB1_Type;
	public static String SRDOB1_str;
	public static Calendar SRDOB1;
	public static String SRDOB2_Type;
	public static String SRDOB2_str;
	public static Calendar SRDOB2;
	public static String SRDOB3_Type;
	public static String SRDOB3_str;
	public static Calendar SRDOB3;
	public static String SRDOB4_Type;
	public static String SRDOB4_str;
	public static Calendar SRDOB4;
	public static String LCDOB1_Type;
	public static String LCDOB1_str;
	public static Calendar LCDOB1;
	public static String LCDOB2_Type;
	public static String LCDOB2_str;
	public static Calendar LCDOB2;
	public static String LCDOB3_Type;
	public static String LCDOB3_str;
	public static Calendar LCDOB3;
	public static String LCDOB4_Type;
	public static String LCDOB4_str;
	public static Calendar LCDOB4;
	
	
	public void e_Start(){
		// Starts model no logic or data needed
	}
	
	public void v_SearchPage(){
		
	}
	
	public void e_SR_1() throws InterruptedException{
		SR_Passengers=1;
		OL.SelectSRPass(SR_Passengers);
	}
	
	public void e_SR_2() throws InterruptedException{
		SR_Passengers=2;
		OL.SelectSRPass(SR_Passengers);
	}
	
	public void e_SR_3() throws InterruptedException{
		SR_Passengers=3;
		OL.SelectSRPass(SR_Passengers);
	}
	
	public void e_SR_4() throws InterruptedException{
		SR_Passengers=4;
		OL.SelectSRPass(SR_Passengers);
	}
	
	public void e_SR_0() throws InterruptedException{
		SR_Passengers=0;
		OL.SelectSRPass(SR_Passengers);
	}
	
	public void v_Sr_Passengers() throws InterruptedException{
		OL.VerifySrPassengers(SR_Passengers);
	}
	
	public void e_Passenger_0() throws InterruptedException{
		Passenger=0;
		OL.SelectPassengers(Passenger);
	}
	
	public void e_Passenger_1() throws InterruptedException{
		Passenger=1;
		OL.SelectPassengers(Passenger);
	}
	
	public void e_Passenger_2() throws InterruptedException{
		Passenger=2;
		OL.SelectPassengers(Passenger);
	}
	
	public void e_Passenger_3() throws InterruptedException{
		Passenger=3;
		OL.SelectPassengers(Passenger);
	}
	
	public void e_Passenger_4() throws InterruptedException{
		Passenger=4;
		OL.SelectPassengers(Passenger);
	}
	
	public void v_Passengers() throws InterruptedException{
		OL.VerifyPassengers(Passenger);
	}
	
	public void e_LC_0() throws InterruptedException{
		LapChild_Passengers=0;
		OL.SelectLCPass(LapChild_Passengers);
	}
	
	public void e_LC_1() throws InterruptedException{
		LapChild_Passengers=1;
		OL.SelectLCPass(LapChild_Passengers);
	}
	
	public void e_LC_2() throws InterruptedException{
		LapChild_Passengers=2;
		OL.SelectLCPass(LapChild_Passengers);
	}
	
	public void e_LC_3() throws InterruptedException{
		LapChild_Passengers=3;
		OL.SelectLCPass(LapChild_Passengers);
	}
	
	public void e_LC_4() throws InterruptedException{
		LapChild_Passengers=4;
		OL.SelectLCPass(LapChild_Passengers);
	}
	
	public void v_Lap_Child_Passengers() throws InterruptedException{
		OL.VerifyLapPassengers(LapChild_Passengers);
		
	}
	
	public void e_RoundTrip() throws InterruptedException{
		TripType="Round Trip";
		OL.SelectTripType(TripType);
	}
	
	public void e_OneWay() throws InterruptedException{
		TripType="One Way";
		OL.SelectTripType(TripType);
	}
	
	public void v_TripType() throws InterruptedException{
		OL.VerifyTripType(TripType);
		
	}
	
	public void e_Depart_Frankfurt() throws InterruptedException{
		DepartFrom="Frankfurt";
		OL.SelectDeparturePort(DepartFrom);
	}
	
	public void e_Depart_Paris() throws InterruptedException{
		DepartFrom="Paris";
		OL.SelectDeparturePort(DepartFrom);
	}
	
	public void e_Depart_NewYork() throws InterruptedException{
		DepartFrom="New York";
		OL.SelectDeparturePort(DepartFrom);
	}
	
	public void e_Depart_London() throws InterruptedException{
		DepartFrom="London";
		OL.SelectDeparturePort(DepartFrom);
	}
	
	public void v_DepartureCity() throws InterruptedException{
		OL.VerifyDeparturePort(DepartFrom);
	}
	
	public void e_Arrive_Frankfurt() throws InterruptedException{
		ArriveIn="Frankfurt";
		OL.SelectDestinationPort(ArriveIn);
	}
	
	public void e_Arrive_Paris() throws InterruptedException{
		ArriveIn="Paris";
		OL.SelectDestinationPort(ArriveIn);
	}
	
	public void e_Arrive_NewYork() throws InterruptedException{
		ArriveIn="New York";
		OL.SelectDestinationPort(ArriveIn);
	}
	
	public void e_Arrive_London() throws InterruptedException{
		ArriveIn="London";
		OL.SelectDestinationPort(ArriveIn);
	}
	
	
	public void v_DestinationCity() throws InterruptedException{
		OL.VerifyDestinationPort(ArriveIn);
	}
	
	public void e_DepartDate() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		DepartDateType=TrimAction(ActionValue, "DD=");
		DepartDate_str=dd.DealWithDates(DepartDateType, "none");
		OL.EnterDepartDate(DepartDate_str);
		System.out.println("DepartDate_str:"+DepartDate_str);
		
	}

	public void v_DepartDate() throws InterruptedException{
		OL.VerifyDepartDate(DepartDate_str);
	}
	
	public void e_ReturnDate() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		ReturnDateType=TrimAction(ActionValue, "RD=");
		if(ReturnDateType.equalsIgnoreCase("FutureDate+1")){
			ReturnDate_str=dd.DealWithDates(ReturnDateType, DepartDate_str);
		}else if(ReturnDateType.equalsIgnoreCase("FutureDate+1")){
			ReturnDate_str=dd.DealWithDates(ReturnDateType, DepartDate_str);
		}else{
			ReturnDate_str=dd.DealWithDates(ReturnDateType, "none");
		}
		System.out.println("ReturnDate_str:"+ReturnDate_str);
		OL.EnterRetrunDate(ReturnDate_str);
		
	}
	
	public void v_ReturnDate() throws InterruptedException{
		OL.VerifyReturnDate(ReturnDate_str);
	}
	
	public void e_Class_First() throws InterruptedException{
		SeatClass="firstclass";
		OL.SelectSeatType(SeatClass);
	}
	
	public void e_Class_Coach() throws InterruptedException{
		SeatClass="coach";
		OL.SelectSeatType(SeatClass);
	}

	public void e_Class_Business() throws InterruptedException{
		SeatClass="business";
		OL.SelectSeatType(SeatClass);
	}
	
	public void e_Class_Any() throws InterruptedException{
		SeatClass="any";
		OL.SelectSeatType(SeatClass);
	}
	
	public void v_SeatPrefernce() throws InterruptedException{
		OL.VerifySeatType(SeatClass);
	}
	
	public void e_Airline() throws InterruptedException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		Airline=TrimAction(ActionValue, "Airline=");
		OL.SelectAirline(Airline);
	}
	
	public void v_PreferedAirline() throws InterruptedException{
		OL.VerifyAirline(Airline);
	}
	
	public void v_SrDOB_Check(){
		
	}
	
	public void e_SR_DOB_1() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		SRDOB1_Type=TrimAction(ActionValue, "SR1=");
		SRDOB1_str=dd.DOB_65(SRDOB1_Type, DepartDate_str);
		System.out.println("SRDOB1_str:"+SRDOB1_str);
		OL.EnterSr1DOB(SRDOB1_str);
	}
	
	public void v_SR_DOB1() throws InterruptedException{
		OL.VerifySR1DOB(SRDOB1_str);
	}
	
	public void e_SR_DOB_2() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		SRDOB2_Type=TrimAction(ActionValue, "SR2=");
		SRDOB2_str=dd.DOB_65(SRDOB2_Type, DepartDate_str);
		OL.EnterSr2DOB(SRDOB2_str);
		System.out.println("SRDOB2_str:"+SRDOB2_str);
	}
	
	public void v_SR_DOB2() throws InterruptedException{
		OL.VerifySR2DOB(SRDOB2_str);
	}
	
	public void e_SR_DOB_3() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		SRDOB3_Type=TrimAction(ActionValue, "SR3=");
		SRDOB3_str=dd.DOB_65(SRDOB3_Type, DepartDate_str);
		OL.EnterSr3DOB(SRDOB3_str);
		System.out.println("SRDOB3_str:"+SRDOB3_str);
	}
	
	public void v_SR_DOB3() throws InterruptedException{
		OL.VerifySR3DOB(SRDOB3_str);
	}
	
	public void e_SR_DOB_4() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		SRDOB4_Type=TrimAction(ActionValue, "SR4=");
		SRDOB4_str=dd.DOB_65(SRDOB4_Type, DepartDate_str);
		OL.EnterSr4DOB(SRDOB4_str);
		System.out.println("SRDOB4_str:"+SRDOB4_str);
	}
	
	public void v_SR_DOB4() throws InterruptedException{
		OL.VerifySR4DOB(SRDOB4_str);
	}
	
	public void e_LCDOB1() throws InterruptedException, ParseException{
		
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LCDOB1_Type=TrimAction(ActionValue, "LCDOB1=");
		String passDate=null;
		if(TripType.equals("One Way")){
			passDate=DepartDate_str;
		}else{
			passDate=ReturnDate_str;
		}
		LCDOB1_str=dd.DOB_2(LCDOB1_Type, passDate);
		System.out.println("LCDOB1_str= "+LCDOB1_str);
		OL.EnterLC1DOB(LCDOB1_str);
	}
	
	public void v_LC_DOB1() throws InterruptedException{
		OL.VerifyLC1DOB(LCDOB1_str);
	}
	
	public void e_LCDOB2() throws InterruptedException, ParseException{
		
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LCDOB2_Type=TrimAction(ActionValue, "LCDOB2=");
		String passDate=null;
		if(TripType.equals("One Way")){
			passDate=DepartDate_str;
		}else{
			passDate=ReturnDate_str;
		}
		LCDOB2_str=dd.DOB_2(LCDOB2_Type, passDate);
		System.out.println("LCDOB2_str= "+LCDOB2_str);
		OL.EnterLC2DOB(LCDOB2_str);
	}
	
	public void v_LC_DOB2() throws InterruptedException{
		OL.VerifyLC2DOB(LCDOB2_str);
	}
	
	public void e_LCDOB3() throws InterruptedException, ParseException{
		
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LCDOB3_Type=TrimAction(ActionValue, "LCDOB3=");
		String passDate=null;
		if(TripType.equals("One Way")){
			passDate=DepartDate_str;
		}else{
			passDate=ReturnDate_str;
		}
		LCDOB3_str=dd.DOB_2(LCDOB3_Type, passDate);
		System.out.println("LCDOB3_str= "+LCDOB3_str);
		OL.EnterLC3DOB(LCDOB3_str);
	}
	
	
	public void v_LC_DOB3() throws InterruptedException{
		OL.VerifyLC3DOB(LCDOB3_str);
	}
	
	public void e_LCDOB4() throws InterruptedException, ParseException{
		List<Action> Actions=getCurrentElement().getActions();
		String ActionValue=Actions.get(0).getScript();
		LCDOB4_Type=TrimAction(ActionValue, "LCDOB4=");
		String passDate=null;
		if(TripType.equals("One Way")){
			passDate=DepartDate_str;
		}else{
			passDate=ReturnDate_str;
		}
		LCDOB4_str=dd.DOB_2(LCDOB1_Type, passDate);
		System.out.println("LCDOB4_str= "+LCDOB4_str);
		OL.EnterLC4DOB(LCDOB4_str);
	}
	
	public void v_LC_DOB4() throws InterruptedException{
		OL.VerifyLC4DOB(LCDOB4_str);
	}
	
	public void e_Submit() throws InterruptedException{
		OL.SubmitFlightSearch();
	}
	
	public void v_Error1() throws InterruptedException{
		OL.ErrorDepartureDate();
	}
	
	public void v_Error2() throws InterruptedException{
		OL.ErrorSrDOB();
	}
	
	public void v_Error3() throws InterruptedException{
		OL.ErrorDestinationEqDepart();
	}
	
	public void v_Error4() throws InterruptedException{
		OL.ErrorTooManyLC();
	}
	
	public void v_Error5() throws InterruptedException{
		OL.ErrorArrivalDate();
	}
	
	public void v_Error6() throws InterruptedException{
		OL.ErrorLapChildDOB();
		
	}
	
	public void v_Error7()throws InterruptedException{
		
	}
	
	public void v_Execute_Search(){
		
	}
	
	public void v_Restart_Search(){
		
	}
	
	/*
	 * graphml vertexes used only for logical navigation
	 */
	
	public void v_nav(){
		
	}
	

	public void v_Logic_1(){
		System.out.println("@ Logic 1");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_2(){
		System.out.println("@ Logic 2");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_3(){
		System.out.println("@ Logic 3");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_4(){
		System.out.println("@ Logic 4");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_5(){
		System.out.println("@ Logic 5");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_6(){
		System.out.println("@ Logic 6");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_7(){
		System.out.println("@ Logic 7");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_8(){
		System.out.println("@ Logic 8");
		System.out.println("SR interger: "+SR_Passengers);
	}

	
	public void v_Logic_9(){
		System.out.println("@ Logic 9");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_10(){
		System.out.println("@ Logic 10");
		System.out.println("SR interger: "+SR_Passengers);
	}
	
	public void v_Logic_11(){
		
	}
	
	public void v_Logic_12(){
		
	}
	
	public void v_Logic_13(){
		
	}
	
	public void v_Logic_14(){
		
	}
	
	public void v_Logic_15(){
		
	}
	
	public void v_Logic_16(){
		
	}
	
	public void v_Logic_17(){
		
	}
	
	public void v_Logic_18(){
		
	}

	
	public void v_Logic_19(){
		
	}
	
	public void v_Logic_20(){
		
	}
	
	public void v_Logic_21(){
		
	}
	
	public void v_Logic_22(){
		
	}
	
	public void v_Logic_23(){
		
	}
	
	public void v_Logic_24(){
		
	}
	
	public void v_Logic_25(){
		
	}
	
	public void v_Logic_26(){
		
	}
	
	public void v_Logic_27(){
		
	}
	
	public void v_Logic_28(){
		
	}

	
	public void v_Logic_29(){
		
	}
	
	public void v_Logic_30(){
		
	}
	
	
	public void v_Logic_31(){
		
	}
	
	public void v_Logic_32(){
		
	}
	
	public void v_Logic_33(){
		
	}
	
	public void v_Logic_34(){
		
	}
	
	public void v_Logic_35(){
		
	}
	
	public void v_Logic_36(){
		
	}
	
	public void v_Logic_37(){
		
	}
	
	public void v_Logic_38(){
		
	}

	
	public void v_Logic_39(){
		
	}
	
	public void v_Logic_40(){
		
	}
	
	public void v_Logic_41(){
		
	}
	
	public void v_Logic_42(){
		
	}
	
	public void v_Break_1(){
		System.out.println("Break 1");
	}
	
	public void v_Break_2(){
		System.out.println("Break 2");
	}
	
	public void v_Break_3(){
		System.out.println("Break 3");
	}
	
	/*
	 * Set of helping functions
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
}
