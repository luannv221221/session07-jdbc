package program;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import entity.Category;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        do {
            System.out.println("====QUAN LY DANH MUC====");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Sửa danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thooát");
            System.out.println("Mời bạn chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Category> categories = categoryDAO.getAllCategory();
                    for (Category category : categories) {
                        System.out.println(category.toString());
                    }
                     break;
                case 2:
                    Category category = new Category();
                    System.out.println("Nhập thông tin danh mục");
                    category.inputData(scanner);
                    if(categoryDAO.addCategory(category)){
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới thất bại");
                    }
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào id cần sửa ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Category categoryEdit = categoryDAO.findById(id);
                    if(categoryEdit == null){
                        System.err.println("Rất tiêc không tìm thấy danh mục nào có id = "+id);
                    } else {
                        System.out.println("Có phải bạn muốn thay đổi thông tin của danh mục này à: ");
                        System.out.println(categoryEdit.toString());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Moi chọn laik");
            }
        } while (true);
    }
}
