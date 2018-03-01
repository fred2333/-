package s.dao;

import java.util.List;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import s.model.Category;


public class CategoryDao extends HibernateDaoSupport {

	public List<Category> listAllCategories() {
		String hql = "from Category";
		List<Category> list = (List<Category>) this.getHibernateTemplate().find(hql);
		System.out.println("CategoryDao===" + list);
		return list;
		
	}

	
	public void saveCategory(Category category) {
		this.getHibernateTemplate().saveOrUpdate(category);
	}
	
	
	

	public Category listOneCategoryByCid(int cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}


	public void deleteCategory(int cid) {
		Category category = this.getHibernateTemplate().get(Category.class, cid);
		this.getHibernateTemplate().delete(category);
	}

	
}
