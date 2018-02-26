package com.bootmongo.starter.model;

import org.springframework.data.annotation.Id;

public class Todo {

	@Id
	private int id;
	private String userId;
	private String title;
	private String todoBody;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTodoBody() {
		return todoBody;
	}

	public void setTodoBody(String todoBody) {
		this.todoBody = todoBody;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
