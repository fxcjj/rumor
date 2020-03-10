package com.vic.fastjson;

/**
 * @author 罗利华
 * date: 2019/12/13 17:19
 */
public class CardInfo {

    /*
    "card_info":{"vid":"XXXXXXXXXXXX8291","date_type":"DOB","gender":"Male",
    "card_no":"XXXXXXXXX801","father_name":"***","mother_name":"","name":"***","date_info":"1982-03-15","phone_number":"XXXXXXXXXX"}}
     */
    private String vid;
    private String date_type;
    private String gender;
    private String card_no;
    private String father_name;
    private String mother_name;
    private String name;
    private String date_info;
    private String phone_number;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getDate_type() {
        return date_type;
    }

    public void setDate_type(String date_type) {
        this.date_type = date_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_info() {
        return date_info;
    }

    public void setDate_info(String date_info) {
        this.date_info = date_info;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "vid='" + vid + '\'' +
                ", date_type='" + date_type + '\'' +
                ", gender='" + gender + '\'' +
                ", card_no='" + card_no + '\'' +
                ", father_name='" + father_name + '\'' +
                ", mother_name='" + mother_name + '\'' +
                ", name='" + name + '\'' +
                ", date_info='" + date_info + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
