package project.com.model;

import java.util.ArrayList;

public interface PlaceDAO {
	public ArrayList<PlaceVO> selectPlaceOne(ArrayList<ScoreVO> scoreList);
	public ArrayList<ScoreVO> searchAll(String searchWord);
}
