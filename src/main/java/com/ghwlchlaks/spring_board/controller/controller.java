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

//anotation(@)�� �̿��� request mapping�ϴ� Ŭ����
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

	//interface�� �ش� interface�� �����ϰ� �ִ� Ŭ������ ��� ������ ȿ�� (���� Ŭ�����̹Ƿ�)
	Command command;
	
	//����Ʈ�� �����ִ� mapping
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list()");
		command= new ListCommand();
		//ListCommand Ŭ�������� execute����
		command.execute(model);
		//list.jsp page
		return "list";
	}
	
	//�ۼ��ϴ� ���� (x), �ۼ��ϴ� ȭ�� �ѱ��
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		//write_view.jsp page
		return "write_view";
	}
	
	//�ۼ��ϴ� ����
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		/*HttpServletRequest�� write_view���� �ۼ��� ������ �޾ƿ��� ��ü (request)*/
		System.out.println("write()");
		
		model.addAttribute("request", request); //�ۼ��� ���� ��ü
		command = new WriteCommand();
		command.execute(model); //DB�� �߰��ϴ� �޼ҵ� ����
		
		return "redirect:list";
	}
	
	//�� Ŭ�������� content�����ֱ�
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request); //Ŭ���� list����
		command = new ContentCommand();
		command.execute(model); //request�� �´� ������ ��ü �������� �޼ҵ� ����
		
		return "content_view";
	}
	
	//�� �����ϴ� ���
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//��� ����
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new ReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	//��� �ۼ�
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new ReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//����
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new DeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
