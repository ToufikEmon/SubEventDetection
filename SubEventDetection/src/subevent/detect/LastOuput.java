package subevent.detect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LastOuput {

	public static String lastOutputFileName = "em.csv";

	public void giveOuput(List<OutputGenerator> now) {

		MyDatabase myDatabase = new MyDatabase();

		int len = now.size();

		StringBuilder output1 = new StringBuilder();
		output1.append("A,B , Total \n");

		for (int i = 0; i < len; i++) {
			String qq = "SELECT * FROM `eventdataset` WHERE Time BETWEEN ";
			qq += "'Sun Aug ";
			qq += now.get(i).getStart();
			qq += " BDT 2016' AND";
			qq += " 'Sun Aug ";
			qq += now.get(i).getEnd();
			qq += " BDT 2016'";

			ResultSet rs = myDatabase.executeQueryAndGiveBackTheDataList(qq);

			try {
				while (rs.next()) {
					output1.append(rs.getString(1) + ",");
					output1.append(rs.getString(2) + ",");
					output1.append(rs.getString(3) + "\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		try {
			
			PrintWriter pw = new PrintWriter(new File(lastOutputFileName));
			pw.write(output1.toString());
			pw.close();
			System.err.println("Saving to A File is Done");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
