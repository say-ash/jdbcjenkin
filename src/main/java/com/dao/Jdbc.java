package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.Registration;

public class Jdbc {

	Connection con;
	PreparedStatement ps;
	int i;
	
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","Newuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}
	
public int saveData(List<Registration> lst){
		
		Registration r = (Registration)lst.get(0);
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into registration_details1 values(?,?,?,?,?)");
			ps.setString(1, r.getEmail());
			ps.setString(2, r.getFirstname());
			ps.setString(3, r.getLastname());
			ps.setString(4, r.getPassword());
			ps.setLong(5, r.getContact_no());
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("test11");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("global.."+e);
		}
		return i;
	}
}
