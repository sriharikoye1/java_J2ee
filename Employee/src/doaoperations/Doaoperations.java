package doaoperations;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import connections.Employee;
import connections.Myconnections;

public class Doaoperations
{
	Connection connection;
	Statement statement;
	PreparedStatement pst;
	ResultSet rst;


public Doaoperations()
{
	
	connection=Myconnections.getInstance().connection;
}
public int Insert(Employee emp)
{
	int result=0;
	String query="insert into Employee values(?,?,?,?,?,?,?)";
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1,emp.getEmpid());
		pst.setString(2,emp.getEmpname());
		pst.setDouble(3,emp.getEmpsal());
		pst.setString(4,emp.getEmploc());
		pst.setDouble(5,emp.getEmpexp());
		pst.setDouble(6,emp.getEmploan());
		pst.setDouble(7,emp.getEmpemi());
		result=pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
}
public int Delete(Employee emp)
{
	int result=0;
	String query="delete from Employee where empid=?";
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1,emp.getEmpid());
		result=pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
public int Update(Employee emp)
{
	int result=0;
	String query="update Employee set empname=?,empsal=?,emploc=?,empexp=? where empid=?";
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1,emp.getEmpname());
		pst.setDouble(2,emp.getEmpsal());
		pst.setString(3,emp.getEmploc());
		pst.setDouble(4,emp.getEmpexp());
		pst.setString(5,emp.getEmpid());
		result=pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
}
public ArrayList<Employee> Search(String tempid)
{
	ArrayList<Employee> employeeList=new ArrayList<Employee>();

	String query1="select empid,empname,empsal,emploc,empexp,emploan,empemi from Employee where empid=?";
	
	
		try {
			pst=connection.prepareStatement(query1);
			pst.setString(1,tempid);
			
			rst=pst.executeQuery();
			
			Employee empBean=null;
			while(rst.next())
			{
				empBean=new Employee();
				empBean.setEmpid(rst.getString(1));
				empBean.setEmpname(rst.getString(2));
				empBean.setEmpsal(rst.getDouble(3));
				empBean.setEmpexp(rst.getDouble(5));
				empBean.setEmploc(rst.getString(4));
				empBean.setEmploan(rst.getDouble(6));
				empBean.setEmpemi(rst.getDouble(7));
				
				employeeList.add(empBean);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	
}
public ArrayList<Employee> searchsal(String salary)
{
	ArrayList<Employee> employeeList=new ArrayList<Employee>();
	String query="select empid,empname,empsal,emploc,empexp,emploan,empemi from Employee where empsal=?";
	
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1, salary);
		
		rst=pst.executeQuery();
		
		Employee empBean=null;
		while(rst.next())
		{
		
			empBean=new Employee();
			empBean.setEmpid(rst.getString(1));
			empBean.setEmpname(rst.getString(2));
			empBean.setEmpsal(rst.getDouble(3));
			empBean.setEmpexp(rst.getDouble(5));
			empBean.setEmploc(rst.getString(4));
			empBean.setEmploan(rst.getDouble(6));
			empBean.setEmpemi(rst.getDouble(7));
			
			employeeList.add(empBean);
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return employeeList;
	
}
public ArrayList<Employee> searchname(String name)
{
	ArrayList<Employee> employeeList=new ArrayList<Employee>();
	
	String query="select empid,empname,empsal,emploc,empexp,emploan,empemi from Employee where empname=?";
	
	try {
		pst=connection.prepareStatement(query);
		pst.setString(1, name);
		
		rst=pst.executeQuery();
		
		Employee empBean=null;
		while(rst.next())
		{
			empBean=new Employee();
			empBean.setEmpid(rst.getString(1));
			empBean.setEmpname(rst.getString(2));
			empBean.setEmpsal(rst.getDouble(3));
			empBean.setEmpexp(rst.getDouble(5));
			empBean.setEmploc(rst.getString(4));
			empBean.setEmploan(rst.getDouble(6));
			empBean.setEmpemi(rst.getDouble(7));
			
			employeeList.add(empBean);
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return employeeList;
	
}
public ArrayList<Employee> loan(String tempid)
{
	
	
	ArrayList<Employee> al=new ArrayList<Employee>();
	Employee empBean=null;		
	
	String query="select * from Employee where empid=?";
	try 
	{
		pst=connection.prepareStatement(query);
		pst.setString(1, tempid);
		rst=pst.executeQuery();

		while(rst.next())
		{
			empBean=new Employee();
			empBean.setEmpid(rst.getString(1));
			empBean.setEmpid(rst.getString(1));
			empBean.setEmpname(rst.getString(2));
			empBean.setEmpsal(rst.getDouble(3));
			empBean.setEmpexp(rst.getDouble(5));
			empBean.setEmploc(rst.getString(4));
			empBean.setEmploan(rst.getDouble(6));
			empBean.setEmpemi(rst.getDouble(7));
			
			al.add(empBean);
		}
	}
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Iterator<Employee> it=al.iterator();
	Employee ee=null;
	
	
	while(it.hasNext())
	{
		
	ee=(Employee)it.next();
	if(empBean.getEmpsal()<=2 && empBean.getEmpsal()<=2)
	{
		double insal=empBean.getEmpsal()/2;
		ee.setEmploan(insal);
		double emi=((empBean.getEmploan()*0.14+empBean.getEmploan())/9);
		ee.setEmpemi(emi);
	}
	else if(empBean.getEmpexp()<=2 && empBean.getEmpexp()<5)
	{
		
		double insal=(3*ee.getEmpsal()/4);
		ee.setEmploan(insal);
		double emi=((empBean.getEmploan()*0.14+empBean.getEmploan())/9);
		ee.setEmpemi(emi);
	}
	try 
	{
		String query1="update Employee set emploan=?,empemi=? where empid=?";
		pst=connection.prepareStatement(query1);
		pst.setDouble(1, ee.getEmploan());
		pst.setDouble(2, ee.getEmpemi());
		pst.setString(3, tempid);
		int x=pst.executeUpdate();
		
	}
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
}
	return al;
	

}
}