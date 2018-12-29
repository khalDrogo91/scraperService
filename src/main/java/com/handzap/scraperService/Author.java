package com.handzap.scraperService;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int id;
	private List<String> articles = new ArrayList<String>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getArticles() {
		return articles;
	}
	public void setArticles(List<String> articles) {
		this.articles = articles;
	}
	
	
	
}
