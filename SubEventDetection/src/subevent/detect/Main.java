package subevent.detect;

public class Main {

	public static void main(String[] a) {

		MyDatabase myDatabase = new MyDatabase();

		CheckTimeManager checkTimeManager = new CheckTimeManager(myDatabase.getAllTheData());
		checkTimeManager.sortAll();
		checkTimeManager.combineSameTimes();
		
		
		//1
		checkTimeManager.giveOutputOnColsole(30, 200);
		//2
		checkTimeManager.giveOutputToFile(30, 200, "ValueGreaterThreshold/Subevent_Interval_For_Greater_Than_Treshold.csv");
		checkTimeManager.giveOutputToAFileWhereTheValueIsBelowThreshold(30, 200, "ValueBelowThreshold/Subevent_Interval_For_Lower_Than_Treshold.csv");
		//3
		checkTimeManager.giveOutputToFileAllUsingGivenTime(30, 200, "alloutput.csv");
		

		
		
		System.err.println("End Programme");
	}

} 
