package com.pojo;

/**
 * @author lifeng
 * @create 2022-09-28 16:46
 */
public class Address {
    private int id;
    private int userid;
    private String accept;
    private String province;
    private String city;
    private String area;
    private String address;
    private String telphone;
    private String type;
    private User user;

    public Address() {
    }

    public Address(int id, int userid, String accept, String province, String city, String area, String address, String telphone, String type, User user) {
        this.id = id;
        this.userid = userid;
        this.accept = accept;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.telphone = telphone;
        this.type = type;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userid=" + userid +
                ", accept='" + accept + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", telphone='" + telphone + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                '}';
    }
}
