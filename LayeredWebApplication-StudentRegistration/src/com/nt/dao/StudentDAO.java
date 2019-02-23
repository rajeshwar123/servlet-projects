package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO LAYERED_STUDENT VALUES(?,?,?,?,?)";
	public int insert(StudentBO bo) {
		//InitialContext ic=null;
		//DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			/*//create IntialContext
			ic=new InitialContext();
			//get DataSourse object through lookup operation
			ds=(DataSource)ic.lookup("DsJndi");
			//get conn from JDBC con pool
*/			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=ds.getConnection();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
			//create PreparedStatement object
			ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			//set values to query params
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setDouble(4,bo.getAvg());
			ps.setString(5,bo.getResult());
			//execute query
			result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
	return result;
	}//method
}//class
