package s.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import s.model.Admin;
import s.model.Category;
import s.model.Order;
import s.model.Product;
import s.service.AdminService;
import s.service.CategoryService;
import s.service.OrderService;
import s.service.ProductService;
import s.util.Page;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {

	private ProductService productService;
	private AdminService adminService;
	private CategoryService categoryService;
	private OrderService orderService;
	private Map<String, Object> session;

	private Admin admin;

	private int p;
	private String pname;
	private Page<Product> page;
	private int pid;
	private Product product;

	private List<Category> categories;
	private Category category;
	private int cid;

	
	private List<Order> orders;
	private Order order;
	private int oid;
	
	
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	
	// 登录
	public String login() throws Exception {

		if (adminService.login(admin)) {
			session.put("admin", admin);
			return "login";
		}
		return "login_input";
	}

	// 注销
	public String logout() throws Exception {
		session.remove("admin");
		return "logout";
	}

	// 按页码和名字列出所有商品
	public String listAllProductByPageAndPname() throws Exception {
		page = productService.listAllProductByPageAndPname(p, pname);
		return "listAllProductByPageAndPname";
	}

	// 列出所有分类
	public String listAllCategory() throws Exception {
		categories = categoryService.listAllCategories();
		return "listAllCategory";
	}

	// 添加分类
	public String saveCategory() throws Exception {
		categoryService.saveCategory(category);
		return "saveOrUpdateCategory";
	}

	// 显示待更新的分类信息
	public String updateCategoryInput() throws Exception {

		category = categoryService.listOneCategoryByCid(cid);

		return "updateCategoryInput";
	}

	// 更新分类信息
	public String updateCategory() throws Exception {
		categoryService.saveCategory(category);
		return "saveOrUpdateCategory";
	}

	
	// 更新分类信息
	public String deleteCategory() throws Exception {
		categoryService.deleteCategory(cid);
		return "deleteCategory";
	}
	
	
	
	//列出所有商品
	public String listAllProductByPage() throws Exception {
		page = productService.listAllProductByPage(p);
		return "listAllProductByPage";
	}
	
	
	//按cid和页码列出所有商品
	public String listAllProductByPageAndCid() throws Exception {
		page = productService.listAllProductByPageAndCid(p, cid);
		return "listAllProductByPageAndCid";
	}
	
	
	//按pid列出某个商品详细信息
	public String listOneProductByPid() throws Exception {	
		product = productService.listOneProductByPid(pid);
		return "listOneProductByPid";
	}
	
	
	
	//跳转到添加商品页面
	public String saveProductInput() throws Exception {
		categories = categoryService.listAllCategories();
		return "saveProductInput";
	}
	
	//添加商品
	public String saveProduct() throws Exception {
		
		if(upload != null){
			String path = ServletActionContext.getServletContext().getRealPath("/image");
			File file = new File(path + "//" + uploadFileName);
			FileUtils.copyFile(upload, file);
	
			product.setImage("image/" + uploadFileName);
		}
		product.setCategory(category);
		productService.saveProduct(product);
		
		return "saveProduct";
	}
	
	
	
	//跳转到更新商品页面
	public String updateProductInput() throws Exception {
		categories = categoryService.listAllCategories();
		product = productService.listOneProductByPid(pid);
		return "updateProductInput";
	}	
	
	//更新商品
	public String updateProduct() throws Exception {
		
		if(upload != null){
			System.out.println("---"+product);
			String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			System.out.println(path);
			File file = new File(path);
			file.delete();
			String path2 = ServletActionContext.getServletContext().getRealPath("/image");
			File file2 = new File(path2 + "/" + uploadFileName);
			FileUtils.copyFile(upload, file2);
	
			product.setImage("image/" + uploadFileName);
		}
		System.out.println("+++"+product);
		product.setCategory(category);
		productService.updateProduct(product);
		
		System.out.println(ServletActionContext.getServletContext().getRealPath(""));
		return "updateProduct";
	}

	//删除商品
	public String deleteProduct() throws Exception {
		
		Product product1 = productService.listOneProductByPid(pid);
		String path = ServletActionContext.getServletContext().getRealPath("/" + product1.getImage());
		File file = new File(path);
		file.delete();
		productService.deleteProduct(pid);
		return "deleteProduct";
	}
	
	
	// 列出已支付的订单
	public String listPayedOrder() throws Exception {
		orders = orderService.listPayedOrder();
		return "listPayedOrder";
	}
	
	// 列出完成交易的订单
	public String listCompletedOrder() throws Exception {
		orders = orderService.listCompletedOrder();
		return "listCompletedOrder";
	}	
	
	//发货
	public String deleverGoods() throws Exception {
		orderService.deleverGoods(oid);
		return "deleverGoods";
	}
	
	
	
	//通知收货
	public String informReceiveGoods() throws Exception {
		orderService.informReceiveGoods(oid);
		return "informReceiveGoods";
	}
	
	
	
	
	
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Page<Product> getPage() {
		return page;
	}

	public void setPage(Page<Product> page) {
		this.page = page;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	
	
}
