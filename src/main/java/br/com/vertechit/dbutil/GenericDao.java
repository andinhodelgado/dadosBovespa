/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vertechit.dbutil;

/**
 *
 * @author home
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class GenericDao {
	
	private static Connection conn;

	public GenericDao() {
		
	}
        
	public static Connection getConnection() {
		try {
			if (conn == null) {
				String conDriver = "oracle.jdbc.driver.OracleDriver";	
				Class.forName(conDriver);
				String url = null, user = null, password = null;
                                
                                System.out.println();
                                
                                url      = "jdbc:oracle:thin:@//stafe-scan:1521/apex";
                                user     = "controladoria";
                                password = "control123";
				
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
	          e.printStackTrace();
	          throw new RuntimeException("Erro getConnection : "+e.getMessage());
	      }
	      return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro closeConnection3: " + e.getMessage());
			}

		}
	}
	
}