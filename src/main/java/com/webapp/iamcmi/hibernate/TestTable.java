package com.webapp.iamcmi.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.Table;  

//TestTable.hbm.xml
@Entity
@Table(name="TestTable")
public class TestTable {
	@Id  
	@GeneratedValue
	private int id;

	@Column(name="first")
	private String first;

	@Column(name="last")
	private String last;   
	private int age;

	public TestTable(){

	}

	public TestTable(int id, String first, String last, int age) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 


}
