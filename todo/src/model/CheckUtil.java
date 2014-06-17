package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CheckUtil{
	private ArrayList<String>_errs=null;

	public CheckUtil(){
		this._errs = new ArrayList<String>();
	}

	public void requiredCheck(String value,String name){
		if(value == null || value.trim().isEmpty()){
		 this._errs.add(name + "は必須入力です。");
		}
	}

	public void lengthCheck(String value,int max,String name){
		if(value != null && value.trim().isEmpty()){
			if(value.length() > max){
				this._errs.add(name + "は" + max + "文字以下で入力してください。");
			}
		}
	}

	public void numberTypeCheck(String value,String name){
		if(value != null && !value.trim().isEmpty()){
			try{
				Integer.parseInt(value);
			}catch(NumberFormatException e){
				this._errs.add(name + "は数値で入力してください。");
			}
		}
	}

	public void rangeCheck(String value,int max, int min, String name){
		if(value != null && !value.trim().isEmpty()){
			int val = 0;
			try{
				val = Integer.parseInt(value);
			}catch(NumberFormatException e){
				this._errs.add(name + "数値で入力してください。");
			}
			if(val < min || val > max){
				this._errs.add(name + "は" + min + "以上、かつ" +
				max + "以下で入力してください。");
			}
		}
	}

	public void dateTypeCheck(String value,String name){
		if(value != null && !value.equals("")){
			if(value.matches("^[0-9]{4}-{0-9}{1,2}-{0-9}{1,2}$")){
				StringTokenizer token = new StringTokenizer(value,"-");
				int year = Integer.parseInt((String)token.nextToken());
				int month = Integer.parseInt((String)token.nextToken());
				int day = Integer.parseInt((String)token.nextToken());
				Calendar cal = Calendar.getInstance();
				cal.set(year,month -1,day);

				if(cal.get(Calendar.YEAR)!= year ||
				   cal.get(Calendar.MONTH)!= month-1 ||
				   cal.get(Calendar.DATE)!= day){
				   this._errs.add(name + "は正しい日付で入力してください。");
				}else{
					this._errs.add(_errs + "は日付形式で入力してください。");
				}
			}
		}
	}

		public void duplicateCheck(String value,String sql,String name){
			java.sql.Connection db = null;
			java.sql.PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbtest");
				db = ds.getConnection();
				ps = db.prepareStatement(sql);
				ps.setString(1,value);
				rs = ps.executeQuery();
				if(rs.next()){this._errs.add(name + "が重複しています。");}
				}catch(NamingException e){
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
				try{
					if(rs!=null){rs.close();}
					if(ps!=null){ps.close();}
					if(db!=null){db.close();}
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}

		public boolean hasErrors(){
			return !this._errs.isEmpty();
		}

		public String getErrorList(){
			StringBuffer buf = new StringBuffer();
			buf.append("<ul style='color:Red;'>");
			for(String err: this._errs){
				buf.append("<li>" + err + "/<li>");
			}
			buf.append("</ul>");
			return buf.toString();
		}
	}
