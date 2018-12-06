package com.ghwlchlaks.spring_board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ghwlchlaks.spring_board.command.Command;
import com.ghwlchlaks.spring_board.command.ContentCommand;
import com.ghwlchlaks.spring_board.command.DeleteCommand;
import com.ghwlchlaks.spring_board.command.ListCommand;
import com.ghwlchlaks.spring_board.command.ModifyCommand;
import com.ghwlchlaks.spring_board.command.ReplyCommand;
import com.ghwlchlaks.spring_board.command.ReplyViewCommand;
import com.ghwlchlaks.spring_board.command.WriteCommand;

//anotation(@)을 이용한 request mapping하는 클래스
@Controller
public class controller {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	//interface라서 해당 interface를 포함하고 있는 클래스를 모두 포함한 효과 (상위 클래스이므로)
	Command command;
	
	//리스트를 보여주는 mapping
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list()");
		command= new ListCommand();
		//ListCommand 클래스에서 execute실행
		command.execute(model);
		//list.jsp page
		return "list";
	}
	
	//작성하는 동작 (x), 작성하는 화면 넘기기
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		//write_view.jsp page
		return "write_view";
	}
	
	//작성하는 동작
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		/*HttpServletRequest는 write_view에서 작성한 내용을 받아오는 객체 (request)*/
		System.out.println("write()");
		
		model.addAttribute("request", request); //작성한 내용 객체
		command = new WriteCommand();
		command.execute(model); //DB에 추가하는 메소드 실행
		
		return "redirect:list";
	}
	
	//글 클릭했을때 content보여주기
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request); //클릭한 list정보
		command = new ContentCommand();
		command.execute(model); //request에 맞는 데이터 객체 가져오는 메소드 실행
		
		return "content_view";
	}
	
	//글 수정하는 기능
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//댓글 보기
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new ReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	//댓글 작성
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new ReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new DeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
