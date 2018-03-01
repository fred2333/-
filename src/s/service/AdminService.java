package s.service;

import org.springframework.transaction.annotation.Transactional;

import s.dao.AdminDao;
import s.model.Admin;


 
//使用Spring,在service类前加上@Transactional，声明这个service所有方法需要事务管理。
@Transactional
public class AdminService {
	
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean login(Admin admin) {
		
		return adminDao.login(admin);
	}
	
	
}
