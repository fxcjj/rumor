package com.vic.serialization;

import java.io.Serializable;

public class Son extends Father implements Serializable {
	
	private static final long serialVersionUID = -7987636394335549270L;

	private String petName;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	@Override
	public String toString() {
		return "Son [petName=" + petName + "]";
	}

}
