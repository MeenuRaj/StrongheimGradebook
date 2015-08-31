

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

import customTools.DBUtil;
import model.Student;
import model.Weight;

/**
 * Servlet implementation class typestudent
 */
@WebServlet("/typestudent")
public class typestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String studentID = request.getParameter("st_ID");
		String type = request.getParameter("st_type");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		model.Student student = new model.Student();
		String message = "";
		String q = "select s from Student s where s.aType = '"+type+"' and s.id = "+studentID;
		TypedQuery<Student> bq = em.createQuery(q, Student.class);

		List<Student> list = bq.getResultList();
		message= "<thead><tr><th>Student ID</th><th>Assignment</th><th>Assignment Type</th><th>Date</th><th>Garde</th></tr></thead>";
		
		for (Student temp : list) {
			message += "<tr><td>"+temp.getId()+"</td><td>"+temp.getAssignment()+"</td><td>"+temp.getAType()+"</td><td>"+temp.getDates()+"</td><td>"+temp.getGrade()+"</td></tr>\n";
			
		}


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
		doGet(request, response);
	}

}
