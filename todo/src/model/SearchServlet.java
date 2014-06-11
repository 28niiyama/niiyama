package model;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDAO dao = new TodoDAO();
		try{
			dao.getConnection();
			List<TodoValueObject> list = dao.todoList();
			request.setAttribute("todoList",list);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request,response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response,Connection connection) throws ServletException, IOException {
		doGet(request,response);
	}

}
