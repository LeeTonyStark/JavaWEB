package com.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lifeng
 * @create 2022-09-29 13:21
 */
public class test {
    @Test
    public void test1(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //日期格式格式化为字符串
        String format = sdf.format(date);
        System.out.println(format);
        //字符串解析为日期格式
        Date parse = null;
        try {
            parse = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(parse);

    }
}
