package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

	public List<Course> coursesToSelect;
	private Scanner console;
	public Student student;
	
	public SetTest(){
		coursesToSelect =new ArrayList<Course>();
		console=new Scanner(System.in);
	}
	
	public void testAdd(){
		//创建一个课程对象，并通过调用add方法，添加到备选课程List中
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);
		Course temp=(Course) coursesToSelect.get(0);
		//System.out.println("添加了课程:"+temp.getId()+":"+temp.getName());
		
		Course cr2=new Course("2","C语言");
		coursesToSelect.add(0, cr2);
		Course temp2=(Course) coursesToSelect.get(0);
		//System.out.println("添加了课程:"+temp2.getId()+":"+temp2.getName());
		
		Course cr0=new Course("1","数据结构");
		coursesToSelect.add(cr0);
		Course temp0=(Course) coursesToSelect.get(2);
		//System.out.println("添加了课程:"+temp0.getId()+":"+temp0.getName());
		
		//以下方法会抛出数组下标越界异常
		//Course cr3=new Course("3","test");
		//coursesToSelect.add(4, cr3);
		//Course temp3=(Course) coursesToSelect.get(4);
		//System.out.println("添加了课程:"+temp3.getId()+":"+temp3.getName());
		
		Course[] course={new Course("3","离散数学"),new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3=(Course) coursesToSelect.get(2);
		Course temp4=(Course) coursesToSelect.get(3);
		//System.out.println("添加了两门课程："+temp3.getId()+":"+
		//temp3.getName()+";"+temp4.getId()+":"+temp4.getName());
		
		Course[] course2={new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5=(Course) coursesToSelect.get(2);
		Course temp6=(Course) coursesToSelect.get(3);
		//System.out.println("添加了两门课程："+temp5.getId()+":"+
				//temp5.getName()+";"+temp6.getId()+":"+temp6.getName());
	}
	
	public void testRemove(){
		Course cr=(Course) coursesToSelect.get(4);
		System.out.println("即将删除4位置上的课程！");
		Course[] courses={(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("成功删除课程！");
		testForEach();
	}
	
	public void testModify(){
		coursesToSelect.set(4, new Course("7","毛概"));
		testForEach();
	}
	
	public void testForEach(){
		System.out.println("有如下课程待选（通过foreach访问）：");
		for(Object obj:coursesToSelect){
			Course cr=(Course)obj;
			System.out.println("课程："+cr.getId()+":"+cr.getName());
		}
	}
	/**
	 * 测试List的contains方法
	 * @param args
	 */
	public void testListContains(){
//		//取得备选课程序列的第0个元素
		Course course=coursesToSelect.get(0);
		//打印输出coursesToSelect是否包含course对象
		System.out.println("取得课程："+course.getName());
		System.out.println("备选课程中是否包含课程："+course.getName()+","+
		coursesToSelect.contains(course));
		System.out.println("请输入课程名称：");
		String name=console.next();
		//创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2=new Course();
		course2.setName(name);
		course2.getName();
		System.out.println("新创建课程："+course2.getName());
		System.out.println("备选课程中是否包含课程："+course2.getName()+","+
		coursesToSelect.contains(course2));
		//通过indexOf方法来取得某元素的索引未知
		if(coursesToSelect.contains(course2))
			System.out.println("课程："+course2.getName()+"的索引位置为："+
					coursesToSelect.indexOf(course2));
	}
	//创建学生对象并选课
	public void createStudentAndSelectCours(){
		//创建一个学生对象
		student=new Student("0","小明");
		System.out.println("欢迎学生："+student.getName()+"选课！");
		//创建一个Scanner对象
		Scanner console=new Scanner(System.in);
		
		for(int i=0;i<3;i++){
			System.out.println("请输入课程ID");
			String courseId=console.next();
			for(Course cr:coursesToSelect){
				if(cr.getId().equals(courseId)){
				student.courses.add(cr);
				/**
				 * Set中，添加某个对象，无论添加多少次，
				 * 最终只会保留一个该对象（的引用），
				 * 并且，保留的是第一个添加的那一个
				 */
				//student.courses.add(cr);
				}
	}
}
}
	/**
	 * 测试Set的contains方法
	 * @param args
	 */
	public void testSetContains(){
		//提示输入课程名称
		System.out.println("请输入学生已选的课程名称：");
		String name=console.next();
		//创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2=new Course();
		course2.setName(name);
		course2.getName();
		System.out.println("新创建课程："+course2.getName());
//		System.out.println(course2.getName());+student.courses.contains(course2)
		System.out.println("备选课程中是否包含课程："+course2.getName()+","
        +student.courses.contains(course2));
		
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetTest st=new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();
//		st.createStudentAndSelectCours();
//		st.testSetContains();

//		st.testForEachForSet(student);
//		st.testRemove();
//		st.testModify();

}
		
		//打印输出，学生所选的课程！
		public void testForEachForSet(Student student){
			System.out.println("共选择了："+student.courses.size()+"门课程！");
			for(Course cr:student.courses){
			System.out.println("选择了课程："+cr.getId()+":"+cr.getName());
		}
	}
}
