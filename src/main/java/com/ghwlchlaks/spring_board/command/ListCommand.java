package com.ghwlchlaks.spring_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;
import com.ghwlchlaks.spring_board.dto.Dto;

//리스트 전체를 보여주는 Command
// jsp page에 dto객체를 전달해야함
public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Dao dao = new Dao(); //DB접근 객체 생성
		ArrayList<Dto> dtos=  dao.list(); //DB접근 객체에서 list들을 가져오는 메소드 실행
		model.addAttribute("list", dtos); //가져온 데이터를 model에 추가 (view(.jsp)에서 속성 접근할때 list로 접근하면 됨) 
	}

}
