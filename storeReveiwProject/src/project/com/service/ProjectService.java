package project.com.service;

import java.util.ArrayList;

import project.com.model.MemberDAO;
import project.com.model.MemberDAOimpl;
import project.com.model.MemberVO;
import project.com.model.PlaceDAO;
import project.com.model.PlaceDAOimpl;
import project.com.model.PlaceVO;
import project.com.model.ScoreDAO;
import project.com.model.ScoreDAOimpl;
import project.com.model.ScoreVO;

public class ProjectService {
		private MemberDAO mdao;   
		private ScoreDAO sdao;
		private PlaceDAO pdao;
			public ProjectService() {
				System.out.println("ProjectService");
				mdao = new MemberDAOimpl();
				sdao = new ScoreDAOimpl();
				pdao = new PlaceDAOimpl();
			} 
		public MemberVO selectOne(MemberVO vo) {
				
				return mdao.selectOne(vo);
			} 
		public ArrayList<ScoreVO> rateTotal(){
				return sdao.rateTotal();
			} 
		public ArrayList<ScoreVO> rateTaste(){
				return sdao.rateTaste();
			} 
		public ArrayList<ScoreVO> ratePrice(){
				return sdao.ratePrice();
			} 
		public ArrayList<ScoreVO> rateDistance(){
				return sdao.rateDistance();
			}
		public ArrayList<ScoreVO> rateCircul(){
				return sdao.rateCircul();
			}
		public ArrayList<PlaceVO> selectPlaceOne(ArrayList<ScoreVO> list) {
			
				return pdao.selectPlaceOne(list);
			}
<<<<<<< HEAD
			public PlaceVO selectPlaceOne(PlaceVO vo) {
				// TODO Auto-generated method stub
				return pdao.selectPlaceOne(vo);
			} 
=======
		public ArrayList<ScoreVO> searchAll(String searchWord) {
			
			return pdao.searchAll(searchWord);
		} 
>>>>>>> 1f56d79eb53dd84317c357670ccd92eb01fc1de4
}
