package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**
	 * 用来承装学生类型对象
	 */
	public Map<String,Student>students;
	/**
	 * 在构造器中初始化students属性
	 */
	public MapTest(){
		this.students=new HashMap<String,Student>();
	}
	/**
	 * 测试添加：输入学生ID，判断是否被占用
	 * 若未被占用，则输入姓名，创建新学生对象，并且添加到students中
	 * @param args
	 */
	public void testPut(){
		//创建一个Scanner对象，用来获取输入的学生ID和姓名
		Scanner console=new Scanner(System.in);
		int i=0;
		while(i<3){
			System.out.println("请输入学生ID：");
			String ID=console.next();
			//判断该ID是否被占用
			Student st=students.get(ID);
			if(st==null){
				//提示输入学生姓名
				System.out.println("请输入学生姓名：");
				String name=console.next();
				//创建新的学生对象
				Student newStudent=new Student(ID,name);
				//通过调用students的put方法，添加ID-学生映射
				students.put(ID, newStudent);
				System.out.println("成功添加学生："+students.get(ID).getName());
				i++;
			}else{
				System.out.println("该学生ID已被占用！");
				continue;
	}
}
}
	
	/**
	 * 测试Map的keySet方法
	 * @param args
	 */
	public void testKeySet(){
		//通过keySet方法，返回Map中的所有“键”的Set集合
		Set<String>keySet=students.keySet();
		//取得students的容量
		System.out.println("总共有："+students.size()+"个学生！");
		//遍历keySet，取得每一个键，再调用get方法取得每个键对应的value值
		for(String stuId:keySet){
			Student st=students.get(stuId);
			if(st!=null){
				System.out.println("学生："+st.getName());
			}
		}
	}
	
	
	/**
	 * 测试删除Map中的映射
	 * @param args
	 */
	public void TestRemove(){
		//获取从键盘输入的待删除的学生ID字符串
		Scanner console=new Scanner(System.in);
		while(true){
		//提示输入待删除的学生的ID
		System.out.println("请输入要删除的学生ID！");
		String ID=console.next();
		//判断该ID是否有对应的学生对象
		Student st=students.get(ID);
		if(st==null){
			//提示输入的ID并不存在
			System.out.println("该ID不存在！");
			continue;
		}
		students.remove(ID);
		System.out.println("成功删除学生："+st.getName());
		break;
		}
	}
	/**
	 * 通过entrySet方法来遍历Map
	 * @param args
	 */
	public void testEntrySet(){
		//通过entrySet方法，返回Map中的所有键值对
		Set<Entry<String,Student>>entrySet=students.entrySet();
		for(Entry<String,Student>entry:entrySet){
			System.out.println("取得键："+entry.getKey());
			System.out.println("对应的值为："+entry.getValue().getName());
		}
	}
	/**
	 * 利用put方法修改Map中已有映射
	 * @param args
	 */
	public void testModify(){
		//
		System.out.println("请输入要修改的学生ID：");
		Scanner console=new Scanner(System.in);
		while(true){
			String stuID=console.next();
			Student student=students.get(stuID);
			if(student==null){
				System.out.println("该ID不存在！请重新输入！");
				continue;
			}
			//提示当前对应的学生对象的姓名
			System.out.println("当前该学生ID，所对应的学生为："+student.getName());
			//提示输入新的学生姓名，来修改已有的映射
			System.out.println("请输入新的学生姓名：");
			String name=console.next();
			Student newstudent=new Student(stuID,name);
			students.put(stuID, newstudent);
			System.out.println("修改成功！");
			break;
		}
	}
	
	/**
	 * 测试Map中，是否包含某个Key值或者某个Value值
	 * @param args
	 */
	public void testContainsKeyOrValue(){
		//提示输入学生id
		System.out.println("请输入要查询的学生ID：");
		Scanner console=new Scanner(System.in);
		String id=console.next();
		//在Map中，用containsKey()方法，来判断是否包含某个Key值
		System.out.println("您输入的学生ID为："+id+",在学生映射表中是否存在："
				+students.containsKey(id));
		if(students.containsKey(id))
			System.out.println("对应的学生为："+students.get(id).getName());
		//提示输入学生姓名
		System.out.println("请输入要查询的学生姓名：");
		String name=console.next();
		//用containsValue()方法，来判断是否包含某个Value值
//		System.out.println("您输入的学生姓名为："+name+"，在学生映射表中是否存在："
//		          +students.containsValue(name));
		if(students.containsValue(new Student(null,name)))    //参数为一个对象，这个对象有name参数，无ID参数
			System.out.println("在学生映射表中，确实包含学生："+name);
		else
			System.out.println("不存在该学生姓名。");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt=new MapTest();
		mt.testPut();
		mt.testKeySet();
		//mt.TestRemove();
		//mt.testEntrySet();
//		mt.testModify();
//		mt.testEntrySet();
		mt.testContainsKeyOrValue();
		}
	}
