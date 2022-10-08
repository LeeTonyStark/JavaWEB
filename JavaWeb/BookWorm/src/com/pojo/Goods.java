package com.pojo;

import java.math.BigDecimal;

/**
 * @author lifeng
 * @create 2022-09-22 14:01
 */
public class Goods {
    private int id;
    private String name;
    private String goodsno;
    private String author;
    private String publisher;
    private String pubtime;
    private int categoryid;
    private String description;
    private String image;
    private int stock;
    private BigDecimal marketprice;
    private BigDecimal salesprice;
    private BigDecimal score;
    private int remarknums;
    private String uptime;
    private int salenums;
    private String newest;
    private String hot;
    private String status;

    public Goods() {
    }

    public Goods(int id, String name, String goodsno, String author, String publisher, String pubtime, int categoryid, String description, String image, int stock, BigDecimal marketprice, BigDecimal salesprice, BigDecimal score, int remarknums, String uptime, int salenums, String newest, String hot, String status) {
        this.id = id;
        this.name = name;
        this.goodsno = goodsno;
        this.author = author;
        this.publisher = publisher;
        this.pubtime = pubtime;
        this.categoryid = categoryid;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.marketprice = marketprice;
        this.salesprice = salesprice;
        this.score = score;
        this.remarknums = remarknums;
        this.uptime = uptime;
        this.salenums = salenums;
        this.newest = newest;
        this.hot = hot;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public BigDecimal getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(BigDecimal salesprice) {
        this.salesprice = salesprice;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public int getRemarknums() {
        return remarknums;
    }

    public void setRemarknums(int remarknums) {
        this.remarknums = remarknums;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public int getSalenums() {
        return salenums;
    }

    public void setSalenums(int salenums) {
        this.salenums = salenums;
    }

    public String getNewest() {
        return newest;
    }

    public void setNewest(String newest) {
        this.newest = newest;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsno='" + goodsno + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubtime='" + pubtime + '\'' +
                ", categoryid=" + categoryid +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                ", marketprice=" + marketprice +
                ", salesprice=" + salesprice +
                ", score=" + score +
                ", remarknums=" + remarknums +
                ", uptime='" + uptime + '\'' +
                ", salenums=" + salenums +
                ", newest='" + newest + '\'' +
                ", hot='" + hot + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
