package StarWestFlightSearch;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;




public class LoggingFunctions {
	
	
	
	public static void CreateExecutionLog(String TodaysDate){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String ExecutionDate=dateFormat.format(date);
		String FN="FlightSearchExecutionLog_"+TodaysDate;
		
		
		File file = new File(FN);
		try(FileWriter fw = new FileWriter("C:/Web_Flight/TestLogs/"+file+".txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    System.out.println(file+" has been created.");
			    out.println("Test Running.....");
				out.println("Test Date:  "+ExecutionDate);
				out.println("**********************************************");
				out.println("");
				out.close();
			} catch (IOException e) {
				 System.out.println("Error writing to file:  "+e);
			}
	}
	
	public static void AddStepToTestLog(String Description){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		DateFormat df2=new SimpleDateFormat("MMddyyyy");
		String ExecutionDate=dateFormat.format(date);
		String TodaysDate=df2.format(date);
		String FN="FlightSearchExecutionLog_"+TodaysDate;
		
		
		File file = new File(FN);
		try(FileWriter fw = new FileWriter("C:/Web_Flight/TestLogs/"+file+".txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("--------------------------------New Step---------------------------------------");
			    out.println("Executed @ "+ExecutionDate);
				out.println("Description:  "+Description);
				out.close();
			} catch (IOException e) {
				 System.out.println("Error writing to file:  "+e);
			}
	}
	
	public static void AddExpectedResult(String Expected){
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		DateFormat df2=new SimpleDateFormat("MMddyyyy");
		String ExecutionDate=dateFormat.format(date);
		String TodaysDate=df2.format(date);
		String FN="FlightSearchExecutionLog_"+TodaysDate;
		
		File file = new File(FN);
		try(FileWriter fw = new FileWriter("C:/Web_Flight/TestLogs/"+file+".txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("Expected:  "+Expected);
				out.close();
			} catch (IOException e) {
				 System.out.println("Error writing to file:  "+e);
			}
	}
	
	public static void AddActualResult(String Result){
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		DateFormat df2=new SimpleDateFormat("MMddyyyy");
		String ExecutionDate=dateFormat.format(date);
		String TodaysDate=df2.format(date);
		String FN="FlightSearchExecutionLog_"+TodaysDate;
		
		File file = new File(FN);
		try(FileWriter fw = new FileWriter("C:/Web_Flight/TestLogs/"+file+".txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("Actual result:  "+Result);
			    out.println("--------------------------------End Step---------------------------------------");
			    out.println("");
				out.close();
			} catch (IOException e) {
				 System.out.println("Error writing to file:  "+e);
			}
	}


}

