package dao;

import entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategory();
    boolean addCategory(Category category);
    Category findById(int id);
    boolean updateCategory(Category category);

}
