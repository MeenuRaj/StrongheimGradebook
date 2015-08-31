

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import customTools.DBUtil;

/**
 * Servlet implementation class bytype
 */
@WebServlet("/bytype")
public class bytype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String as_type = request.getParameter("a_type");
	/*	String sql = "";*/
		String message = "";
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Student bull = new model.Student();
		model.Weight weight = new model.Weight();
		String q = "select s from Student s where s.aType = '"+as_type+"'";
		TypedQuery<Student> bq = em.createQuery(q, Student.class);
		message= "<thead><tr><th>Student ID</th><th>Class</th><th>Assignment</th><th>Assignment Type</th><th>Date</th><th>Garde</th></tr></thead>";
		List<Student> list = bq.getResultList();

		for (Student temp : list) {
			message += "<tr><td>"+temp.getId()+"</td><td>"+temp.getClassName()+"</td><td>"+temp.getAssignment()+"</td><td>"+temp.getAType()+"</td><td>"+temp.getDates()+"</td><td>"+temp.getGrade()+"</td></tr>\n";
		}
		
		/*ResultSet result = null;
		//System.out.println(as_type);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    //URL of Oracle database server
	    String url = "jdbc:oracle:thin:testuser/password@localhost"; 

	    
	    //properties for creating connection to Oracle database
	    Properties props = new Properties();
	    props.setProperty("user", "testdb");
	    props.setProperty("password", "password");
	  
	    //creating connection to Oracle database using JDBC
	    Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,props);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	  
		
		System.out.println(as_type);
		
			sql ="select * from students where  a_type ='"+as_type+"'";
			System.out.println(sql);
		    //creating PreparedStatement object to execute query
		
		    PreparedStatement preStatement = null;
			try {
				preStatement = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				result = preStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
			try {
				message= "<thead><tr><th>Student ID</th><th>Class</th><th>Assignment</th><th>Assignment Type</th><th>Date</th><th>Garde</th></tr></thead>";
				while(result.next()){
					message += "<tr><td>"+result.getString("ID")+"</td><td>"+result.getString("CLASS_NAME")+"</td><td>"+result.getString("ASSIGNMENT")+"</td><td>"+result.getString("A_TYPE")+"</td><td>"+result.getString("DATES")+"</td><td>"+result.getString("GRADE")+"</td></tr>\n";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

	    System.out.println(message);
	      request.setAttribute("message", message);
	      getServletContext()
	      .getRequestDispatcher("/output.jsp")
	      .forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);}
	

}
