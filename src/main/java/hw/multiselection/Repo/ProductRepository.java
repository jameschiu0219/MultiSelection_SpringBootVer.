package hw.multiselection.Repo;

import hw.multiselection.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*造訪資料庫，對資料庫進行取得資料等相關動作*/
@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> searchByKeyword(String keyword) {
        String sql = "SELECT name, price, quantity FROM product WHERE name LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        });
    }
}
