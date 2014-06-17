package model;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public abstract class CsrfFilter implements Filter{

	public void doFilter(ServletRequest req,ServletResponse res,
		FilterChain chain)throws IOException,ServletException{
		HttpServletRequest request = (HttpServletRequest)req;
		if(request.getMethod().equals("GET")){
			createToken(request);
		}else{
			if(!checkToken(request)){
				throw new ServletException("不正なアクセスが行われました。");
			}
		}
		chain.doFilter(req, res);
	}
	public void init(FilterConfig config)throws ServletException{}
	public void destryo(){}

	private void createToken(HttpServletRequest request){
		MessageDigest md = null;
		HttpSession session = request.getSession();
		try{
			md = MessageDigest.getInstance("MD5");
			md.update(session.getId().getBytes());
			session.setAttribute("token",toHex(md.digest()));
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}

	private boolean checkToken(HttpServletRequest request){
		HttpSession session = request.getSession();
		String s_token = (String)session.getAttribute("token");
		String r_token = request.getParameter("token");
		if(s_token == null || r_token == null || r_token.isEmpty()){
			return false;
		}

		return s_token.equals(r_token);
	}

	private String toHex(byte[] digest){
		StringBuffer buff = new StringBuffer();
		for(int i = 0; i < digest.length; i++){
			buff.append(Integer.toHexString((digest[i] >> 4) & 0x0F));
			buff.append(Integer.toHexString(digest[i] & 0x0F));

		}
		return buff.toString();
	}
}
