package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import bookstore.BookDB;
import bookstore.TBook;

//bookstoreに画面遷移
@Results({@Result(name="login",location="/bookstore.jsp")})
public class LoginAction{
	private List<TBook> lblist;
	
	@Action("/Login")
	public String loginAndGetBookList() throws Exception{
		BookDB bd = new BookDB();
		try{
			bd.getConnection();
			lblist = bd.getListbook();
			
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			bd.closeConnection();
		}
		return ("login");
	}
	public List<TBook> getLblist(){
		return lblist;
	}
	
	public void setLblist(List<TBook> lblist){
		this.lblist = lblist;
	}
	
}