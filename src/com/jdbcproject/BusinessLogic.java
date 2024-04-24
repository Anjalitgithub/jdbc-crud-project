package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BusinessLogic {
	static String url="jdbc:mysql://localhost:3306/palle";
	static String user="root";
	static String password="AnjuRanju@8431";
	static String createTable="create table emp(eid int primary key,ename varchar(20),eexp int,esalary int)";
	static String insert1="insert into emp values(?,?,?,?)";
	static String select="select * from emp";
	static String update1=" update emp set name=?, course=? where id=?";
	static String delete1="delete from emp where id=?";
	static Connection c=null;
	static Statement s=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	public static void createTable() {
		try {
			//loading and registering the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			 c=DriverManager.getConnection(url,user,password);
			 //creating statement object
			 s=c.createStatement();
			 //injecting and updating into database
			 s.executeUpdate(createTable);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing the connections
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void insert(int eid,String ename,int eexp,int esalary)
	{
		try {
			//loading and registering the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			 c=DriverManager.getConnection(url,user,password);
			 //creating prepared statement object
			 ps=c.prepareStatement(insert1);
			 ps.setInt(1,eid);
			 ps.setString(2,ename);
			 ps.setInt(3,eexp);
			 ps.setInt(4, esalary);
			 //injecting and updating into database
			 ps.executeUpdate();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing the connections
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void update(int id,String name,String course)
	{
		try {
			//loading and registering the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			 c=DriverManager.getConnection(url,user,password);
			 //creating statement object
			 ps=c.prepareStatement(update1);
			 ps.setString(1, name);
			 ps.setString(2, course);
			 ps.setInt(3, id);
			 //injecting and updating into database
			 ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing the connections
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void delete(int id)
	{
		try {
			//loading and registering the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			 c=DriverManager.getConnection(url,user,password);
			 //creating statement object
			 ps=c.prepareStatement(delete1);
			 ps.setInt(1, id);
			 ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing the connections
				ps.close();
				
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static ArrayList<Employee> selectAll()
	{
		ArrayList<Employee> al=new ArrayList<Employee>();
		try {
			//loading and registering the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			 c=DriverManager.getConnection(url,user,password);
			 //creating statement object
			 s=c.createStatement();
			 rs=s.executeQuery(select);
			 while(rs.next())
			 {
				 int eid=rs.getInt("eid");
				 String ename=rs.getString("ename");
				 int eexp=rs.getInt("eexp");
				 int esalary=rs.getInt("esalary");
				 Employee e=new Employee(eid,ename,eexp,esalary); 
						 al.add(e);
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing the connections
				rs.close();
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;

	}
}

