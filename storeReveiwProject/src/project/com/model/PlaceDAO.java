package project.com.model;

import java.util.ArrayList;

public interface PlaceDAO {
	public ArrayList<PlaceVO> selectPlaceOne(String p_name);
}
