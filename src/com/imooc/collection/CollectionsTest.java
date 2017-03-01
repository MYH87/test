package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 将要完成：
 * 1、通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2、对String泛型的List进行排序；
 * 3、对其他类型泛型的List进行排序，以Student为例
 * @author MYH
 *
 */
public class CollectionsTest {

	private static final String sb = null;
	/**
	 *  1、通过Collections.sort()方法，对Integer泛型的List进行排序；
	 *  创建一个Integer泛型的List，插入十个100以内的不重复随机整数，
	 *  调用Collections.sort()方法对其进行排序
	 * @param args
	 */
	public void testSort1(){
		List<Integer> integerList=new ArrayList<Integer>();
		//插入十个100以内的不重复随机整数
		Random random=new Random();
		Integer k;
		for(int i=0;i<10;i++){
			do{
				k=random.nextInt(100);   //100以内的随机整数
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数："+k);
		}
		System.out.println("----------排序前---------------");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}
		Collections.sort(integerList);
		System.out.println("----------排序后---------------");
		for (Integer integer : integerList) {
			System.out.println("元素："+integer);
		}
	}
	
	/**
	 *  1、通过Collections.sort()方法，对String泛型的List进行排序；
	 *  创建一个String泛型的List，插入三个乱序的String元素，
	 *  调用Collections.sort()方法对其进行排序
	 *  排序是0-9；A-Z；a-z
	 * @param args
	 */
	public void testSort2(){
		List<String> stringList=new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("----------排序前---------------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
		Collections.sort(stringList);
		System.out.println("----------排序后---------------");
		for (String string : stringList) {
			System.out.println("元素："+string);
		}
	}
	/**
	 *  1、通过Collections.sort()方法，对String泛型的List进行排序2；
	 *  2、创建一个String泛型的List，往其中添加十条随机字符串
	 *  3、每条字符串的长度为10以内的随机整数
	 *  3、每条字符串的每个字符都为随机生成的字符，字符可以重复
	 *  4、每条字符串不可重复
	 *  调用Collections.sort()方法对其进行排序
	 *  排序是0-9；A-Z；a-z
	 * @param args
	 */
	public void testSort3() {
		List<String> stringlist=new ArrayList<String>();
		Random random=new Random();
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 	
		for(int i=0;i<10;i++){
			StringBuffer sb=new StringBuffer();
			char b;
			int n;  		//获取10以内的随机数，当随机数为0，则重新获取
			do{
			 n=random.nextInt(10);
			}while(n==0);
			System.out.println("n:"+n);
			for(int j=0;j<n;j++){
				int m=random.nextInt(base.length()) ;
				b=base.charAt(m);	
				sb.append(b);
				System.out.println("添加字符："+b);
			}
			stringlist.add(sb.toString());
		}
		System.out.println("---------排序前--------");
		for(String m:stringlist){
			System.out.println("元素："+m);
		}
		System.out.println("---------排序后--------");
		Collections.sort(stringlist);
		for(String m:stringlist){
			System.out.println("元素："+m);
		}
	}
	
	/**
	 * 自己修改
	 *  1、通过Collections.sort()方法，对String泛型的List进行排序3；
	 *  2、创建一个String泛型的List，往其中添加十条随机字符串
	 *  3、每条字符串的长度为10以内的随机整数
	 *  3、每条字符串的每个字符都为随机生成的字符，字符可以重复
	 *  4、每条字符串不可重复
	 *  调用Collections.sort()方法对其进行排序
	 *  排序是0-9；A-Z；a-z
	 * @param args
	 */
	public void testSort4() {
		List<String> stringlist=new ArrayList<String>();
		Random random=new Random();
		char[] chars={'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
				'e', 'g', 'f', 'h', 'i', 'j', 'k', 'l', 'n', 'm', 'o', 'p', 'q', 'r', 
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};	
		for(int i=0;i<10;i++){
			StringBuffer sb=new StringBuffer();
			char b;
			int n;  		//获取10以内的随机数，当随机数为0，则重新获取
			do{
			 n=random.nextInt(10);
			}while(n==0);
			System.out.println("n:"+n);
			for(int j=0;j<n;j++){
				int m=random.nextInt(chars.length) ;
				sb.append(chars[m]);
//				System.out.println("添加字符："+b);
			}
			stringlist.add(sb.toString());
		}
		System.out.println("---------排序前--------");
		for(String m:stringlist){
			System.out.println("元素："+m+" ");
		}
		System.out.println("---------排序后--------");
		Collections.sort(stringlist);
		for(String m:stringlist){
			System.out.println("元素："+m+" ");
		}
	}
	/**
	 *  自己编写
	 *  1、通过Collections.sort()方法，对String泛型的List进行排序3；
	 *  2、创建一个String泛型的List，往其中添加十条随机字符串
	 *  3、每条字符串的长度为10以内的随机整数
	 *  3、每条字符串的每个字符都为随机生成的字符，字符可以重复
	 *  4、每条字符串不可重复
	 *  调用Collections.sort()方法对其进行排序
	 *  排序是0-9；A-Z；a-z
	 * @param args
	 */
	public void testSort5(){
		List<String> stringlist=new ArrayList<String>();
		char[] chars={'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 
				'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
				'e', 'g', 'f', 'h', 'i', 'j', 'k', 'l', 'n', 'm', 'o', 'p', 'q', 'r', 
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		Random b=new Random();
		int k;
		for(int i=0;i<10;i++){
			do{
				k=b.nextInt(10);     //随机生成10以内的整数，当k=0时重新生成
			}while(k==0);
			System.out.println("k:"+k);
			StringBuffer sb=new StringBuffer();
			for(int j=1;j<=k;j++){
			int m=b.nextInt(chars.length);
			char n=chars[m];
			sb.append(n);
			System.out.println("添加了字符："+n);
			}
			stringlist.add(sb.toString());
		}
		System.out.println("------------排序前----------------");
		for(String x:stringlist){
			System.out.println("元素："+x);
		}
		Collections.sort(stringlist);
		System.out.println("------------排序后----------------");
		for(String x:stringlist){
			System.out.println("元素："+x);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CollectionsTest ct=new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSort3();
//		ct.testSort4();
		ct.testSort5();
	}

}
