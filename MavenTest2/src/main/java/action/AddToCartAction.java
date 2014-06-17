package action;

import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookstore.BookDB;
import bookstore.TBook;

//カートに商品を追加して、選択状態でbookstore.jspに遷移する
//カートに入っている分の計算を行い、checkoutjspの画面に遷移する
@Results({
	@Result(name="addtocart", location="bookstore.jsp"),
	@Result(name="checkout", location="checkout.jsp")	
})

public class AddToCartAction implements ServletRequestAware{
	
	private List<TBook> lblist;
	private HttpServletRequest request;
	
	//String[]selecteditemsと、それへのアクセッサメソッド利用している
	private String[] selecteditems = null;
	
	BookDB bd = new BookDB();
	
	//セッションを取得しその中で”CART”という名称で登録されているセッションの値を取得しています
	//これがショッピングカートのオブジェクトで、中身はList<String>でISBN番号が格納されている
	@Action("/AddToCart")
	public String addToCart(){
		HttpSession session = request.getSession();
		
		//CARTに入っている商品IDを初期化している
		session.removeAttribute("CART");
		
		//アイテムの情報が存在しなかったり、選択されていない場合の検出
		if(selecteditems != null && selecteditems.length != 0){
			
			//リスト型でcartに入れているString[]型をList<String>型に変換しセッションへ値を保持している
			List<String> cart = Arrays.asList(selecteditems);
			session.setAttribute("CART",cart);
		}
		
		lblist = bd.getListbook();
		return("addtocart");
	}
	
	public String checkout(){
		HttpSession httpsession = request.getSession(false);
		List<String> cart = (List<String>)httpsession.getAttribute("CART");
		
		Session session = BookDB.getListbook();
		
		Query priceQuery = session
				.createQuery("select t_book.price from t_book book where t_book.isbn in(:SELECTED_ITEMS");
		priceQuery.setParameterList("SELECTED_ITEMS)");
		priceQuery.setParameterList("SELECTED_ITEMS",cart.toArray());
		
		Long total = (Long)priceQuery.uniqueResult();
		
		request.setAttribute("TOTAL", total);
			return("checkout");
	}
	
	public List<BookDB> getLblist(){
		return lblist;
	}
	
	public void setLblist(List<BookDB>lblist){
		this.lblist = lblist;
	}
	
	public String[] getSelecteditems(){
		return selecteditems;
	}
	
	public void setSelecteditems(String[] selecteditems){
		this.selecteditems = selecteditems;
	}
	
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}

}
