package com;

import javax.persistence.Id;

public class Student {
	@Id Long id;
	
private String std_name;
private int age;
private String baranch;
private String newcursor;

public String getNewcursor() {
	return newcursor;
}
public void setNewcursor(String newcursor) {
	this.newcursor = newcursor;
}
public String getStd_name() {
	return std_name;
}
public void setStd_name(String std_name) {
	this.std_name = std_name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getBaranch() {
	return baranch;
}
public void setBaranch(String baranch) {
	this.baranch = baranch;
}

}
