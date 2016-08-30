package subevent.detect;

public class Main {

	public static void main(String[] a) {

		MyDatabase myDatabase = new MyDatabase();

		CheckTimeManager checkTimeManager = new CheckTimeManager(myDatabase.getAllTheData());
		checkTimeManager.sortAll();
		checkTimeManager.combineSameTimes();
		
		checkTimeManager.giveOutputOnColsole(30, 200);
		checkTimeManager.giveOutputToFile(30, 200, "gp2.csv");

		
		
		System.err.println("End Programme");
	}

}
