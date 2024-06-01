package com.coding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Dao {
	private static Scanner sc = new Scanner(System.in);
	private static final String url = "jdbc:mysql://127.0.0.1:3306/EmployeeSystem";
	private static final String pwd = "vikas1234";
	private static final String user = "root";
	public  static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url,user,pwd);
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Manager> ViewAllManager(String roles) {
		ArrayList<Manager> al = new ArrayList<>();
		Manager m = null;
		try {
			String sql = "SELECT * FROM Users WHERE roles=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, roles);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				m = new Manager();
				m.setMid(rs.getInt(1));
				m.setFname(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPwd(rs.getString(4));
				m.setRoles(rs.getString(5));
				al.add(m);
			}
			return al;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public static boolean AddManager(Manager u) {
		try {
			String sql = "INSERT INTO Users(fname,email,pwd,roles) VALUE(?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,u.getFname());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPwd());
			ps.setString(4,u.getRoles());
			int ar = ps.executeUpdate();
			if(ar>0)
				return true;
			else
				return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static Manager CheckManager(String email, String pwd) {
		Manager m = null;
		try {
			String sql = "select * from Users where email=? and pwd=md5(?)";
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				m = new Manager();
				m.setMid(rs.getInt(1));
				m.setFname(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPwd(rs.getString(4));
				m.setRoles(rs.getString(5));
			}
			return m;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	public static boolean addStaff(Manager u) {
		    try {
		        String sql = "INSERT INTO Users(fname,email,pwd,roles) VALUES(?,?,?,?)";
		        PreparedStatement ps = getConnection().prepareStatement(sql);
		        ps.setString(1, u.getFname());
		        ps.setString(2, u.getEmail());
		        ps.setString(3, u.getPwd());
		        ps.setString(4, u.getRoles());
		        int ar = ps.executeUpdate();
		        return ar > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	// remove
	public static boolean RemoveStaff(int id) {
	    try {
	        String sql = "DELETE FROM Users WHERE uid=?";
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setInt(1, id);
	        int ar = pst.executeUpdate();
	        return ar > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public static boolean MarkAct(int sts,int uid) {
	    try {
	        String sql = "UPDATE Users SET sts=? WHERE uid=?";
	        PreparedStatement pst = getConnection().prepareStatement(sql);
	        pst.setInt(1, sts); 
	        pst.setInt(2,uid); 
	        int rows = pst.executeUpdate();
	        if (rows > 0) {
	            System.out.println("Status updated successfully.");
	            return true;
	        } else {
	            System.out.println("No manager with the specified role found.");
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public static boolean UpdateSalary(int uid,int salary) {
		try {
			String sql = "UPDATE users SET salary=? WHERE uid=?";
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, salary);
			pst.setInt(2, uid);
			int ar = pst.executeUpdate();
			if(ar>0)
				return true;
			else
				return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Manager> ViewAllUsers(){
		ArrayList<Manager> al = new ArrayList();
		Manager m = null;
		try {
			String sql = "SELECT * FROM users WHERE sts=1";
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				m = new Manager();
				m.setMid(rs.getInt(1));
				m.setFname(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPwd(rs.getString(4));
				m.setRoles(rs.getString(5));
				m.setSts(rs.getInt(6));
				m.setSalary(rs.getString(7));
				al.add(m);
			}
			return al;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}