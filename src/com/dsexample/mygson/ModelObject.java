package com.dsexample.mygson;

public class ModelObject {
	String name;
	int val;
	boolean status;
	double f;
	M2 m2;

	public ModelObject(String name, int val, boolean status, double f) {
		super();
		this.name = name;
		this.val = val;
		this.status = status;
		this.f = f;
		this.m2 = new M2();
	}

	@Override
	  public String toString() {
	    return "ModelObject [name=" + name + ", val=" + val + ", status="
	    + status + ", f=" + f + "]";
	  }
	
	class M2{
		
		int x;
		String s;
	}
}