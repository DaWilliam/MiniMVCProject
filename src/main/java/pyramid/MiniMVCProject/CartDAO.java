package pyramid.MiniMVCProject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class CartDAO {
    private JdbcTemplate jt;

    public CartDAO() {
    }

    public CartDAO(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void setJdbc(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int saveCartDetails(Product product){
        return jt.update("insert into cart values(" + product.getId() + ", '" + product.getName() + "', '" + product.getDescription() 
		+ "' , " + product.getQuantity() + ", " + product.getPrice() + ", '" + product.getCategory() + "')");

    }

    public int deleteCart() {
    	return jt.update("delete from cart where id > -1");
    }

    public List<Cart> getCartDetails(){
        return jt.query("select * from cart", new RowMapper<Cart>() {

			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Cart c = new Cart();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setQuantity(rs.getInt(4));
                c.setCategory(rs.getString(5));
                
                return c;
            
			}
		});
    }

}