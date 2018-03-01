package s.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import s.model.Product;


public class ProductDao extends HibernateDaoSupport {

	//按页数和cid列出所有商品
	public List<Product> listAllProductByPage(final int begin, final int limit, final int cid){
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {
				
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Product where cid=?");
				query.setParameter(0, cid);
				query.setFirstResult(begin);
				query.setMaxResults(limit);
				return (List<Product>) query.list();
			}
			
		});
		return list;
	}
	
	
	//按cid返回所有商品的个数
	public int listAllProductByCidCount(int cid){
		List<Product> list = (List<Product>) this.getHibernateTemplate().find("from Product where cid=?",cid);
		return list.size();
	}

	//安出版日期返回最近出版的几条商品
	public List<Product> listRecentProduct() {
		
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			public List<Product> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Product order by time desc");
				query.setFirstResult(0);
				query.setMaxResults(20);
				return (List<Product>) query.list();
			}
			
		});
		return list;
	}

	
	public Product listOneProductByPid(int pid) {
		List<Product> list = (List<Product>) this.getHibernateTemplate().find("from Product where pid=?", pid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//按页数和pname列出所有商品
	public List<Product> listAllProductByPageAndPname(final int begin, final int limit,
			final String pname) {
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {
			public List<Product> doInHibernate(Session session) throws HibernateException{
				Query query = null;
				try {
					query = session.createQuery("from Product where pname like '%" + URLDecoder.decode(pname,"utf-8") + "%'");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}//通配符“%”代表长度大于等于0的字符
				//query.setParameter(0, pname);
				query.setFirstResult(begin);
				query.setMaxResults(limit);
				return (List<Product>) query.list();
			}
			
		});
		return list;
	}

	//根据名字查出所有商品的个数
	public int listAllProductByPnameCount(String pname) throws DataAccessException, UnsupportedEncodingException {
		List<Product> list = (List<Product>) this.getHibernateTemplate().find(
				"from Product where pname like '%" + URLDecoder.decode(pname, "utf-8") + "%'");
		return list.size();
	}


	//查出所有商品的个数
	public int listAllProductCount() {
		List<Product> list = (List<Product>) this.getHibernateTemplate().find("from Product");
		return list.size();
	}


	public List<Product> listAllProductByPage(final int begin, final int limit) {
		List<Product> list = (List<Product>) this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			public List<Product> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Product");
				query.setFirstResult(begin);
				query.setMaxResults(limit);
				return (List<Product>) query.list();
			}
			
		});
		return list;
	}


	public void saveProduct(Product product) {
		this.getHibernateTemplate().save(product);
	}


	public void deleteProduct(int pid) {
		Product product = this.getHibernateTemplate().get(Product.class, pid);
		this.getHibernateTemplate().delete(product);
	}


	public void updateProduct(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
