package com.vic.httpclient.xapp;


/**
 * 身份证正面返回对象vo
 * @author: 罗利华
 * date: 2019/12/05 16:03
 **/
public class AdvanceCardFrontVo {
    private String idNumber;

    private String name;

    private String gender;

    private String state;

    private String district;

    private String subdistrict;

    private String addressAll;

    private String birthday;

    private String other;

    /*
    "idNumber": "7535 3126 0102",
    "name": "Luke Phlip Vaidyan",
    "birthday": "01/11/1992",
    "gender": "MALE",
    "pin": "517001",
    "state": "Andhra Pradesh",
    "district": "Chittoor",
    "subdistrict": "Bishunpur",
    "other": "S/O M K Mahammad Hussen, 15-1714, Lalugarden, Lalugarden",
    "address_all": "S/O M K Mahammad Hussen, 15-1714, Lalugarden, Lalugarden, Bishunpur, Chittoor, Andhra Pradesh, 517001"
     */

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getAddressAll() {
        return addressAll;
    }

    public void setAddressAll(String addressAll) {
        this.addressAll = addressAll;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
