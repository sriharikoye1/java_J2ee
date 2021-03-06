package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connections.Employee;
import doaoperations.Doaoperations;

/**
 * Servlet implementation class Updateservlete
 */
@WebServlet("/Updateservlete")
public class Updateservlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		String empid=request.getParameter("id");
		String empname=request.getParameter("name");
		String empsal1=request.getParameter("sal");
		String emploc=request.getParameter("loc");
		String empexp1=request.getParameter("exp");
		Double empsal;
		Double empexp;
		try
		{
			empsal=Double.parseDouble(empsal1);
			empexp=Double.parseDouble(empexp1);
		}
		catch(Exception e)
		{
			empsal=0.0;
			empexp=0.0;
		}
		Employee emp=new Employee();
		emp.setEmpid(empid);
		emp.setEmpname(empname);
		emp.setEmpsal(empsal);
		emp.setEmploc(emploc);
		emp.setEmpexp(empexp);
		Doaoperations dao=new Doaoperations();
				int i=dao.Update(emp);
	}

}
