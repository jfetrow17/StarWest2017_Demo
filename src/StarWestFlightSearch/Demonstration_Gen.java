package StarWestFlightSearch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.StopCondition;
import org.graphwalker.core.condition.StopConditionException;
import org.graphwalker.core.condition.VertexCoverage;
import org.graphwalker.core.generator.PathGenerator;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.model.Model;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.testng.annotations.Test;

import StarWestFlightSearch.*;


public class Demonstration_Gen {

	
	
	

	@Test
	
	 
	 public void Demo() throws InterruptedException, StopConditionException, URISyntaxException {
	 Model model = new Model();

	 String FileA = "/StarWestFlightSearch/graphml/SWLogon_Home.graphml";
	 String FileB = "/StarWestFlightSearch/graphml/Web_Flight_Search_V2.graphml";
	 String FileC = "/StarWestFlightSearch/graphml/SelectFlight.graphml";
	 String FileD = "/StarWestFlightSearch/graphml/GuestRegistration.graphml";//50%
	 String FileE = "/StarWestFlightSearch/graphml/GuestRegDetails.graphml"; //25%
	 String FileF = "/StarWestFlightSearch/graphml/HotelSearch.graphml";
	 
	 
		
	 
	 PathGenerator pathGenerator = new RandomPath(new EdgeCoverage(100));
	 //PathGenerator pathGenerator = new RandomPath(new TimeDuration(100, TimeUnit.MINUTES));
	  Context context = new TestContext (model, pathGenerator);
	  context.setModel(model.build());
	  context.setPathGenerator(new RandomPath(new EdgeCoverage(100)));
	  
	  Result result =  new TestBuilder()
		 .addModel(FileA, new SWFLIGHT_Logon_Home().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .addModel(FileB, new FlightSearch_GWAPI().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .addModel(FileC, new SelectFlight_API().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .addModel(FileD, new GuestReg_API().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .addModel(FileE, new GuestReg_Details_API().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .addModel(FileF, new HotelSearch_API().setPathGenerator(new RandomPath((StopCondition) new VertexCoverage(10))))
		 .execute();
	 
	/* modelhandler.add("BasicLogin", new AdminConsole_GWAPI(file_A,true, new RandomPathGenerator(new EdgeCoverage(1)),false));
	 modelhandler.add("StaffDetail", new StaffDetailsGWAPI(file_B, true, new RandomPathGenerator(new EdgeCoverage (1)), false));
	 // Start executing the test
	// modelhandler.execute("StaffDetail");
	 modelhandler.execute("BasicLogin");
	 // Verify that the execution is complete, fulfilling the criteria from above.
	 Assert.assertTrue(modelhandler.isAllModelsDone(), "Not all models are done");*/
	 // Print the statistics from graphwalker
	  String actualResult = "Statistics for Demo:";
		if (result.hasErrors()) {
	        for (String error : result.getErrors()) {
	        	actualResult = actualResult  + "\r\n\r\n" + error;
	            System.out.println(error);
	        }
	    }
		actualResult = actualResult + "\r\n\r\n" + result.getResultsAsString();
		System.out.println(actualResult);

	}


	public class TestContext extends ExecutionContext {
		public TestContext(Model model, PathGenerator pathGenerator) {
			super(model, pathGenerator);
		}
	}
}

