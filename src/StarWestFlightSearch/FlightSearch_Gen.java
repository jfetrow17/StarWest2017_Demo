package StarWestFlightSearch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.StopCondition;
import org.graphwalker.core.condition.StopConditionException;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.PathGenerator;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Model;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.testng.annotations.Test;

import SW_MercuryToursDemo.Home_API;
import SW_MercuryToursDemo.Home_GW.TestContext;

public class FlightSearch_Gen {

	
	@Test
	 public void edge() throws InterruptedException, StopConditionException, URISyntaxException {
	 Model model = new Model();

	 String FileA = "/StarWestFlightSearch/graphml/Web_Flight_Search_V1.graphml";
	 
	 	 
	 PathGenerator pathGenerator = new RandomPath(new EdgeCoverage(100));
	 //PathGenerator pathGenerator = new RandomPath(new TimeDuration(100, TimeUnit.MINUTES));
	  Context context = new TestContext (model, pathGenerator);
	  context.setModel(model.build());
	  context.setPathGenerator(new RandomPath(new EdgeCoverage(100)));
	  
	  Result result =  new TestBuilder()
		 .addModel(FileA, new FlightSearch_GWAPI().setPathGenerator(new RandomPath((StopCondition) new EdgeCoverage(100))))
		 
		 .execute();
	 
	/* modelhandler.add("BasicLogin", new AdminConsole_GWAPI(file_A,true, new RandomPathGenerator(new EdgeCoverage(1)),false));
	 modelhandler.add("StaffDetail", new StaffDetailsGWAPI(file_B, true, new RandomPathGenerator(new EdgeCoverage (1)), false));
	 // Start executing the test
	// modelhandler.execute("StaffDetail");
	 modelhandler.execute("BasicLogin");
	 // Verify that the execution is complete, fulfilling the criteria from above.
	 Assert.assertTrue(modelhandler.isAllModelsDone(), "Not all models are done");*/
	 // Print the statistics from graphwalker
	  String actualResult = "Statistics for 100% Edge Coverage:";
		if (result.hasErrors()) {
	        for (String error : result.getErrors()) {
	        	actualResult = actualResult  + "\r\n\r\n" + error;
	            System.out.println(error);
	        }
	    }
		actualResult = actualResult + "\r\n\r\n" + result.getResultsAsString();
		System.out.println(actualResult);
	 
	 try{
		  // Create file 
		  FileWriter fstream = new FileWriter("MercuryTours_Home.txt");
		  BufferedWriter out = new BufferedWriter(fstream);
		  out.write(actualResult);
		  //Close the output stream
		  out.close();
		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	}


	public class TestContext extends ExecutionContext {
		public TestContext(Model model, PathGenerator pathGenerator) {
			super(model, pathGenerator);
		}
	}
}
