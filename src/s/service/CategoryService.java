package s.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import s.dao.CategoryDao;
import s.model.Category;


@Transactional
public class CategoryService {
	
	private CategoryDao categoryDao;

	public List<Category> listAllCategories() {
		return categoryDao.listAllCategories();
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}

	public Category listOneCategoryByCid(int cid) {
		return categoryDao.listOneCategoryByCid(cid);
	}

	public void deleteCategory(int cid) {
		categoryDao.deleteCategory(cid);
	}
	
	
}
