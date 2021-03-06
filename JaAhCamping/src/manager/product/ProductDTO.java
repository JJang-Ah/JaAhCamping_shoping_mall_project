package manager.product;

import java.sql.Timestamp;

// ProductDTO - 데이터를 객체로 저장하여 이동하는 클래스
// 12개의 프로퍼티 - DB product 테이블과 매핑
// 상품 아이디, 상품 종류, 상품 이름, 상품 가격, 상품 수량, 저자
// 출판사, 출판일, 상품 이미지 이름, 상품 내용, 할인율, 등록 일시
public class ProductDTO {
	private int product_id;
	private String product_kind;
	private String product_name;
	private int product_price;
	private int product_count;
	private String brand;
	private String product_size;
	private String product_weight;
	private String product_image;
	private String product_content;
	private int discount_rate;
	private Timestamp reg_date;
	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_kind() {
		return product_kind;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public int getProduct_count() {
		return product_count;
	}
	public String getBrand() {
		return brand;
	}
	public String getProduct_size() {
		return product_size;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public String getProduct_image() {
		return product_image;
	}
	public String getProduct_content() {
		return product_content;
	}
	public int getDiscount_rate() {
		return discount_rate;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_kind=" + product_kind + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_count=" + product_count + ", brand="
				+ brand + ", product_size=" + product_size + ", product_weight=" + product_weight + ", product_image="
				+ product_image + ", product_content=" + product_content + ", discount_rate=" + discount_rate
				+ ", reg_date=" + reg_date + "]";
	}

	
}