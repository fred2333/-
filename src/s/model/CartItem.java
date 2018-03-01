package s.model;
//手动生成


public class CartItem implements java.io.Serializable {

	
	private Product product;		//商品信息
	private int count;				//商品个数
	private double subTotal;		//条目小计
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//小计根据商品数量计算
	public double getSubTotal() {
		//#表示整数部分为空则显示为空
		return Double.valueOf(new java.text.DecimalFormat("#.0").format(product.getPrice() * count));
	}
	
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count
				+ ", subTotal=" + subTotal + "]";
	}
	
	
}
