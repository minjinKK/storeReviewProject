package project.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ScoreDAOimpl implements ScoreDAO {
	private Connection conn = null;
//	private Statement stmt = null;//정적쿼리처리 객체
	private PreparedStatement pstmt = null;// 동적쿼리 처리 객체
//	private CallableStatement cstmt = null;//sql 프로시저 콜 객체
	private ResultSet rs = null;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "project";
	private final String PASSWORD = "hi123456";

	private final String RATE_TOTAL = "select * from score_view order by s_total desc";
	private final String RATE_TASTE = "select * from score_view order by s_taste desc";
	private final String RATE_PRICE = "select * from score_view order by s_price desc";
	private final String RATE_DISTANCE = "select * from score_view order by s_distance desc";
	private final String RATE_CIRCUL = "select * from score_view order by s_circul desc";
	private final String SELECT_ONE = "select * from score_view where name ?";
	public ScoreDAOimpl() {
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
	public ArrayList<ScoreVO> rateTotal() {
		System.out.println("rateTotal()...");
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(RATE_TOTAL);

			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getFloat("s_total"));
				vo.setTaste(rs.getFloat("s_taste"));
				vo.setPrice(rs.getFloat("s_price"));
				vo.setDistance(rs.getFloat("s_distance"));
				vo.setCircul(rs.getFloat("s_circul"));
				vo.setCount(rs.getInt("s_count"));
				list.add(vo);
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

	@Override
	public ArrayList<ScoreVO> rateTaste() {
		System.out.println("rateTaste()...");
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(RATE_TASTE);

			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getFloat("s_total"));
				vo.setTaste(rs.getFloat("s_taste"));
				vo.setPrice(rs.getFloat("s_price"));
				vo.setDistance(rs.getFloat("s_distance"));
				vo.setCircul(rs.getFloat("s_circul"));
				vo.setCount(rs.getInt("s_count"));
				list.add(vo);
				System.out.println(list);
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
	

	@Override
	public ArrayList<ScoreVO> ratePrice() {
		System.out.println("ratePrice()...");
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(RATE_PRICE);

			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getFloat("s_total"));
				vo.setTaste(rs.getFloat("s_taste"));
				vo.setPrice(rs.getFloat("s_price"));
				vo.setDistance(rs.getFloat("s_distance"));
				vo.setCircul(rs.getFloat("s_circul"));
				vo.setCount(rs.getInt("s_count"));
				list.add(vo);
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

	@Override
	public ArrayList<ScoreVO> rateDistance() {
		System.out.println("rateDistance()...");
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(RATE_DISTANCE);

			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getFloat("s_total"));
				vo.setTaste(rs.getFloat("s_taste"));
				vo.setPrice(rs.getFloat("s_price"));
				vo.setDistance(rs.getFloat("s_distance"));
				vo.setCircul(rs.getFloat("s_circul"));
				vo.setCount(rs.getInt("s_count"));
				list.add(vo);
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

	@Override
	public ArrayList<ScoreVO> rateCircul() {
		System.out.println("rateCircul()...");
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(RATE_CIRCUL);

			// 4. DB처리 결과반환
			rs = pstmt.executeQuery();// select
			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setPname(rs.getString("p_name"));
				vo.setTotal(rs.getFloat("s_total"));
				vo.setTaste(rs.getFloat("s_taste"));
				vo.setPrice(rs.getFloat("s_price"));
				vo.setDistance(rs.getFloat("s_distance"));
				vo.setCircul(rs.getFloat("s_circul"));
				vo.setCount(rs.getInt("s_count"));
				list.add(vo);
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


	@Override
	public ScoreVO selectScoreOne(ScoreVO svo) {
		System.out.println("selectPlaceOne()...");
		ScoreVO svo2 = new ScoreVO();
		try {
			// 2. 커넥션
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn successed...");

			// 3. SQL 설정
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setString(1, svo.getPname());
			rs = pstmt.executeQuery();// select
			if(!rs.next()) System.out.println("selectplaceone____fail");
			else{
				svo2.setCircul(rs.getFloat("s_circul"));
				svo2.setCount(rs.getInt("s_count"));
				svo2.setDistance(rs.getFloat("s_distance"));
				svo2.setPname(rs.getString("p_name"));
				svo2.setPrice(rs.getFloat("s_price"));
				svo2.setTaste(rs.getFloat("s_taste"));
				svo2.setTotal(rs.getFloat("s_total"));
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

		return svo2;
	}

}
