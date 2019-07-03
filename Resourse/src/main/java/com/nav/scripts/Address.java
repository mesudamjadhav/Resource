package com.nav.scripts;

//@Component("address")
public class Address {
	
	private Integer pinCode;
	
	private String streetName;

	public Address(Integer pinCode, String streetName) {
		this.pinCode = pinCode;
		this.streetName = streetName;
	}

	public Address() {
		System.out.println("Constructed");
		pinCode = 1245;
		streetName = "Pune";
	}
	
	@Override
	public String toString() {
		return "Address [pinCode=" + pinCode + ", streetName=" + streetName + "]";
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	
}
