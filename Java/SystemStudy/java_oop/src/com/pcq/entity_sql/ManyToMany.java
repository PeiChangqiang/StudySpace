package com.pcq.entity_sql;

/**
 * 多对多关系映射
 * @author Administrator
 *
 */
public class ManyToMany {
	public static void main(String[] args) {
		
	}
}


/*
class Member {
	private String name;
	private String mId;
	private Product[] products;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	

}*/	


class Product {
	private String name;
	private String pId;
    private Member[] members;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Member[] getMembers() {
		return members;
	}
	public void setMembers(Member[] members) {
		this.members = members;
	}
    
    
	
}