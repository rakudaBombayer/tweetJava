package servlet3;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.LoginLogic;
import model2.User;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user = new User(name, pass);
		
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
	
	
	//ログイン処理の成功時
	
	if(isLogin) {
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user);
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
	dispatcher.forward(request, response);
	
 }	
}