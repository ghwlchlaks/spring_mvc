package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;
import com.ghwlchlaks.spring_board.dto.Dto;

//댓글 보여주는 Command
public class ReplyViewCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =  (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		
		Dao dao = new Dao();
		Dto dto = dao.reply_view(bId);
		
		model.addAttribute("reply_view", dto);
	}

}
