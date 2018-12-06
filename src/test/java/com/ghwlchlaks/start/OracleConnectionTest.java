package com.ghwlchlaks.start;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final Logger Logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "system";
	private static final String PW = "1234";
	
	@Test //JUnit�� �׽�Ʈ�ϴ� �ڵ�
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try(Connection conn= DriverManager.getConnection(URL, USER, PW)) {
			Logger.info("����Ŭ�� ����Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
