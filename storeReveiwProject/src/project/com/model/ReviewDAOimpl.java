package project.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	private final String SELECT_REVIEW_LIST = "SELECT * FROM REVIEW WHERE P_NAME LIKE ? order by r_wdate";
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
			pstmt = conn.prepareStatement(INSERT_REVIEW);
			pstmt.setInt();
				
			}

		 catch (SQLException e) {
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
	@Override
	public ArrayList<ReviewVO> selectReviewList(ReviewVO rvo) {
		// SELECT_REVIEW_LIST
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		System.out.println("selectReviewList");
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
			// 3. SQL 설정
			pstmt = conn.prepareStatement(SELECT_REVIEW_LIST);
			pstmt.setString(1, rvo.getPname());
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ReviewVO rvo2 = new ReviewVO();
				rvo2.setMemberid(rs.getString("user_id"));
				rvo2.setPname(rs.getString("p_name"));
				rvo2.setPnum(rs.getInt("p_num"));
				rvo2.setR_aste(rs.getInt("r_taste"));
				rvo2.setRcircul(rs.getInt("r_circul"));
				rvo2.setRdistance(rs.getInt("r_distance"));
				rvo2.setRnum(rs.getInt("r_num"));
				rvo2.setRprice(rs.getInt("r_price"));
				rvo2.setRtext(rs.getString("r_text"));
				rvo2.setRtotal(rs.getInt("r_total"));
				SimpleDateFormat wFormat = new SimpleDateFormat ( "MMMMM dd, yyyy 'AT' hh:mm a");
				Date rdate = rs.getTimestamp("r_wdate");
				String wDate=wFormat.format(rdate.getTime());
				rvo2.setrWdate(wDate);
				list.add(rvo2);
			}
			}

		 catch (SQLException e) {
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
		
		return list;
	}

}
