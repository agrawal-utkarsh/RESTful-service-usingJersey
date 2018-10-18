package org.satyam.jerseyadapi.adapi.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seller {
	private int sid;
	private String sname;
	private String saddress;
	public Seller() {
		
	}
	public Seller(int id,String name,String address){
		sid=id;
		sname=name;
		saddress=address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
}
