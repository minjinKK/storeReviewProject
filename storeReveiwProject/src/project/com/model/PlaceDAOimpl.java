package project.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceDAOimpl implements PlaceDAO {
	private Connection conn = null;
//	private Statement stmt = null;//정적쿼리처리 객체
	private PreparedStatement pstmt = null;// 동적쿼리 처리 객체
//	private CallableStatement cstmt = null;//sql 프로시저 콜 객체
	private ResultSet rs = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "project";
	private final String PASSWORD = "hi123456";

	private final String SELECT_PLACE_ONE = "select * from place where p_name like ? ";
	public PlaceDAOimpl() {
		System.out.println("ScoreDAOimpl()...");
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
	public ArrayList<PlaceVO> selectPlaceOne(ArrayList<ScoreVO> scoreList) {
		System.out.println("selectPlaceOne()...");
		ArrayList<PlaceVO> list = new ArrayList<PlaceVO>();
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(SELECT_PLACE_ONE);
			for (ScoreVO vo : scoreList) {
				pstmt.setString(1, vo.getPname());
				rs = pstmt.executeQuery();// select
				if(rs.next()) {
					PlaceVO vo2 = new PlaceVO();
					vo2.setP_address(rs.getString("p_address"));
					vo2.setP_country(rs.getString("p_country"));
					vo2.setP_img_name(rs.getString("p_img_name"));
					vo2.setP_name(rs.getString("p_name"));
					vo2.setP_num(rs.getInt("p_num"));
					list.add(vo2);
				}
				
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

		return list;
	}

}
