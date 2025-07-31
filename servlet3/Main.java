package servlet3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model2.Mutter;
import model2.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList =
				(List<Mutter>)application.getAttribute("mutterList");
		
		
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		
		
		//セッションスコープからユーザー情報を取得
		HttpSession session= request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			response.sendRedirect("index.jsp");
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
			
			
		}
		
	}

}
