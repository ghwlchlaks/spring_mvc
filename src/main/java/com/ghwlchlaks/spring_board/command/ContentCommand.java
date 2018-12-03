package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

// 리스트 게시판 데이터 (클릭한 글에 내용 보여주기)
public class ContentCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap(); //가져온 데이터를 map 형식으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //넘어온 데이터 가져오기
		String Id = request.getParameter("id"); //넘어온 데이터의 id값 추출
		
		//Dao dao = new Dao(); //데이터 베이스 접근 객체 생성
		//Dto dto = dao.contentView(Id); //데이터베이스 접근 객체에 id값 전달하여 맞는 데이터 값 가져오기
		
		//model.addAllAttributes("content_view", dto); // 데이터 객체를 content_view에 전달 (response)
	}

}
