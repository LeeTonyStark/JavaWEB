package com.lifeng.java.gobang.message;

import java.io.Serializable;

/**
 * 情况信息类
 * @author lifeng
 * @create 2022-08-07 22:48
 */
public class ClearMessage implements Serializable {
    private int flag;//定义对方是否清空
    public static final int IS_CLEAR =1;//清空请求
    public static final int ALLOW_CLEAR = 2;//同意清空
    public static final int NO_CLEAR = 3;//不同意清空

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
