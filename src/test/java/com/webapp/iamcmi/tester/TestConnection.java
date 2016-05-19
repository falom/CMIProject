package com.webapp.iamcmi.tester;
//STEP: Import required packages
import java.sql.*;

public class TestConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:8889/";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	private static String tableName = "";
	private static String columnKey = "id";
	private static String columnDesc = "test_desc";

	public static void main(String[] args) {
		//testConnection();
		//testCreateTable("STUDENT");
		
		//String sql = "";
		String sql = "INSERT INTO `TestTable` (`id`, `first`, `last`, `age`) VALUES (5, 'Test', 'Test', 34);";
		//String sql = "UPDATE Registration SET age = 30 WHERE id in (100, 101)";
		//String sql = "DELETE FROM `"+tableName+"` WHERE `id` = 0";
		
		testExecute("STUDENT", sql);
		//testDropTable("STUDENT");
		
	}//end main
	 
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColumnDesc() {
		return columnDesc;
	}
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}


	public static void testConnection(){
		
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP: Execute a query
			//System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String selectSql;
			selectSql = "SELECT * FROM "+tableName;
			ResultSet rs = stmt.executeQuery(selectSql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int key  = rs.getInt(columnKey);
				String desc = rs.getString(columnDesc);

				//Display values
				System.out.print("Key: " + key);
				System.out.println(", Desc: " + desc);
			}//end while
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}//end try
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}//end catch
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}//end catch
		finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}//end try
			catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}//end try
			catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try		
	}//end testConnection method

	@SuppressWarnings("resource")
	public static void testCreateTable(String createDatabaseName){

		Connection conn = null;
		Statement stmt = null;
		tableName="testCreateTable";
		try{
			//STEP: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//STEP: Execute a query
			//System.out.println("Creating database...");
			stmt = conn.createStatement();
			String createTableSql;
			if(checkExistingDB(createDatabaseName)){
				System.out.println("Database already existing...");
			}
			else{
				createTableSql = "CREATE DATABASE "+createDatabaseName;
				stmt.executeUpdate(createTableSql);
				System.out.println("Database created successfully...");
				
				//STEP 4: Execute a query
				conn = DriverManager.getConnection(DB_URL+createDatabaseName, USER, PASS);
				System.out.println("Creating table in given database...");
				stmt = conn.createStatement();

				String createTablesSql; 
				createTablesSql = "CREATE TABLE TestTable" +
						"(id INTEGER not NULL, " +
						" first VARCHAR(255), " + 
						" last VARCHAR(255), " + 
						" age INTEGER, " + 
						" PRIMARY KEY ( id ))"; 
				
				stmt.executeUpdate(createTablesSql);
			    System.out.println("Created table in given database...");
			}		
		}//end try
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}//end catch
		catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}//end catch
		finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}//end try
			catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}//end try
			catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try		
	}//end testConnection method

	private static boolean checkExistingDB(String createDatabaseName) {
		// Create connection and statement
		String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema'[createDatabaseName]'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean exists = false;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if(conn != null){
				rs = conn.getMetaData().getCatalogs();
				while(rs.next()){
					String catalogs = rs.getString(1);
					if(createDatabaseName.equals(catalogs)){
						exists=true;
					}
				}
			}
		}
		catch(Exception e){ e.printStackTrace();} //end catch
		finally{
			if( rs != null ){
				try{ rs.close(); } //end try
				catch(SQLException ex){ ex.printStackTrace(); } //end catch
			}//end if
			if( conn != null ){
				try{ conn.close(); } //end try
				catch(SQLException ex){ ex.printStackTrace(); } //end catch
			}//end if
		}
		//System.out.println("exists: "+exists);
		return exists;   
	}//end checkExistingDB method

	public static void testDropTable(String dropTableName){

		Connection conn = null;
		Statement stmt = null;
		tableName="testCreateTable";
		try{
			//STEP: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//STEP: Execute a query
			//System.out.println("Creating database...");
			stmt = conn.createStatement();
			
			if(checkExistingDB(dropTableName)){
				String createTableSql;
				createTableSql = "DROP DATABASE "+dropTableName;
				stmt.executeUpdate(createTableSql);
				System.out.println("Database droped successfully...");
			}
			else{
				System.out.println("No Database existing...");
			}
		}//end try
		catch(SQLException se){ se.printStackTrace(); }//end catch
		catch(Exception e){ e.printStackTrace(); }//end catch
		finally{
			try{
				if(stmt!=null){ stmt.close(); }//end if
			}//end try
			catch(SQLException se2){}// nothing we can do
			try{
				if(conn!=null){ conn.close(); }//end if
			}//end try
			catch(SQLException se){	se.printStackTrace(); }//end finally
		}//end try		
	}//end testConnection method

	public static void testExecute(String dbName, String executeQuery){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			if(checkExistingDB(dbName)){
				//System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL+dbName, USER, PASS);
				stmt = conn.createStatement();
				stmt.executeUpdate(executeQuery);
				System.out.println("Execute successfully...");
			}//end if
			else{
				System.out.println("No Database existing...");
			}//end else
		}//end try
		catch(SQLException se){ se.printStackTrace(); }//end catch
		catch(Exception e){ e.printStackTrace(); }//end catch
		finally{
			try{
				if(stmt!=null){ stmt.close(); }//end if
			}//end try
			catch(SQLException se2){}// nothing we can do
			try{
				if(conn!=null){ conn.close(); }//end if
			}//end try
			catch(SQLException se){	se.printStackTrace(); }//end finally
		}//end try		
	}//end testConnection method


}//end FirstExample
