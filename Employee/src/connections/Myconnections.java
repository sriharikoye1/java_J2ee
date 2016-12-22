package connections;

import java.sql.DriverManager;
import java.sql.*;


public class Myconnections
{
private static Myconnections myConnection =new Myconnections();
public Connection connection;

private Myconnections()
{
	try 
	{

	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/srihari","root","root");

	}

	catch (ClassNotFoundException e) 
	{


	e.printStackTrace();
	}
	catch (SQLException e) 
	{
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

	public static Myconnections getInstance()
	{

	return myConnection;

	}




}

