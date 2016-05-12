package com.webapp.iamcmi.tester;
//STEP 1. Import required packages
import java.sql.*;

public class TestConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:8889/IAMCMIDB";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		testConnection();
	}//end main
	
	public static void testConnection(){
		
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			System.out.println("Connecting to database...");

			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM VehicalRedbook";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("VEH_ID_PK");
				int key  = rs.getInt("VEH_ID_PK");
				String first = rs.getString("VEH_MakeName");

				//Display values
				System.out.print("No: " + id);
				System.out.print(", Key: " + key);
				System.out.println(", Name: " + first);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		
	}
}//end FirstExample
