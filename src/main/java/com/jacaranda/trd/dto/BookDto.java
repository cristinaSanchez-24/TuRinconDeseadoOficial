package com.jacaranda.trd.dto;

public class BookDto {
	
	private Integer id;
	private String name;
	private String description;
	private String link;
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDto(Integer id, String name, String description, String link) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.link = link;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	

}
