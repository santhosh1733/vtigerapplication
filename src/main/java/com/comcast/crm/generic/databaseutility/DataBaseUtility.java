package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * contain the methods of data base actions
 * 
 */
public class DataBaseUtility {
	
	/**
	 * filling the step to connect data base
	 * @return void
	 * @throws SQLException
	 */
	public void getConnection() throws SQLException {
		/*
		 * providing implementation to driver object
		 * creating driver instance
		 */
		 Driver driver=new Driver();
    	 DriverManager.registerDriver(driver);
    	 /*
    	  * connecting to the data base using ip address
    	  */
    	Connection con = DriverManager.getConnection("jdbc:mysql:http://49.249.28.218:3333/ninza_hrm","root","root");
	}
	/**
	 * contains step to get data from the database
	 * @param Quary
	 * @param excepted
	 * @param number
	 * @return String
	 * @throws SQLException
	 */
     public String getDataFronDataBase(String Quary,String excepted,int num) throws SQLException {
    	 String res =null;
    	 Driver driver=new Driver();
    	 DriverManager.registerDriver(driver);
    	Connection con = DriverManager.getConnection("jdbc:mysql:http://49.249.28.218:3333/ninza_hrm","root","root");
    	 Statement statement = con.createStatement();
    	 /*
    	  * using statement execute the query
    	  */
    	 ResultSet result = statement.executeQuery(Quary);
    	 /*
    	  * get the result from the result variable using iteration method(next())
    	  * 
    	  */
    	 while(result.next()) {
    		 String data = result.getString(num);
    		 
    		 if(excepted.equals(data)) {
    			  res = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6); 
    		 }
    	 }
		return res;
    	 
     }
}
