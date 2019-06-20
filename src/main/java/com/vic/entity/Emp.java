package com.vic.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Emp {
	
	private String regTime;
	
	private Integer provinceId;
	
	private String province;

	public Emp(String regTime, Integer provinceId, String province) {
		super();
		this.regTime = regTime;
		this.provinceId = provinceId;
		this.province = province;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Override
	public String toString() {
		return "Emp [regTime=" + regTime + ", provinceId=" + provinceId + ", province=" + province + "]";
	}

	public static void main(String[] args) {
		
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("2017-03-02", 5, "湖北省"));
		list.add(new Emp("2017-01-03", 1, "河南省"));
		list.add(new Emp("2017-01-02", 1, "河南省"));
		list.add(new Emp("2017-01-05", 1, "河南省"));
		list.add(new Emp("2017-05-06", 2, "北京市"));
		list.add(new Emp("2017-07-04", 3, "上海市"));
		
		Collections.sort(list, new Comparator<Emp>(){
			@Override
			public int compare(Emp o1, Emp o2) {
				int rst = o1.getProvinceId().compareTo(o2.getProvinceId());
				if(rst == 0) {
					return o2.getRegTime().compareTo(o1.getRegTime());
				}
				return rst;
			}
		});
		for(Emp e : list) {
			System.out.println(e);
		}
		
		
		
		
	}
	
}
