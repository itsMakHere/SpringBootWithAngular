package com.mytest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int id;
	private String name;
	protected Customer(){
		
	}
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
   @Override
    public String toString() {
        return String.format(
                "MediaFile[id=%d, name='%s']",
                id, name);
    }

}
