package com.ghwlchlaks.spring_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.ghwlchlaks.spring_board.dto.Dto;
import com.ghwlchlaks.spring_board.util.Constant;


//데이터 베이스 접근 객체
public class Dao {
	
	JdbcTemplate template = null;
	
	public Dao() {
		
		template = Constant.template;
	}
	
	//리스트를 가져오는 메소드 실행
	public ArrayList<Dto> list() {

		String query = "select bId, bName, bTitle, bContents, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<Dto>) template.query(query, new BeanPropertyRowMapper<Dto>(Dto.class));
		
	}
	
	public void write(final String bName,final String bTitle,final String bContents) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query =  "insert into mvc_board (bId, bName, bTitle, bContents, bHit, bGroup, bStep, bIndent) values(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContents);
				return pstmt;
			}
		});
		
	}
	public Dto contentView(String strId) {
		// TODO Auto-generated method stub
		
		upHit(strId);
		String query = "select * from mvc_board where bId = "+strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<Dto>(Dto.class));

	}
	private void upHit(final String strId) {
		// TODO Auto-generated method stub
		
		String query = "update mvc_board set bHit = bHit +1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(strId));
			}
		});

	}
	public void modify(final String bId,final String bName,final String bTitle,final String bContents) {
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContents = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContents);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	
	}
	
	public void delete(final String bId) {
		
		String query = "delete from mvc_board where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
		
	}
	public Dto reply_view(String strbId) {
		// TODO Auto-generated method stub
		
		String query = "select * from mvc_board where bId = "+strbId;
		return template.queryForObject(query, new BeanPropertyRowMapper<Dto>(Dto.class));
		
	}
	private void replyShape(final String bGroup,final String bStep) {
		
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(bGroup));
				ps.setInt(2, Integer.parseInt(bStep));
			}
		});
		
	}
	
	public void reply(final String bId,final String bName,final String bContents,final String bTitle,final String bStep,final String bIndent,
			final String bGroup) {
		// TODO Auto-generated method stub
		
		replyShape(bGroup, bStep);
		
		String query = "insert into mvc_board (bId, bName, bHit, bTitle, bContents, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, 0, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContents);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) +1);
				ps.setInt(6, Integer.parseInt(bIndent) +1);
			}
		});	}
}
