package com.pojo;

import java.math.BigDecimal;

/**
 * 用户订单表
 * @author lifeng
 * @create 2022-09-29 13:30
 */
public class Order {
    private int id;//ID
    private String orderno;//订单编号
    private int userid;//用户id
    private String ordertime;//生成订单时间
    private String accept;//收件人
    private String telphone;//电话
    private String address;//街道地址
    private BigDecimal money;//订单总金额
    private String paytype;//支付方式
    private String status;//订单状态

    public Order() {
    }

    public Order(int id, String orderno, int userid, String ordertime, String accept, String telphone, String address, BigDecimal money, String paytype, String status) {
        this.id = id;
        this.orderno = orderno;
        this.userid = userid;
        this.ordertime = ordertime;
        this.accept = accept;
        this.telphone = telphone;
        this.address = address;
        this.money = money;
        this.paytype = paytype;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", userid=" + userid +
                ", ordertime='" + ordertime + '\'' +
                ", accept='" + accept + '\'' +
                ", telphone='" + telphone + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", paytype='" + paytype + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
