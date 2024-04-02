package dao;

import entity.Category;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO{
    @Override
    public List<Category> getAllCategory() {
        // mở kết nối
        Connection connection = ConnectionDB.openConnection();
        List<Category> categories = new ArrayList<>();
        try {
            // thực hiện câu lệnh SQL thông qua PreparedStatement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCategoryStatus(resultSet.getBoolean("category_status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean addCategory(Category category) {
        Connection connection = ConnectionDB.openConnection();
        try {
            String sql = "INSERT INTO categories(category_name,category_status) VALUE (?,?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,category.getCategoryName());
            statement.setBoolean(2,category.getCategoryStatus());
            int check = statement.executeUpdate();
            if(check>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
}
