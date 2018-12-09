package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;

//수정하는 command
public class ModifyCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bContents = request.getParameter("bContents");
		String bTitle = request.getParameter("bTitle");
		
		Dao dao = new Dao();
		dao.modify(bId, bName, bTitle, bContents);
	}

}
