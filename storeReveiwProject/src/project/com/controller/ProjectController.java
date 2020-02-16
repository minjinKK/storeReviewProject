package project.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.model.MemberVO;
import project.com.model.PlaceVO;
import project.com.model.ScoreVO;
import project.com.service.ProjectService;
/**
 * Servlet implementation class ProjectController
 */
@WebServlet({"/ratePrice.do","/rateDistance.do","/rateCircul.do","/index.do","/login.do","/rateTotal.do","/main_rating.do","/rateTaste.do","/review.do"})
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService service;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        System.out.println("ProjectController");
        service = new ProjectService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doget..."+sPath);
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/login.do")) {
			String memberid = request.getParameter("memberid");
			String memberpw = request.getParameter("memberpw");
			
			MemberVO vo = new MemberVO();
			vo.setMemberid(memberid);
			vo.setMemberpw(memberpw);
			MemberVO vo2 = service.selectOne(vo);
			
			if ( vo2.getMemberid() != null) {
			
				
				
			System.out.println("login result success");
			
	
			RequestDispatcher rd = request.getRequestDispatcher("main_rating.do");
			rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}else if (sPath.equals("/main_rating.do")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("rateTotal.do");
			rd.forward(request, response);
		}else if (sPath.equals("/rateTotal.do")) {
			
			ArrayList<ScoreVO> list = service.rateTotal();
			System.out.println("list.size():"+list.size());
			
			request.setAttribute("list", list);
			
			ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
			placeList = service.selectPlaceOne(list);
			request.setAttribute("placeList", placeList);
			
			RequestDispatcher rd = request.getRequestDispatcher("main_rating.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/rateTaste.do")) {
			System.out.println("ratetaste");
			ArrayList<ScoreVO> list = service.rateTaste();
			System.out.println("list.size():"+list.size());
			request.setAttribute("list", list);
			
			ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
			placeList = service.selectPlaceOne(list);
			request.setAttribute("placeList", placeList);
			
			RequestDispatcher rd = request.getRequestDispatcher("rateTaste.jsp");
			rd.forward(request, response);
			
		}else if (sPath.equals("/ratePrice.do")) {
			System.out.println("rateprice");
			ArrayList<ScoreVO> list = service.ratePrice();
			System.out.println("list.size():"+list.size());
			
			request.setAttribute("list", list);
			
			ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
			placeList = service.selectPlaceOne(list);
			request.setAttribute("placeList", placeList);
			
			for(ScoreVO vo:list) {
				System.out.println(vo.toString());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("ratePrice.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/rateDistance.do")) {
			System.out.println("ratedistance");
			ArrayList<ScoreVO> list = service.rateDistance();
			System.out.println("list.size():"+list.size());
			
			request.setAttribute("list", list);
			ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
			placeList = service.selectPlaceOne(list);
			request.setAttribute("placeList", placeList);
			for(ScoreVO vo:list) {
				System.out.println(vo.toString());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("rateDistance.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/rateCircul.do")) {
			System.out.println("ratecircul");
			ArrayList<ScoreVO> list = service.rateCircul();
			System.out.println("list.size():"+list.size());
			
			request.setAttribute("list", list);
			ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
			placeList = service.selectPlaceOne(list);
			request.setAttribute("placeList", placeList);
			for(ScoreVO vo:list) {
				System.out.println(vo.toString());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("rateCircul.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/review.do")) {
			//System.out.println("넘어온 이름은??"+request.getParameter("p_name"));
			PlaceVO vo = new PlaceVO();
			vo.setP_name(request.getParameter("p_name"));
			PlaceVO vo2 = service.selectPlaceOne(vo);
			System.out.println(vo2);
			request.setAttribute("placeVO", vo2);
			
			RequestDispatcher rd = request.getRequestDispatcher("review.jsp");
			rd.forward(request, response);
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
