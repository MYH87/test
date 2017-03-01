package com.imooc.collection;

import java.util.HashSet;
import java.util.Set;
/**
 * 学生类
 * @author MYH
 *
 */
public class Student {
	private String id;
	private String name;
	
	public Set<Course> courses;

	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.courses=new HashSet<Course>();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
