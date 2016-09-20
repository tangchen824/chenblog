package com.tc.junit;

import org.junit.Test;
import com.tc.util.Constants;

public class JDBCTest {

	@Test
	public void test() {
//		Administrator staff = new Administrator("小明", "明明", 1, "123456", 1);
//		new AdministratorDAO().save(staff);
	}
	@Test
	public void test2() {
//		Staff staff = new Staff("xiaoming","小明",1,1,"xiaoming1234567890",Constants.WEIXIN_PASSWORD);
//		staff =new StaffDAO().merge(staff);
//		System.out.println(staff.getStaffId());
	}
	@Test
	public void test3() {
//		WeixinUserinfo weixinUserinfo = new WeixinUserinfo("asdfgh", "小明",1,"hunan","yiyang","CH","http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46");
//		new WeixinUserinfoDAO().save(weixinUserinfo);
	}
	@Test
	public void test4() {
		String dormitoryAreaName = "金翰林";
		Integer buildingNumber = 7;
		String dormitoryName =null;
		int start = 201;
		int end = 221;
		for(int i =start ;start<=end;i++){
			if(dormitoryAreaName.equals(Constants.JINHANLIN))
				dormitoryName = "J"+buildingNumber+"-"+i;
			else if(dormitoryAreaName.equals(Constants.QINHU))
				dormitoryName = "QH"+buildingNumber+"-"+i;
			else if(dormitoryAreaName.equals(Constants.BEIYUAN))
				dormitoryName = "N"+buildingNumber+"-"+i;
			else if(dormitoryAreaName.equals(Constants.BEIQING))
				dormitoryName = "BQ"+buildingNumber+"-"+i;
			else if(dormitoryAreaName.equals(Constants.NANYUAN))
				dormitoryName = "S"+buildingNumber+"-"+i;
			else if(dormitoryAreaName.equals(Constants.ZHONGXING))
				dormitoryName = "ZX"+buildingNumber+"-"+i;
			 Integer ifDel = 0;
//			 Dormitory dormitory = new Dormitory(i, dormitoryName, dormitoryAreaName, buildingNumber, ifDel, "");
//			 new DormitoryDAO().save(dormitory);
		}
	}

}
