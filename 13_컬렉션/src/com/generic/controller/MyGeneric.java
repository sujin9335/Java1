package com.generic.controller;

public class MyGeneric<T> {

	private T data;
//	private E data2;
	
	public MyGeneric() {
		// TODO Auto-generated constructor stub
	}
	
	public MyGeneric(T data) {
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
