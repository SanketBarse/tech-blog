package servlets;

import java.io.IOException;


import org.json.JSONObject;

import dao.UserDao;
import entity.User;
import helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@MultipartConfig
public class LoginServlet extends HttpServlet{
	
	private User user;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String user_email = req.getParameter("user_email");
		String user_password = req.getParameter("user_password");
		String check  = req.getParameter("check");
		JSONObject jsonResponse = new JSONObject();
		
		if(check==null) {
			System.out.println("please check the checkbox");
			jsonResponse.put("success", false);
		}else {			
			UserDao userdao = new UserDao(ConnectionProvider.getConnection());
			user = userdao.getUserByEmailandPassword(user_email,user_password);
			if(user == null) {
				jsonResponse.put("success", false);
				jsonResponse.put("msg", "incorrect email or password");
			}else {
				jsonResponse.put("success", true);
				HttpSession s = req.getSession();
				s.setAttribute("currentUser" , user);			
			}
			
			
		}
		resp.getWriter().print(jsonResponse.toString());
		resp.getWriter().flush();

	}
	
	
}
