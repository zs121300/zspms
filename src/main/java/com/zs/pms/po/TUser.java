package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -6241116510627857045L;
	
	
private  int id;
private String loginname;
private String password;
private String sex;
private Date  birthday;
private String email;
private TDep dept;
private String realname;
private int creator;
private Date creatime;
private int updator;
private Date  updatime;
private String pic;
private int isenabled;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoginname() {
	return loginname;
}
public void setLoginname(String loginname) {
	this.loginname = loginname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
public int getCreator() {
	return creator;
}
public void setCreator(int creator) {
	this.creator = creator;
}

public int getUpdator() {
	return updator;
}
public void setUpdator(int updator) {
	this.updator = updator;
}

public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public int getIsenabled() {
	return isenabled;
}
public void setIsenabled(int isenabled) {
	this.isenabled = isenabled;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(java.util.Date date) {
	this.birthday = date;
}
public TDep getDept() {
	return dept;
}
public void setDept(TDep dept) {
	this.dept = dept;
}
public Date getCreatime() {
	return creatime;
}
public void setCreatime(Date creatime) {
	this.creatime = creatime;
}
public Date getUpdatime() {
	return updatime;
}
public void setUpdatime(Date updatime) {
	this.updatime = updatime;
}


}
