package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String root = "WEB-INF/data/";
   		ServletContext application = this.getServletContext();
   		response.setContentType("text/html:charset=UTF-8");
   		PrintWriter out = response.getWriter();

   		boolean flag = false;
   		File fileRoot = new File(application.getRealPath("root"));
   		for(File f : fileRoot.listFiles()){
   			if(f.isFile() && f.getName().equals(request.getParameter("path"))){
   				flag = true;
   				break;
   			}
   		}

   		if(!flag){throw new ServletException("不正な要求です。");}

   		BufferedReader reader = new BufferedReader(
   			new InputStreamReader(new FileInputStream(
   					application.getRealPath(root + request.getParameter("path"))),
   					"UTF-8"));

   		while(reader.ready()){
   			out.println(reader.readLine() + "<br />");
   		}
   		reader.close();
   	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
