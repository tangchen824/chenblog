package com.tc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: 存储Session的登录回话信息
 * 
 * @author tc
 * @date 2015-03-11
 * @version v1.0
 */
public class SessionStaff {
	/** id标识 */
	private Integer staffId;
	/** 名字 */
	private String staffName;
	/** 昵称 */
	private String staffNickName;
	/** 学生会届数 */
	private Integer period;
	/** 性别：0为未知，1为男，2为女 */
	private Integer sex;
	/** 密码 */
	private String password;
	/** 是否为管理员 用户 */
	private boolean ifAdministrator;
	/** 是否为超级管理员 */
	private boolean ifSuperAdministrator;
	/** 备注 */
	private String remark;
	/** 登录时间 */
	private String loginTime;

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffNickName() {
		return staffNickName;
	}

	public void setStaffNickName(String staffNickName) {
		this.staffNickName = staffNickName;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIfAdministrator() {
		return ifAdministrator;
	}

	public void setIfAdministrator(boolean ifAdministrator) {
		this.ifAdministrator = ifAdministrator;
	}

	public boolean isIfSuperAdministrator() {
		return ifSuperAdministrator;
	}

	public void setIfSuperAdministrator(boolean ifSuperAdministrator) {
		this.ifSuperAdministrator = ifSuperAdministrator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 
	 * @param 管理员登录的创建的session
	 * @return
	 */
//	public static SessionStaff setStaffInfoFromAdministrator(Administrator admin) {
//		SessionStaff sessionStaff = new SessionStaff();
//		sessionStaff.setIfAdministrator(true);
//		sessionStaff.setStaffId(admin.getAdminId());
//		sessionStaff.setStaffName(admin.getName());
//		sessionStaff.setStaffNickName(admin.getNickname());
//		if (admin.getPeriod() != null)
//			sessionStaff.setPeriod(admin.getPeriod());
//		sessionStaff.setSex(admin.getSex());
//		sessionStaff.setPassword(admin.getPassword());
//		if (admin.getIfSuperAdministrator() == 1)
//			sessionStaff.setIfSuperAdministrator(true);
//		else
//			sessionStaff.setIfSuperAdministrator(false);
//		if (admin.getRemark() != null)
//			sessionStaff.setRemark(admin.getRemark());
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//		sessionStaff.setLoginTime(df.format(new Date()));
//		return sessionStaff;
//	}
//
//	/**
//	 * 
//	 * @param 用户登录的创建的session
//	 * @return
//	 */
//	public static SessionStaff setStaffInfoFromStaff(Staff staff) {
//		SessionStaff sessionStaff = new SessionStaff();
//		sessionStaff.setIfAdministrator(false);
//		sessionStaff.setStaffId(staff.getStaffId());
//		sessionStaff.setStaffName(staff.getStaffName());
//		sessionStaff.setStaffNickName(staff.getNickname());
//		if (staff.getPeriod() != null)
//			sessionStaff.setPeriod(staff.getPeriod());
//		if (staff.getPassword() != null)
//			sessionStaff.setPassword(staff.getPassword());
//		sessionStaff.setSex(staff.getSex());
//		if (staff.getRemark() != null)
//			sessionStaff.setRemark(staff.getRemark());
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//		sessionStaff.setLoginTime(df.format(new Date()));
//		return sessionStaff;
//	}
}