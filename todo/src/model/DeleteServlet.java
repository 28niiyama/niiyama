package model;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		TodoDAO dao = new TodoDAO();
 		String paramId = request.getParameter("id");
 		try{
 			dao.getConnection();
 			int id = Integer.parseInt(paramId);
 			dao.delete(id);
 		}catch(Exception e){
 			throw new ServletException(e);
 		}finally{
 			dao.closeConnection();
 		}
 		 		setMessage(request,"タスク[" + paramId  + "]の削除処理が完了しました。");

 		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
 		rd.forward(request,response);
 	}

 	protected void setMessage(HttpServletRequest request,String message){
 		request.setAttribute("message",message);
 	}



}
