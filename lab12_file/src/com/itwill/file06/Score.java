package com.itwill.file06;

import java.io.Serializable;

public class Score implements Serializable{
	//field
	private int java;
	private int wep;
	private int spring;
	
	// TODO constructor, get/set, toString.
	public Score () {};
	public Score (int java, int wep, int spring) {
		this.java = java;
		this.wep = wep;
		this.spring = spring;
	}
	
	public int getjava() {
		return java;
	}
	public int getWep() {
		return wep;
	}
	public int getSpring() {
		return spring;
	}
	
	public void setJava(int java) {
		this.java = java;
	}
	public void setWep(int wep) {
		this.wep = wep;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	@Override
	public String toString() {
		return "[java=" + java + ", wep=" + wep + ", spring=" + spring + "]";
	}
	
	
	

}
