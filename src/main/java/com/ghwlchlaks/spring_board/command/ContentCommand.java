package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ghwlchlaks.spring_board.dao.Dao;
import com.ghwlchlaks.spring_board.dto.Dto;

// ����Ʈ �Խ��� ������ (Ŭ���� �ۿ� ���� �����ֱ�)
public class ContentCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap(); //������ �����͸� map �������� ��ȯ
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�Ѿ�� ������ ��������
		String bId = request.getParameter("bId"); //�Ѿ�� �������� bId�� ����
		
		Dao dao = new Dao(); //������ ���̽� ���� ��ü ����
		Dto dto = dao.contentView(bId); //�����ͺ��̽� ���� ��ü�� id�� �����Ͽ� �´� ������ �� ��������
		
		model.addAttribute("content_view", dto); // ������ ��ü�� content_view�� ���� (response)
	}

}
