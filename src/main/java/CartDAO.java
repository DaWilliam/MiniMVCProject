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

    public int saveCartDetails(Cart cart){
        return jt.update("insert into products values(" + cart.getId() + ", '" + cart.getName() + "', '" + cart.getDescription() 
		+ ", " + cart.getQuantity() + ", '" + cart.getCategory() + "')");

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