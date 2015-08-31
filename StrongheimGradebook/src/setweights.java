

import java.io.IOException;
import java.math.BigDecimal;
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
 * Servlet implementation class setweights
 */
@WebServlet("/setweights")
public class setweights extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setweights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ResultSet result = null;
		String sql = "";

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Weight weight = new model.Weight();
		trans.begin();
		try {
			
			
			String quiz = request.getParameter("quiz");
			weight.setAsType("Quiz");  
			weight.setWeight(BigDecimal.valueOf(Double.parseDouble(quiz)));  
			em.merge(weight);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		} 
try {
			String project = request.getParameter("project");
						weight.setAsType("Project");  
			weight.setWeight(BigDecimal.valueOf(Double.parseDouble(project)));  
			em.merge(weight);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		} 
		
try {
	
	
	
	String test = request.getParameter("Test");
	weight.setAsType("Test");  
	weight.setWeight(BigDecimal.valueOf(Double.parseDouble(test)));  
	em.merge(weight);
	trans.commit();
	
} catch (Exception e) {
	System.out.println("ERROR:" + e);
} 

try {
	
	String homework = request.getParameter("hw");
	weight.setAsType("Homework");  
	weight.setWeight(BigDecimal.valueOf(Double.parseDouble(homework)));  
	em.merge(weight);
	trans.commit();
	
} catch (Exception e) {
	System.out.println("ERROR:" + e);
} 

		
		/*System.out.println("works till here");
		
		String homework = request.getParameter("hw");
		String quiz = request.getParameter("quiz");
		String project = request.getParameter("project");
		String test = request.getParameter("test");
		
		System.out.println(homework);
		System.out.println(quiz);
		System.out.println(project);
		System.out.println(test);

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			
			System.out.println(e3.getMessage());
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

			
			sql = "UPDATE weights SET weight= "+homework+" WHERE as_type='Homework'";
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
			
			sql = "UPDATE weights SET weight= "+quiz+" WHERE as_type='Quiz'";
			    //creating PreparedStatement object to execute query
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
				
			sql = "UPDATE weights SET weight= "+project+" WHERE as_type='Project'";
			    //creating PreparedStatement object to execute query
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
					
			sql = "UPDATE weights SET weight= "+test+" WHERE as_type='Test'";
			    //creating PreparedStatement object to execute query
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
