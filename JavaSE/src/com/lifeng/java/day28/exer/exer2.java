package com.lifeng.java.day28.exer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 2.需求：在本地磁盘中有一个文档：goods.txt,该文档存储的是一些商品信息
 * (商品存储的格式为：商品名称,单价,总量)。
 * 	 例如：
 *  苹果,2,100
 * 	香蕉,5,89
 * 	西瓜,2,1000
 * 	荔枝,19,300
 * 	芒果,5,50
 * 	樱桃,30,450
 * 	要求，把文本中的商品读取出来,存储到适当的集合中。按照要求对商品进行排序：
 * 	首先单价排序(升序),其次总量(降序),再次是商品名称(字典排序)。
 * @author lifeng
 * @create 2022-07-27 19:38
 */
public class exer2 {
    public static void main(String[] args) throws IOException {

        //2.创建一个TreeSet集合存储商品信息,并且重写Comable
        TreeSet<Goods> set = new TreeSet<>(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                int price = o1.getPrice() - o2.getPrice();
                int total = price == 0 ? o2.getTotal() - o1.getTotal() : price;
                int name = total == 0 ? o1.getGoodsName().compareTo(o2.getGoodsName()) : total;
                return name;
            }
        });

        //3.创建一个输入流将goods.txt中的内容读取出来,放到TreeSet中
        BufferedReader br = new BufferedReader(new FileReader("goods.txt"));
        String s = null;
        while ((s = br.readLine()) != null){
            String[] split = s.split(",");//将商品信息用","切割开来
            //将goods对象放到set集合中
            set.add(new Goods(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2])));
        }

        br.close();//关闭输入流

        for (Goods goods1 : set) {
            System.out.println(goods1);
        }

    }
}


//1.创建一个类用来存储商品信息
class Goods{

    private String goodsName;//商品名称
    private int price;//单价
    private int total;//总量

    public Goods() {
    }

    public Goods(String goodsName, int price, int total) {
        this.goodsName = goodsName;
        this.price = price;
        this.total = total;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
