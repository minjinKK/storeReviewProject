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

<<<<<<< HEAD
	private final String SELECT_PLACE_ONE_LIST = "select * from place where p_name like ? ";
	private final String SELECT_PLACE_ONE_NAME = "select * from place where p_name like ? ";
=======
	private final String SELECT_PLACE_ONE = "select * from place where p_name like ? ";
	private final String SEARCH_ALL = "select * from score_view where p_name like '%' ||?||'%' ";

>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
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
			pstmt = conn.prepareStatement(SELECT_PLACE_ONE_LIST);
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
					vo2.setP_tel(rs.getString("p_tel"));
					vo2.setP_description(rs.getString("p_description"));
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
<<<<<<< HEAD
	@Override
	public PlaceVO selectPlaceOne(PlaceVO vo) {
		System.out.println("selectPlaceOne()...");
		PlaceVO vo2 = new PlaceVO();
=======
	
	public ArrayList<ScoreVO> searchAll(String searchWord){
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		System.out.println("searchall()...");
		
		ScoreVO vo = new ScoreVO();

>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");
<<<<<<< HEAD
			///////////////////////////////////////
			// 3.SQL 설정
			pstmt = conn.prepareStatement(SELECT_PLACE_ONE_NAME);
			pstmt.setString(1, vo.getP_name());
			// 4.결과 반환(DB 처리 결과1)
			rs = pstmt.executeQuery();// select 용
			if(!rs.next())System.out.println("fail!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			else {
				vo2.setP_address(rs.getString("p_address"));
				vo2.setP_country(rs.getString("p_country"));
				vo2.setP_img_name(rs.getString("p_img_name"));
				vo2.setP_name(rs.getString("p_name"));
				vo2.setP_num(rs.getInt("p_num"));
				vo2.setP_tel(rs.getString("p_tel"));
				vo2.setP_description(rs.getString("p_description"));
			}
			///////////////
			
=======

			// 3. SQL 설정
			pstmt = conn.prepareStatement(SEARCH_ALL);
			
			pstmt.setString(1,searchWord);
			
			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			
			System.out.println(rs);
	
			while (rs.next()) {
				
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getInt("s_total"));
				vo.setTaste(rs.getInt("s_taste"));
				vo.setPrice(rs.getInt("s_price"));;
				vo.setDistance(rs.getInt("s_distance"));
				vo.setCircul(rs.getInt("s_circul"));
				vo.setCount(rs.getInt("s_count"));;
				
				System.out.println();
				
				list.add(vo);
			}

>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
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

<<<<<<< HEAD
		return vo2;
=======
		return list;
>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
	}

}
