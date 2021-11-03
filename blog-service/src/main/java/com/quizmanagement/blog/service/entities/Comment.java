package com.quizmanagement.blog.service.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComment;
	private int idBlog;

	private String auther;
	
	private String msg;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String note;

	public Comment(int idComment, int idBlog, String auther, String msg, Date date, String note) {
		this.idComment = idComment;
		this.idBlog = idBlog;
		this.auther = auther;
		this.msg = msg;
		this.date = date;
		this.note = note;
	}

	public int getIdBlog() {
		return idBlog;
	}

	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Comment(int idComment, String auther, String msg, Date date, String note) {
		super();
		this.idComment = idComment;
		this.auther = auther;
		this.msg = msg;
		this.date = date;
		this.note = note;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
