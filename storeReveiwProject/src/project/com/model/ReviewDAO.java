package project.com.model;

import java.util.ArrayList;

public interface ReviewDAO {
	public int insertReview(ReviewVO vo);

	public ArrayList<ReviewVO> selectReviewList(ReviewVO rvo);
}
