package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		String inputLimitdate = request.getParameter("limitdate");
		String userid = request.getParameter("userid");
		int status = Integer.parseInt(request.getParameter("status"));

		TodoValueObject vo = new TodoValueObject();
		vo.setId(id);
		vo.setTitle(title);
		vo.setTask(task);
		vo.setInputLimitdate(inputLimitdate);
		vo.setUserid(userid);
		vo.setStatus2(status);

		TodoDAO dao = new TodoDAO();
		try{
			dao.getConnection();
			if(id == 0){
				dao.registerInsert(vo);
				setMessage(request,"タスクの新規登録処理が完了しました。");

			}else{
				dao.registerUpdate(vo);
				setMessage(request,"タスク[" + id + "]の更新処理が完了しました。");
			}
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}

		String toAddr = "ToAddress@example.com";
		String fromAddr = "FromAddress@example.com";
		String personName = "USERNAME";
		String subject = "TODO管理アプリケーションからの報告です";
		String message = "test";

		SimpleMailSender mail = new SimpleMailSender();
		try{
			mail.sendMessage(toAddr, fromAddr, personName, subject, message);
		}catch(Exception e){
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/complete.jsp");
		rd.forward(request, response);
	}

	protected void setMessage(HttpServletRequest request,String message){
		request.setAttribute("message", message);
	}
}
