package com.pcq.entity_sql;

/**
 * 用户角色权限复杂多对多关系
 * @author Administrator
 *
 */
public class RoleMemberPri {

	
}


/**
 * 角色
 * @author Administrator
 *
 */
class Role {
	private String rId;
	private String rName;
	private Member[] members;
	private Privilege[] privileges;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Member[] getMembers() {
		return members;
	}
	public void setMembers(Member[] members) {
		this.members = members;
	}
	public Privilege[] getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Privilege[] privileges) {
		this.privileges = privileges;
	}
	
	
}


/**
 * 用户
 * @author Administrator
 *
 */
class Member {
	private String mId;
	private String mName;
	private Role[] roles;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Role[] getRoles() {
		return roles;
	}
	public void setRoles(Role[] roles) {
		this.roles = roles;
	}
	
	
}

/**
 * 权限
 * @author Administrator
 *
 */
class Privilege {
	
	private String pId;
	private String pName;
	private Role role;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}