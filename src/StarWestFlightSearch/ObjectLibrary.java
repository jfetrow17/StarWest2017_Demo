package StarWestFlightSearch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ObjectLibrary {
	
	public static String StepResult;
	public static WebDriver driver ;
	
	
	
	public static void LaunchSite() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:/Web_Flight/chromedriver.exe");
		driver = new ChromeDriver();
		//driver= new FirefoxDriver();
		driver.get("file:///C:/Web_Flight/SW_TravelServices_Logon.html");
		Thread.sleep(500);
		
	}
	
	public static void EnterUserName(String UN) throws InterruptedException{
		driver.findElement(By.id("usrnm")).clear();
		driver.findElement(By.id("usrnm")).sendKeys(UN);
		Thread.sleep(500);
	}
	
	public static String VerifyUserName(String UN) throws InterruptedException{
		
		driver.findElement(By.id("usrnm")).sendKeys(Keys.TAB);
		String Expected =driver.findElement(By.id("usrnm")).getAttribute("value");
		String Result=null;
		if(UN.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail, Expected: "+UN+", Actual: "+Expected;
		}
		Thread.sleep(500);
		return Result;
	}
	
	public static void EnterPassword(String PW) throws InterruptedException{
		driver.findElement(By.id("pw")).clear();
		driver.findElement(By.id("pw")).sendKeys(PW);
		Thread.sleep(500);
	}
	
	public static String VerifyPassword(String PW) throws InterruptedException{
		driver.findElement(By.id("pw")).sendKeys(Keys.TAB);
		String Expected =driver.findElement(By.id("pw")).getAttribute("value");
		String Result=null;
		if(PW.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail, Expected: "+PW+", Actual: "+Expected;
		}
		Thread.sleep(500);
		return Result;
	}
	
	public static void Logon() throws InterruptedException{
		driver.findElement(By.id("logon")).click();
		Thread.sleep(500);
	}
	
	public static String LogonError() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errLogon")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail, Expected: "+Expected+", Actual: "+style;
		}
		Thread.sleep(500);
		return Result;
	}
	
	public static void Logout() throws InterruptedException{
		driver.findElement(By.id("logout")).click();
		Thread.sleep(500);
	}
	
	public static void Flight_Link() throws InterruptedException{
		driver.findElement(By.id("flightsearch")).click();
		Thread.sleep(500);
	}
	
	public static void Hotel_Link() throws InterruptedException{
		driver.findElement(By.id("hotelsearch")).click();
		Thread.sleep(500);
	}
	
	public static void SelectSRPass(int SRP) throws InterruptedException{
		
		Select dropdown = new Select(driver.findElement(By.id("passengersSR")));
		dropdown.selectByValue(String.valueOf(SRP));
		Thread.sleep(700);
	}
	
	public static String VerifySrPassengers(int SRP) throws InterruptedException{
		int Expected=SRP;
		int Actual= Integer.parseInt(driver.findElement(By.id("passengersSR")).getAttribute("value"));
		String Result=null;
		if(Expected==Actual){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}
	
	public static void SelectPassengers(int P) throws InterruptedException{
		
		Select dropdown = new Select(driver.findElement(By.id("passengers")));
		dropdown.selectByValue(String.valueOf(P));
		Thread.sleep(500);
	}
	
	public static String VerifyPassengers(int P) throws InterruptedException{
		int Expected=P;
		int Actual= Integer.parseInt(driver.findElement(By.id("passengers")).getAttribute("value"));
		String Result=null;
		if(Expected==Actual){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}

	public static void SelectLCPass(int LCP) throws InterruptedException{
		
		Select dropdown = new Select(driver.findElement(By.id("passengersLap")));
		dropdown.selectByValue(String.valueOf(LCP));
		Thread.sleep(700);
	}
	
	public static String VerifyLapPassengers(int LCP) throws InterruptedException{
		int Expected=LCP;
		int Actual= Integer.parseInt(driver.findElement(By.id("passengersLap")).getAttribute("value"));
		String Result=null;
		if(Expected==Actual){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}
	
	public static void SelectTripType(String TripType) throws InterruptedException{
		String tt="roundtrip";
		if(TripType.equals("Round Trip")){
			tt="roundtrip";
		}else{
			tt="oneway";
		}
		Select dropdown = new Select(driver.findElement(By.id("triptype")));
		dropdown.selectByValue(String.valueOf(tt));
		Thread.sleep(500);
	}
	
	public static String VerifyTripType(String TripType) throws InterruptedException{
		String tt="roundtrip";
		if(TripType.equals("Round Trip")){
			tt="roundtrip";
		}else{
			tt="oneway";
		}
		String Expected=tt;
		String  Actual= driver.findElement(By.id("triptype")).getAttribute("value");
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}
	
	public static void SelectDeparturePort(String DeparturePort) throws InterruptedException{
		Select dropdown = new Select(driver.findElement(By.id("fromPort")));
		dropdown.selectByValue(String.valueOf(DeparturePort));
		Thread.sleep(500);
	}
	
	public static String VerifyDeparturePort(String DeparturePort) throws InterruptedException{
		String Expected=DeparturePort;
		String  Actual= driver.findElement(By.id("fromPort")).getAttribute("value");
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}
	
	public static void SelectDestinationPort(String Destination) throws InterruptedException{
		Select dropdown = new Select(driver.findElement(By.id("arrivePort")));
		dropdown.selectByValue(String.valueOf(Destination));
		Thread.sleep(500);
	}
	
	public static String  VerifyDestinationPort(String Destination) throws InterruptedException{
		String Expected=Destination;
		String  Actual= driver.findElement(By.id("arrivePort")).getAttribute("value");
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected;
		}
		return Result;
		
	}
	//Date field
	public static void EnterDepartDate(String Depart) throws InterruptedException{
		driver.findElement(By.id("departDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("departDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("departDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("departDate")).sendKeys(Depart);
		Thread.sleep(500);
	}
	
	public static String VerifyDepartDate(String Depart) throws InterruptedException{
		String Actual=driver.findElement(By.id("departDate")).getAttribute("value");
		String Expected=Depart;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
		
	}
	//Date Field
	public static void EnterRetrunDate(String Return) throws InterruptedException{
		driver.findElement(By.id("retDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("retDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("retDate")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("retDate")).sendKeys(Return);
		Thread.sleep(500);
	}
	
	public static String VerifyReturnDate(String Return) throws InterruptedException{
		String Actual=driver.findElement(By.id("retDate")).getAttribute("value");
		String Expected=Return;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
		
	}
	
	public static void SelectSeatType(String Seat) throws InterruptedException{
		driver.findElement(By.xpath("//span[@id='seatpref']/input[@value='"+Seat+"']")).click();
		Thread.sleep(500);
	}
	
	
	public static String VerifySeatType(String Seat) throws InterruptedException{
		String Result=null;
		
		driver.findElement(By.xpath("//span[@id='seatpref']/input[@value='"+Seat+"']")).getAttribute("checked");
		Result="Pass";
		WebElement RB=driver.findElement(By.xpath("//span[@id='seatpref']/input[@value='"+Seat+"']"));
		String Value=RB.getAttribute("checked");
		if(Value.equals("true")){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Value+", Expected:  true.";
		}
		return Result;
	
		
	}
	
	public static void SelectAirline(String airline) throws InterruptedException{
		Select dropdown = new Select(driver.findElement(By.id("airline")));
		dropdown.selectByValue(String.valueOf(airline));
		Thread.sleep(500);
	}
	
	public static String VerifyAirline(String airline) throws InterruptedException{
		String Actual=driver.findElement(By.id("airline")).getAttribute("value");
		String Expected=airline;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterSr1DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth1")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifySR1DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("SrDateofBirth1")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterSr2DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth2")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifySR2DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("SrDateofBirth2")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterSr3DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth3")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifySR3DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("SrDateofBirth3")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterSr4DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("SrDateofBirth4")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifySR4DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("SrDateofBirth4")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterLC1DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth1")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifyLC1DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("lcDateofBirth1")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterLC2DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth2")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifyLC2DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("lcDateofBirth2")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterLC3DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth3")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifyLC3DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("lcDateofBirth3")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	//Date Field
	public static void EnterLC4DOB(String DOB) throws InterruptedException{
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(Keys.TAB);
		driver.findElement(By.id("lcDateofBirth4")).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifyLC4DOB(String DOB) throws InterruptedException{
		String Actual=driver.findElement(By.id("lcDateofBirth4")).getAttribute("value");
		String Expected=DOB;
		String Result=null;
		
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void SubmitFlightSearch() throws InterruptedException{
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
	}
	
	public static String ErrorDepartureDate() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errDepDate")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorArrivalDate() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errArrDate")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorLapChildDOB() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errLCDOB")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorSrDOB() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errSrDOB")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorDestinationEqDepart() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errDepdes")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorTooManyLC() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errLC")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static String ErrorNoPassengers() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errNoPsgr")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	/**
	 * Select a Flight Screen
	 * @throws InterruptedException 
	 */
	
	public static void SelectFlight(int FlightNum) throws InterruptedException{
		
		if(FlightNum==0){
			//Do Nothing
		}else if(FlightNum==3){
			driver.findElement(By.id("r1")).click();
			driver.findElement(By.id("r2")).click();
		}else{
		driver.findElement(By.id("r"+FlightNum)).click();
		}
		Thread.sleep(500);
	}
	
	public static String VerifySelectedFlight(int FlightNum) throws InterruptedException{
		String Result;
		if(FlightNum==0){
			Result="Pass";
		}else if(FlightNum==3){
			Result="Pass";
		}else{
		WebElement CB=driver.findElement((By.id("r"+FlightNum)));
		String Value=CB.getAttribute("checked");
		if(Value.equals("true")){
			 Result="Pass";
		}else{
			 Result="Fail:  Actual="+Value+", Expected:  true.";
		}
		}
		return Result;
	}
	
	public static String VerifyFlightSelectError() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("errfltsel")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	public static void SubmitFlightSelection() throws InterruptedException{
		driver.findElement(By.id("continuebtn")).click();
		Thread.sleep(500);
	}
	
	/**
	 * 
	 * Guest Registration
	 */
	
	public static void EnterFirstName(int row, String FstName) throws InterruptedException{
		driver.findElement(By.id("ifName"+row)).clear();;
		driver.findElement(By.id("ifName"+row)).sendKeys(FstName);
		Thread.sleep(500);
	}
	
	public static String VerifyFirstName(int row, String FstName) throws InterruptedException{
		String Expected=FstName;
		String Actual =driver.findElement(By.id("ifName"+row)).getText();
		String Result=null;
		if(Actual.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected: "+Expected;
		}
		return Result;
	}
	
	public static void EnterLastName(int row, String LstName) throws InterruptedException{
		driver.findElement(By.id("ilName"+row)).clear();
		driver.findElement(By.id("ilName"+row)).sendKeys(LstName);
		Thread.sleep(500);
	}
	
	public static String VerifyLastName(int row, String LstName) throws InterruptedException{
		String Expected=LstName;
		String Actual =driver.findElement(By.id("ilName"+row)).getText();
		String Result=null;
		if(Actual.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected: "+Expected;
		}
		return Result;
	}
	//date field
	public static void EnterDOB(int row, String DOB) throws InterruptedException{
		
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.DELETE);
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.TAB);
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.DELETE);
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.TAB);
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.DELETE);
		driver.findElement(By.id("dDOB"+row)).sendKeys(Keys.TAB);
		driver.findElement(By.id("dDOB"+row)).sendKeys(DOB);
		Thread.sleep(500);
	}
	
	public static String VerifyDOB(int row, String DOB) throws InterruptedException{
		String Expected=DOB;
		String Actual =driver.findElement(By.id("dDOB"+row)).getText();
		String Result=null;
		if(Actual.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected: "+Expected;
		}
		return Result;
	}
	
	public static void EnterPasspot(int row, String Passport) throws InterruptedException{
		driver.findElement(By.id("ipp"+row)).clear();
		driver.findElement(By.id("ipp"+row)).sendKeys(Passport);
		Thread.sleep(500);
	}
	
	public static String VerifyPassport(int row, String Passport) throws InterruptedException{
		String Expected=Passport;
		String Actual =driver.findElement(By.id("ipp"+row)).getText();
		String Result=null;
		if(Actual.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected: "+Expected;
		}
		return Result;
	}
	
	public static void SelectGender(int row, String Gender) throws InterruptedException{
		Select dropdown = new Select(driver.findElement(By.id("igender"+row)));
		dropdown.selectByValue(String.valueOf(Gender));
		Thread.sleep(500);
	}
	
	public static String VerifyGender(int row, String Gender) throws InterruptedException{
		String Result=null;
		String Expected=Gender;
		String Actual=driver.findElement(By.id("igender"+row)).getAttribute("value");
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void SelectLC(int row,String LC) throws InterruptedException{
		if(LC.equals("True")){
			driver.findElement(By.id("dlccb"+row)).click();
		}else{
			//Do Nothing
		}
		Thread.sleep(500);
	}
	
	
	public static void ConfirmGuests() throws InterruptedException{
		driver.findElement(By.id("Save")).click();
		Thread.sleep(500);
	}
	
	public static void Hotel_SelectDestination(String City) throws InterruptedException{
		Select dropdown = new Select(driver.findElement(By.id("fromPort")));
		dropdown.selectByValue(String.valueOf(City));
		Thread.sleep(500);
	}
	
	public static String Hotel_VerifyDestination(String City) throws InterruptedException{
		String Result=null;
		String Expected=City;
		String Actual=driver.findElement(By.id("fromPort")).getAttribute("value");
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void Hotel_EnterArrival(String Arrival) throws InterruptedException{
		driver.findElement(By.id("arrvdt")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("arrvdt")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("arrvdt")).sendKeys(Keys.DELETE);
		driver.findElement(By.id("arrvdt")).sendKeys(Arrival);
		Thread.sleep(500);
	}
	
	public static String Hotel_VerifyArrivalDate(String Arrival) throws InterruptedException{
		String Result=null;
		String Expected=Arrival;
		String Actual=driver.findElement(By.id("arrvdt")).getText();
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void Hotel_SelectLengthOfStay(int LOS) throws InterruptedException{
		String x=String.valueOf(LOS);
		
		Select dropdown = new Select(driver.findElement(By.id("los")));
		dropdown.selectByValue(String.valueOf(x));
		Thread.sleep(500);
	}

	public static String Hotel_VerifyLengthOfStay(int LOS) throws InterruptedException{
		String Expected=String.valueOf(LOS);
		String Actual=driver.findElement(By.id("los")).getAttribute("value");
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static String Hotel_VerifyDepartDate(int LOS, String Arrival) throws ParseException, InterruptedException{
		
		Date DepartDate=StringToDate(Arrival);
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(DepartDate); // Now use today date.
		c.add(Calendar.DATE, LOS); // Adding 5 days
		String Expected = sdf.format(c.getTime());
		
		
		String Actual=driver.findElement(By.id("dpart")).getText();
		
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void Hotel_SelectGuests(int Guests) throws InterruptedException{
		String x=String.valueOf(Guests);
		Select dropdown = new Select(driver.findElement(By.id("guests")));
		dropdown.selectByValue(String.valueOf(x));
		Thread.sleep(500);
	}

	public static String Hotel_VerifyGuests(int Guests) throws InterruptedException{
		String Expected=String.valueOf(Guests);
		String Actual=driver.findElement(By.id("guests")).getAttribute("value");
		String Result=null;
		if(Expected.equals(Actual)){
			Result="Pass";
		}else{
			Result="Fail:  Actual="+Actual+", Expected:"+Expected+".";
		}
		return Result;
	}
	
	public static void Hotel_Search() throws InterruptedException{
		driver.findElement(By.id("search")).click();
		Thread.sleep(500);
	}
	
	public static String Hotel_ErrorMsg() throws InterruptedException{
		String Expected="display: block;";
		String style=driver.findElement(By.id("msg3")).getAttribute("style");
		String Result=null;
		if(style.equals(Expected)){
			Result="Pass";
		}else{
			Result="Fail";
		}
		return Result;
	}
	
	/**
	 * Some support Functions
	 * @return 
	 * @throws ParseException 
	 * 
	 */
	
	public static Date StringToDate (String _date) throws ParseException{
		String string = _date;
		DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date date = format.parse(string);
		
		return date;
	}
	
	
}
