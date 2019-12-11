package pyramid.MiniMVCProject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {
    private JdbcTemplate jt;

    public ProductDAO() {
    }

    public ProductDAO(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void setJdbc(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int saveProductDetails(Product prod){
        return jt.update("insert into products values(" + prod.getId() + ", '" + prod.getName() + "', '" + prod.getDescription() 
        						+ ", " + prod.getQuantity() + "," + prod.getPrice() + ", '" + prod.getCategory() + "')");
    }
    
    
    public List<Product> findByCategory(String category){
    	String query = "select * from products where category = '" + category + "'";
        return jt.query(query, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product p  = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setQuantity(rs.getInt(4));
                p.setPrice(rs.getDouble(5));
                p.setCategory(rs.getString(6));
                
                return p;
            
			}
		});
    }
    
    public List<Product> findByName(String name){
    	String query = "select * from products where name = '" + name + "'";
        return jt.query(query, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product p  = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setQuantity(rs.getInt(4));
                p.setPrice(rs.getDouble(5));
                p.setCategory(rs.getString(6));
                
                return p;
            
			}
		});
    }

    
    
    public List<Product> findById(int id){
    	String query = "select * from products where id = " + id;
        return jt.query(query, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product p  = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setQuantity(rs.getInt(4));
                p.setPrice(rs.getDouble(5));
                p.setCategory(rs.getString(6));
                
                return p;
            
			}
		});
    }

    
    public List<Product> getProductDetails(){
        return jt.query("select * from products", new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product p  = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setQuantity(rs.getInt(4));
                p.setPrice(rs.getDouble(5));
                p.setCategory(rs.getString(6));
                
                return p;
            
			}
		});
    }

}