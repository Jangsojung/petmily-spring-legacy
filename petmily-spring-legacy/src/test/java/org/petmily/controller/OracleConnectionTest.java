package org.petmily.controller;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {

	private static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	private static final String URL = 
			"jdbc:oracle:thin:@petmily_medium?TNS_ADMIN=/Users/joojongbum/oracle_db/Wallet_petmily/";
	private static final String USER = 
			"jjb1";
	private static final String PW = 
			"Petmilymember1";

	@Test
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println(con);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
