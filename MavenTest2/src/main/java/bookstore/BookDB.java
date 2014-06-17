//データベースアクセスを担当
package bookstore;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDB extends CommonMySQLDAO{
	
	//t_bookテーブルの全データを取得し、Listのインスタンスとして返す処理
	public List<TBook> getListbook()throws Exception{
		//sqlにデータを格納
		String sql = "SELECT * FROM t_book";
		
		//ステートメント（SQLを格納・実行するコンテナ）を取得
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//検索
		ResultSet rs = statement.executeQuery();
		
		//
		List<TBook> returnList = new ArrayList<TBook>();
		while(rs.next()){
		
			//検索結果１レコードの内容を取得する
			TBook vo = new TBook();
			vo.setTitle(rs.getString("title"));
			vo.setAuthor(rs.getString("author"));
			vo.setPrice(rs.getString("price"));
			
			//検索結果をListに格納
			returnList.add(vo);
		}
		return returnList;
	}

	/*public static TBook findBookByISBN(String inISBN){
		//ISBN番号からTBookの永続化インスタンスを取得する処理
		Session session = dao.getConnection();
		if(session == null || session.isOpen() == false){
			session = getConnection();
	}
	
	//findqueryは、ISBNで検索するクエリ
	Query findquery = session.createQuery("from TBook book where t_book.isbn like:ISBN");
	findquery.setString("ISBN",inISBN);
		
	TBook returnValue = (TBook)findquery.uniqueResult();
	
	return(returnValue);
	}*/
}
