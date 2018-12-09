package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;

//´ñ±Û´Ù´Â Command
public class ReplyCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bContents = request.getParameter("bContents");
		String bTitle = request.getParameter("bTitle");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		String bGroup = request.getParameter("bGroup");
		
		Dao dao = new Dao();
		dao.reply(bId, bName, bContents, bTitle, bStep, bIndent, bGroup);
	}

}
