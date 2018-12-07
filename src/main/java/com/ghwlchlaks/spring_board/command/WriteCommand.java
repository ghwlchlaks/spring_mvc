package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;

//글작성하는 Command
public class WriteCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContents = request.getParameter("bContents");
		
		Dao dao = new Dao();
		dao.write(bName, bTitle, bContents);
	}

}
