
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class maxmin
 */
@WebServlet("/maxmin")
public class maxmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public maxmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String type = request.getParameter("mm_type");
		String sql = "";
		String message = "";
		ResultSet result = null;
		double max = 0;
		double min = 0;
		// System.out.println(as_type);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// URL of Oracle database server
		String url = "jdbc:oracle:thin:testuser/password@localhost";

		// properties for creating connection to Oracle database
		Properties props = new Properties();
		props.setProperty("user", "testdb");
		props.setProperty("password", "password");

		// creating connection to Oracle database using JDBC
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		sql = "select * from students where  a_type ='" + type + "'";
		System.out.println(sql);
		// creating PreparedStatement object to execute query

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
			message = "<thead><tr><th>Assignment:</th><th>Type</th></tr></thead>";
			while (result.next()) {
				// message +=
				// "<tr><td>"+result.getString("ASSIGNMENT")+"</td></tr>\n";
				if (min == 0 && max == 0) {
					min = result.getDouble("GRADE");
					max = result.getDouble("GRADE");
				} else if (result.getDouble("GRADE") < min)
					min = result.getDouble("GRADE");
				else if (result.getDouble("GRADE") > max)
					max = result.getDouble("GRADE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		message = "The maximum grade for " + type + "(s) is: " + max
				+ "\n The minimum grade for " + type + "(s) is: " + min;

		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/output.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
