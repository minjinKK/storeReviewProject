package project.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDAOimpl implements ReviewDAO {
	private Connection conn = null;
//	private Statement stmt = null;//정적쿼리처리 객체
	private PreparedStatement pstmt = null;// 동적쿼리 처리 객체
//	private CallableStatement cstmt = null;//sql 프로시저 콜 객체
	private ResultSet rs = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "project";
	private final String PASSWORD = "hi123456";

	private final String INSERT_REVIEW = "insert into review (r_num,member_id,p_num,p_name,r_text,r_taste,r_price,r_distance,r_circul,r_total)"+
			"values(seq_review.nextval,?,?,?,?,?,?,?,?,?)";

	public ReviewDAOimpl() {
		System.out.println("ReviewDAOimpl()...");
		// 1.DB Driver 연결
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			System.out.println("driver failed...");
			e.printStackTrace();
		}
	}
	@Override
	public int insertReview(ReviewVO vo) {
		System.out.println("insertReview");
		int flag = 0;
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(SELECT_PLACE_ONE);
			
				
			}

		} catch (SQLException e) {
			System.out.println("conn failed...");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		return flag;
	}

}
