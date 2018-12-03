package com.ghwlchlaks.spring_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;
import com.ghwlchlaks.spring_board.dto.Dto;

//����Ʈ ��ü�� �����ִ� Command
// jsp page�� dto��ü�� �����ؾ���
public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Dao dao = new Dao(); //DB���� ��ü ����
		ArrayList<Dto> dtos=  dao.list(); //DB���� ��ü���� list���� �������� �޼ҵ� ����
		
		model.addAttribute("list", dtos); //������ �����͸� model�� �߰� (view(.jsp)���� �Ӽ� �����Ҷ� list�� �����ϸ� ��) 
	}

}
