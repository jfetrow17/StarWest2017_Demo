package StarWestFlightSearch;

import java.text.ParseException;

import StarWestFlightSearch.ObjectLibrary;

public class Scripted_Test {

	public static StarWestFlightSearch.ObjectLibrary OL;
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		OL.LaunchSite();
		OL.EnterUserName("Valid");
		OL.EnterPassword("Valid");
		OL.Logon();
		OL.Flight_Link();
		OL.SelectSRPass(4);
		OL.VerifySrPassengers(4);
		OL.EnterDepartDate("12/09/2017");
		OL.VerifyDepartDate("12/09/2017");
		OL.SelectSeatType("coach");
		OL.VerifySeatType("coach");
		
	 }
	
	
}
