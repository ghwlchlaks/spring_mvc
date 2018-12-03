package com.ghwlchlaks.spring_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

// ����Ʈ �Խ��� ������ (Ŭ���� �ۿ� ���� �����ֱ�)
public class ContentCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap(); //������ �����͸� map �������� ��ȯ
		HttpServletRequest request = (HttpServletRequest) map.get("request"); //�Ѿ�� ������ ��������
		String Id = request.getParameter("id"); //�Ѿ�� �������� id�� ����
		
		//Dao dao = new Dao(); //������ ���̽� ���� ��ü ����
		//Dto dto = dao.contentView(Id); //�����ͺ��̽� ���� ��ü�� id�� �����Ͽ� �´� ������ �� ��������
		
		//model.addAllAttributes("content_view", dto); // ������ ��ü�� content_view�� ���� (response)
	}

}
