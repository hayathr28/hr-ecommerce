package com.hr.ecommerce.member;

import com.hr.ecommerce.common.Address;
import com.hr.ecommerce.common.Profile;

public class Member {
	
	private String memberId;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private Profile profile;
	private Address address;
	
	
	

}
