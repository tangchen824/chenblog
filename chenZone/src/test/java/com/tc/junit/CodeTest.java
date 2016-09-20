package com.tc.junit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CodeTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Test
	public void Test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user_info><password>123456</password><username>张三</username></user_info>";
		JSON json = new XMLSerializer().read(xml);
		System.out.println("xml--->json \n" + json.toString());  
	}

	@Test
	public void Test2() {
		// Map dataBusMap =
		JSONObject jasonObject = JSONObject.fromObject("{key3='1', key2={key3=1, key2=1, key1=1},key1=1}" );
		System.out.println(jasonObject);
		// if(dataBusMap.get("accNbrType")==null){
		// System.out.println("0");
		// }
		// if("1".equals(dataBusMap.get("accNbrType").toString())){
		// System.out.println("1");
		// }
	}

	@Test
	public void Test3() {
		// for(int i = 101;i<=303;i++){
		// if(i%100>5){
		// i+=100-5-1;
		// continue;
		// }
		// System.out.println(i);
		// }
		System.out.println(234 / 10 + 1);

	}

	@Test
	public void Test4() {
		String[] studyTaglist = new String[0];
		// String studyTag = "";
		// studyTaglist = studyTag.split(",");
		for (int i = 0; i < studyTaglist.length; i++) {
			System.out.println(i + ":" + studyTaglist[i] + ":"
					+ studyTaglist.length);
		}
	}

	@Test
	public void Test5() {
		CacheClear c = new CacheClear();
		c.setIplistleng(10);
		for (int i = 0; i < 3; i++)
			new Thread(c).start();
	}

	class CacheClear implements Runnable {
		private List iplist;
		private String type;
		private String[] portList = { "10101", "10102", "10103", "10151",
				"10152", "10153" };
		private int iplistleng;
		private int index = 0;

		public CacheClear() {
		}

		public CacheClear(List iplist, String type) {
			this.iplist = iplist;
			this.type = type;
			this.iplistleng = iplist.size();
		}

		public List getIplist() {
			return iplist;
		}

		public void setIplist(List iplist) {
			this.iplist = iplist;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getIplistleng() {
			return iplistleng;
		}

		public void setIplistleng(int iplistleng) {
			this.iplistleng = iplistleng;
		}

		public void run() {
			for (int i = 0; index < iplistleng;) {
				i = ++index;
				System.out.println(i - 1);
			}
		}
	}

	@Test
	public void Test6() {
		System.out.println("请输入成绩：");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int chengji;
		try {
			chengji = new Integer(stdin.readLine());
			char dengji = chengji < 60 ? 'c' : (chengji >= 90 ? 'a' : 'b');
			System.out.println(dengji);
		} catch (Exception e) {
			System.out.println("出现错误，具体错误信息为：");
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test7() {
		Object a = new Object();
		a= "string";
		System.out.println(a.getClass().getName());
		a= 1;
		System.out.println((a+"").getClass().getName());
		a=(Object)a;
		System.out.println(a.getClass().getName());
	}

	@Test
	public void Test8() {
		Object a = new Object();
		a= "string";
		System.out.println(a.getClass().getName());
		a= 1;
		System.out.println((a+"").getClass().getName());
	}
}
