package StarWestFlightSearch;

import java.text.ParseException;

public class Testing {

	static StarWestFlightSearch.ObjectLibrary OL;
	public static String Date;
	public static void main(String[] args) throws ParseException, InterruptedException {
		OL.LaunchSite();
		OL.EnterUserName("Valid");
		OL.EnterPassword("Valid");
		OL.Logon();
		OL.Hotel_Link();
		OL.Hotel_SelectDestination("London");
		OL.Hotel_EnterArrival("08/26/2017");
		OL.Hotel_SelectLengthOfStay(1);
	 }
}
