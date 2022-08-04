package jobdetails;

import  java.sql.Connection;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class LocationDetails {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
		Connection conn = ods.getConnection();
		Statement stmt = conn.createStatement();

		// Execute a statement - DO THIS WITH AT LEAST 3 TABLES - provide screenshot
		ResultSet rset = stmt.executeQuery("Select location_id, street_address, postal_code, "
				+ "city, state_province, country_id from locations");
		
		//  Iterate  through  the  result  and  print  the  employee  names  and  ID
		System.out.println("Location ID" + "\t" + "Street Address" + "\t" + "Postal Code" + "\t" 
						 + "City" + "\t" + "State Province" + "\t" + "Country ID");
		System.out.println();
		while (rset.next()) {
			System.out.println(rset.getString(1)
					  + "\t" + rset.getString(2)
					  + "\t" + rset.getString(3)
					  + "\t" + rset.getString(4)
					  + "\t" + rset.getString(5)
					  + "\t" + rset.getString(6));
		}//end while

		//close the resources
		rset.close();
		stmt.close();
	}//end method main
}//end class LocationDetails
