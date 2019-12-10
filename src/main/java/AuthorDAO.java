
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorDAO {
    private JdbcTemplate jt;

    public AuthorDAO() {
    }

    public AuthorDAO(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void setJdbc(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int saveAuthorDetails(Author a){
        return jt.update("insert into author values(" + a.getId() + ", '" + a.getName() + "', '" + a.getAddress() + "')");
    }

    public List<Author> getAuthorDetails(){
        return jt.query("select * from author", new RowMapper<Author>() {
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author a  = new Author();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setAddress(rs.getString(3));
                return a;
            }
        });
    }

}
