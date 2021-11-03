package com.quizmanagement.blog.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Blog implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idblog;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String description;

	private String titre;





	public Blog(int idblog, Date date, String description, String titre) {
		super();
		this.idblog = idblog;
		this.date = date;
		this.description = description;
		this.titre = titre;
	}





	public int getIdblog() {
		return idblog;
	}





	public void setIdblog(int idblog) {
		this.idblog = idblog;
	}





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getTitre() {
		return titre;
	}





	public void setTitre(String titre) {
		this.titre = titre;
	}





	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
