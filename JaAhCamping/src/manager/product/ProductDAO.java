package manager.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class ProductDAO {
	// Singleton Parttern
	private ProductDAO() { }
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//DB 연결, 질의를 위한 객체 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 상품 등록 메소드
	public void insertProduct(ProductDTO product) {
		String sql = "insert into product(product_kind, product_name, product_price, product_count"
				+ ", brand, product_size, product_weight, product_image, product_content, discount_rate) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProduct_kind());
			pstmt.setString(2,  product.getProduct_name());
			pstmt.setInt(3, product.getProduct_price());
			pstmt.setInt(4, product.getProduct_count());
			pstmt.setString(5, product.getBrand());
			pstmt.setString(6, product.getProduct_size());
			pstmt.setString(7, product.getProduct_weight());
			pstmt.setString(8, product.getProduct_image());
			pstmt.setString(9, product.getProduct_content());
			pstmt.setInt(10, product.getDiscount_rate());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("insertProduct 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	// 전체 상품 수 조회 메소드 - 검색하지 않았을 때
	public int getProductCount() {
		String sql = "select count(*) from product";
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);	
		} catch(Exception e) {
			System.out.println("getProductCount 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}
	// 상품 분류별 전체 상품 수 조회 메소드 - shopMain.jsp
	public int getProductCount(String product_kind) {
		String sql = "select count(*) from product where product_kind = ?";
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_kind);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);	
		} catch(Exception e) {
			System.out.println("getProductCount(product_kind) 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}

	// 전체 상품 수 조회 메소드 - 검색했을 때
	public int getProductCount(String s_search, String i_search) {
		String sql = "select count(*) from product where ";
		int cnt = 0;
		
		if(s_search.equals("이름")) {
			sql += "product_name ";
		}else if(s_search.equals("브랜드")) {
			sql += "brand ";
		}
		sql+= "like ?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + i_search + "%");
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);	
		} catch(Exception e) {
			System.out.println("getProductCount 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}

	// 전체 상품 조회 메소드 - 페이징 처리, 검색 처리는 안함.
	public List<ProductDTO> getProductList(int startRow, int pageSize) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql = "select * from product order by product_id desc limit ?, ?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new ProductDTO();
				// product_content를 제외한 11개 필드의 정보를 담아 list로 넘겨준다.
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_kind(rs.getString("product_kind"));
				product.setProduct_name(rs.getNString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_count(rs.getInt("product_count"));
				product.setBrand(rs.getString("brand"));
				product.setProduct_size(rs.getString("product_size"));
				product.setProduct_weight(rs.getString("product_weight"));
				product.setProduct_image(rs.getString("product_image"));
				product.setDiscount_rate(rs.getInt("discount_rate"));
				product.setReg_date(rs.getTimestamp("reg_date"));
				productList.add(product);
			}
		} catch(Exception e) {
			System.out.println("getProductList 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
	}
	// 전체 상품 조회 메소드 - 페이징 처리, 검색 처리는 안함.
	public List<ProductDTO> getProductList(int startRow, int pageSize, String product_kind) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql = "select * from product where product_kind = ? order by product_id desc limit ?, ?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_kind);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new ProductDTO();
				// product_content를 제외한 11개 필드의 정보를 담아 list로 넘겨준다.
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_kind(rs.getString("product_kind"));
				product.setProduct_name(rs.getNString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_count(rs.getInt("product_count"));
				product.setBrand(rs.getString("brand"));
				product.setProduct_size(rs.getString("product_size"));
				product.setProduct_weight(rs.getString("product_weight"));
				product.setProduct_image(rs.getString("product_image"));
				product.setDiscount_rate(rs.getInt("discount_rate"));
				product.setReg_date(rs.getTimestamp("reg_date"));
				productList.add(product);
			}
			
		} catch(Exception e) {
			System.out.println("getProductList 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
	}
	// 검색한 전체 상품 조회 메소드 - 페이징 처리, 검색 처리를함.
	public List<ProductDTO> getProductList(int startRow, int pageSize, String s_search, String i_search) {
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql = "select * from product where ";
		if(s_search.equals("이름")) {
			sql += "product_name ";
		}else if(s_search.equals("브랜드")) {
			sql += "brand ";
		}
		sql+= "like ? order by product_id desc limit ?, ?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + i_search + "%");
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new ProductDTO();
				// product_content를 제외한 11개 필드의 정보를 담아 list로 넘겨준다.
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_kind(rs.getString("product_kind"));
				product.setProduct_name(rs.getNString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_count(rs.getInt("product_count"));
				product.setBrand(rs.getString("brand"));
				product.setProduct_size(rs.getString("product_size"));
				product.setProduct_weight(rs.getString("product_weight"));
				product.setProduct_image(rs.getString("product_image"));
				product.setDiscount_rate(rs.getInt("discount_rate"));
				product.setReg_date(rs.getTimestamp("reg_date"));
				productList.add(product);
			}
			
		} catch(Exception e) {
			System.out.println("getProductList 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	// 상품 상세보기(1건) 메소드
	public ProductDTO getProduct(int product_id) {
		ProductDTO product = new ProductDTO();
		String sql = "select * from product where product_id = ?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();
			rs.next();
		
			// product상품에 대한 12가지의 필드의 정보를 담는다.
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_kind(rs.getString("product_kind"));
			product.setProduct_name(rs.getNString("product_name"));
			product.setProduct_price(rs.getInt("product_price"));
			product.setProduct_count(rs.getInt("product_count"));
			product.setBrand(rs.getString("brand"));
			product.setProduct_size(rs.getString("product_size"));
			product.setProduct_weight(rs.getString("product_weight"));
			product.setProduct_image(rs.getString("product_image"));
			product.setProduct_content(rs.getString("product_content"));
			product.setDiscount_rate(rs.getInt("discount_rate"));
			product.setReg_date(rs.getTimestamp("reg_date"));
			
		} catch(Exception e) {
			System.out.println("getProduct 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return product;
	}
	
	// 상품 수정 메소드
	public void updateProduct(ProductDTO product) {
		String sql = "update product set product_kind=?, product_name=?, product_price=?, product_count=?, brand=?, "
				+ "product_size=?, product_weight=?, product_image=?, product_content=?, discount_rate=? "
				+ "where product_id=?";
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProduct_kind());
			pstmt.setString(2, product.getProduct_name());
			pstmt.setInt(3, product.getProduct_price());
			pstmt.setInt(4, product.getProduct_count());
			pstmt.setString(5, product.getBrand());
			pstmt.setString(6, product.getProduct_size());
			pstmt.setString(7, product.getProduct_weight());
			pstmt.setString(8, product.getProduct_image());
			pstmt.setString(9, product.getProduct_content());
			pstmt.setInt(10, product.getDiscount_rate());
			pstmt.setInt(11, product.getProduct_id());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateProduct 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 상품 정보 삭제 메소드
	public void deleteProduct(int product_id) {
		String sql = "delete from product where product_id=?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("deleteProduct 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//#################################
	// mall에서 사용하는 메소드
	
	// 1. chk가 1일때 - shop에서 100번대, 200번대 신상품 3개씩을 리스트에 담아서 리턴하는 메소드
	// "110", "120", "210", "220", "230", "240", "250"
	// 신상품의 기준: 출판일(publishing_date)
	
	// 2. chk가 2일때 - 모든 상품 종류별로 신상품 1개씩을 리스트에 담아서 리턴하는 메소드
	public List<ProductDTO> getProductList(String[] nProducts, int chk) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql1 = "select * from product where product_kind = ? order by reg_date desc limit 3";
		String sql2 = "select * from product where product_kind = ? order by reg_date desc limit 1";
		try {
			conn = JDBCUtil.getConnection();
			for(String s : nProducts) {
				if(chk == 1) pstmt = conn.prepareStatement(sql1);
				else if(chk == 2) pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, s);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					product = new ProductDTO();
					product.setProduct_id(rs.getInt("product_id"));
					product.setProduct_image(rs.getString("product_image"));
					productList.add(product);
				}
			}
		} catch(Exception e) {
			System.out.println("getProductList 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	// 각 분류마다에서 가장 최신 상품들을 리스트에 담아서 리턴
	public List<ProductDTO> getGoodProductList() {
		List<ProductDTO> goodProductList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql = "select * from product where product_id in (select max(product_id)" + 
				"from product group by product_kind)" + 
				"order by product_kind";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductDTO();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_image(rs.getString("product_image"));
				product.setProduct_kind(rs.getString("product_kind"));
				
				goodProductList.add(product);
			}
		} catch(Exception e) {
			System.out.println("getNewProducts 메소드: " + e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return goodProductList;
	}
	
	// 상품 분류별 보기 메소드 - shopMain.jsp
	public List<ProductDTO> getProductList(String product_kind) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO product = null;
		String sql = "select * from product where product_kind = ?";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductDTO();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_kind(rs.getString("product_kind"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setBrand(rs.getString("brand"));
//				product.setProduct_size(rs.getString("product_size"));
//				product.setProduct_weight(rs.getString("product_weight"));
				product.setProduct_image(rs.getString("product_image"));
				product.setDiscount_rate(rs.getInt("discount_rate"));
				productList.add(product);
			}
			
		} catch (Exception e) {
			System.out.println("getProductList(product_kind) 메소드: "+ e.getMessage());
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return productList;
		
	}
}
