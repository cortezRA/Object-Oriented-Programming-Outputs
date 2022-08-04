package jobdetails;

import  java.sql.Connection;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DepartmentDetails {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
		Connection conn = ods.getConnection();
		Statement stmt = conn.createStatement();

		// Execute a statement - DO THIS WITH AT LEAST 3 TABLES - provide screenshot
		ResultSet rset = stmt.executeQuery("Select department_id, department_name, manager_id, location_id from departments");
		
		//  Iterate  through  the  result  and  print  the  employee  names  and  ID
		System.out.println("Department ID" + "\t" + "Department Name" + "\t" + "Manager ID" + "\t" + "Location ID");
		System.out.println();
		while (rset.next()) {
			System.out.println(rset.getString(1)
					  + "\t" + rset.getString(2)
					  + "\t" + rset.getString(3)
					  + "\t" + rset.getString(4));
		}//end while

		//close the resources
		rset.close();
		stmt.close();
	}//end method main
}//end class DepartmentDetails
