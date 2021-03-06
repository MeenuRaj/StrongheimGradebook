

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;

/**
 * Servlet implementation class addstudent
 */
@WebServlet("/addstudent")
public class addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*		ResultSet result = null;
		String sql = "";*/

		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Student student = new model.Student();
		trans.begin();
		try {
			
			int s_id = Integer.parseInt(request.getParameter("studentID"));
			student.setId(s_id);
			String class_name = request.getParameter("class");
			student.setClassName(class_name);
			String assgn = request.getParameter("assignment");
			student.setAssignment(assgn);
			String type = request.getParameter("type");
			student.setAType(type);
			String date = request.getParameter("date");
			student.setDates(date);
			String grade = request.getParameter("grade");
			student.setDates(grade);
			em.persist(student);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		} 

	/*	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    //URL of Oracle database server
	    String url = "jdbc:oracle:thin:testuser/password@localhost"; */

	    
	  /*  //properties for creating connection to Oracle database
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
*/
	  
		
		
		
	//	sql = "INSERT INTO students (id, class_name, assignment, a_type, dates, grade)"+		"VALUES("+s_id+",'"+class_name+"','"+assgn+"','"+type+"','"+date+"',"+grade+")";
	
		    //creating PreparedStatement object to execute query
		
		 /*   PreparedStatement preStatement = null;
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
	*/
		
		  response.setContentType("text/html");
	      getServletContext()
	      .getRequestDispatcher("/options.jsp")
	      .forward(request,  response);
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
