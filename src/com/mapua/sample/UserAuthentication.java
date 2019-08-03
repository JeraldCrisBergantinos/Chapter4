package com.mapua.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAuthentication {
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   //static final String DB_URL = "jdbc:mysql://localhost/EMP";
   static final String DB_URL = "jdbc:mysql://localhost/javaee_training?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
	
	public static boolean authenticateUser(String userName, String password) {
		
		boolean result = false;
		Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT COUNT(*) COUNT FROM ACCESS_TABLE WHERE USER_NAME='" + userName + "' AND PASSWORD='" + password + "';";
	      System.out.println(sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      
	    //STEP 5: Extract data from result set
	      try {
	    	  if (rs.next() && rs.getInt("COUNT") > 0) {
	    		  result = true;
	    	  }
	      } catch (Exception e) {
	    	  e.printStackTrace();
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
		
		return result;
	}
	
	public static boolean validateAccess(AccessData credsData){
		System.out.println("Start validate Access");
		boolean isValid = false;
		databaseController ctrl = new databaseController();
		DatabaseSource ds = new DatabaseSource();
		Connection conn = ds.getConnection();
		isValid = ctrl.getAccess(conn,credsData);
		return isValid;
	}
	
	public static boolean validateAccess(String userId, String password){
		return validateAccess(new AccessData(userId, password));
	}
}
