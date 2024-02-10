package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import dao.DuplicateUser;
import dao.UserDao;
import entity.User;
import helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
@MultipartConfig
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();		
		resp.setContentType("application/json");
		JSONObject jsonResponse = new JSONObject();
		
		String check = req.getParameter("check");
		if (check == null) {
			jsonResponse.put("success", false);
			jsonResponse.put("msg", "please select term and condition!");
			
		} else {
			String user_email = req.getParameter("user_email");
			String user_phone = req.getParameter("user_phone");
			String user_password = req.getParameter("user_password");
			String user_gender = req.getParameter("gender");

			DuplicateUser du = new DuplicateUser(ConnectionProvider.getConnection());
			if (du.isDuplicate(user_email, user_phone)) {
				jsonResponse.put("success", false);
				jsonResponse.put("msg", "This email and number is already in use");
			} else {
				User user = new User(user_email, user_phone, user_password, user_gender);
				UserDao userdao = new UserDao(ConnectionProvider.getConnection());
				userdao.saveUser(user);
				
				//cookies .............
				
				//cookies end ......
				jsonResponse.put("success", true);
				jsonResponse.put("msg", "you have succesfully register...!");
			}

		}
		out.print(jsonResponse.toString());
		out.flush();

	}

}
