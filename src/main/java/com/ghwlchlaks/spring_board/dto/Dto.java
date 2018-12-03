package com.ghwlchlaks.spring_board.dto;

import java.sql.Timestamp;

//데이터를 객체로 만드는 클래스 
public class Dto {
	int Id;
	String Name;
	String Title;
	Timestamp Date;
	int Hit;
	int Group;
	int Step;
	int Indent;
	
	public Dto(int Id, String Name, String Title, Timestamp Date, int Hit, int Group, int Step, int Indent) {
		this.Id =Id;
		this.Name = Name;
		this.Title = Title;
		this.Date = Date;
		this.Hit = Hit;
		this.Group = Group;
		this.Step = Step;
		this.Indent = Indent;
	}
	
	public Dto() {
		
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Timestamp getDate() {
		return Date;
	}

	public void setDate(Timestamp date) {
		Date = date;
	}

	public int getHit() {
		return Hit;
	}

	public void setHit(int hit) {
		Hit = hit;
	}

	public int getGroup() {
		return Group;
	}

	public void setGroup(int group) {
		Group = group;
	}

	public int getStep() {
		return Step;
	}

	public void setStep(int step) {
		Step = step;
	}

	public int getIndent() {
		return Indent;
	}

	public void setIndent(int indent) {
		Indent = indent;
	}
	
	
}
