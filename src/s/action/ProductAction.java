package s.action;

import java.io.UnsupportedEncodingException;

import s.model.Product;
import s.service.ProductService;
import s.util.Page;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private ProductService productService;

	private int p;
	private int cid;
	private Page<Product> page;
	
	private Product product;
	private int pid;
	
	
	private String pname;
	

	//按cid和页码列出所有商品
	public String listAllProductByPageAndCid() throws Exception {
		page = productService.listAllProductByPageAndCid(p, cid);
		return "listAllProductByPageAndCid";
	}
	
	//按pid列出某个商品
	public String listOneProductByPid() throws Exception {
		product = productService.listOneProductByPid(pid);
		return "listOneProductByPid";
	}
	
	
	//按页码和名字列出所有商品
	public String listAllProductByPageAndPname() throws Exception {
		page = productService.listAllProductByPageAndPname(p, pname);
		return "listAllProductByPageAndPname";
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Page<Product> getPage() {
		return page;
	}

	public void setPage(Page<Product> page) {
		this.page = page;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) throws UnsupportedEncodingException {
		this.pname = pname;
	}
}
