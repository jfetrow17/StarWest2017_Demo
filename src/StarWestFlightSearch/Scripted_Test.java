package StarWestFlightSearch;

import java.text.ParseException;

import StarWestFlightSearch.ObjectLibrary;

public class Scripted_Test {

	public static StarWestFlightSearch.ObjectLibrary OL;
	public static StarWestFlightSearch.DealWithDates DD;
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		OL.LaunchSite();
		OL.EnterUserName("Valid");
		OL.EnterPassword("Valid");
		OL.Logon();
		OL.Flight_Link();
		OL.SelectLCPass(1);
		OL.EnterLC1DOB(DD.DOB_2("<2 at Return", "10/10/2017"));
		
	 }
	
	
}
