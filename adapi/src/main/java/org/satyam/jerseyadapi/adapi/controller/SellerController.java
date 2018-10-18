package org.satyam.jerseyadapi.adapi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SellerController {
	private Connection con;
	public SellerController() {
		String uname="root";
		String pwd="root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/advertisementproject?autoReconnect=true&useSSL=false",uname,pwd);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public int addSeller(Seller obj) {
		int sid=obj.getSid();
		String sname=obj.getSname();
		String saddress=obj.getSaddress();
		int i=0;
		try {
			PreparedStatement stmt=con.prepareStatement("insert into sellerinfo(sid,sname,saddress) values(?,?,?)");
			stmt.setInt(1, sid);
			stmt.setString(2, sname);
			stmt.setString(3, saddress);
			i=stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
}
