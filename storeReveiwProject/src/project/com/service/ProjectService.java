package project.com.service;

import java.util.ArrayList;

import project.com.model.MemberDAO;
import project.com.model.MemberDAOimpl;
import project.com.model.MemberVO;
import project.com.model.PlaceDAO;
import project.com.model.PlaceDAOimpl;
import project.com.model.PlaceVO;
import project.com.model.ReviewDAO;
import project.com.model.ReviewDAOimpl;
import project.com.model.ReviewVO;
import project.com.model.ScoreDAO;
import project.com.model.ScoreDAOimpl;
import project.com.model.ScoreVO;

public class ProjectService {
		private MemberDAO mdao;   
		private ScoreDAO sdao;
		private PlaceDAO pdao;
		private ReviewDAO rdao;
			public ProjectService() {
				System.out.println("ProjectService");
				mdao = new MemberDAOimpl();
				sdao = new ScoreDAOimpl();
				pdao = new PlaceDAOimpl();
				rdao = new ReviewDAOimpl();
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

			public PlaceVO selectPlaceOne(PlaceVO vo) {
				// TODO Auto-generated method stub
				return pdao.selectPlaceOne(vo);
			} 

		public ArrayList<ScoreVO> searchAll(String searchWord) {
			
			return pdao.searchAll(searchWord);
		}
		public ScoreVO selectScoreOne(ScoreVO svo) {
			// TODO Auto-generated method stub
			return sdao.selectScoreOne(svo);
		}
		public ArrayList<ReviewVO> selectReviewList(ReviewVO rvo) {
			// TODO Auto-generated method stub
			return rdao.selectReviewList(rvo);
		} 

}
