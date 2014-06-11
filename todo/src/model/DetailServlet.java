package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		TodoDAO dao = new TodoDAO();
   		String paramId = request.getParameter("id");
   		TodoValueObject vo;
   		try{
   			dao.getConnection();
   			int id = Integer.parseInt(paramId);
   			vo = dao.detail(id);
   		}catch(Exception e){
   			throw new ServletException(e);
   		}finally{
   			dao.closeConnection();
   		}

   		request.setAttribute("vo", vo);

   		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
   		rd.forward(request, response);
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
