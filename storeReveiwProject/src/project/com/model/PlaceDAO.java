package project.com.model;

import java.util.ArrayList;

public interface PlaceDAO {
	public ArrayList<PlaceVO> selectPlaceOne(ArrayList<ScoreVO> scoreList);
<<<<<<< HEAD
	public PlaceVO selectPlaceOne(PlaceVO vo);
=======
	public ArrayList<ScoreVO> searchAll(String searchWord);
>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
}
