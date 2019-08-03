package com.mapua.sample;

public class OrderFormDo {
	private Item appetizer;
	private Item mainCourse;
	private Item drink;
	
	private Payment payment;
	private PersonalInfo personalInfo;
	
	private boolean withDessert;
	
	public Item getAppetizer() {
		return appetizer;
	}
	public void setAppetizer(Item appetizer) {
		this.appetizer = appetizer;
	}
	
	public Item getMainCourse() {
		return mainCourse;
	}
	public void setMainCourse(Item mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public Item getDrink() {
		return drink;
	}
	public void setDrink(Item drink) {
		this.drink = drink;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public boolean isWithDessert() {
		return withDessert;
	}
	public void setWithDessert(boolean withDessert) {
		this.withDessert = withDessert;
	}
}
