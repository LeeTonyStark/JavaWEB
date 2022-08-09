package com.lifeng.java.gobang.message;

import java.io.Serializable;

/**
 * 悔棋信息
 * @author lifeng
 * @create 2022-08-02 19:17
 */
public class RetractMessage extends Message implements Serializable{

    private int flag;//定义到底是哪种悔棋信息
    public static final int REPLAY_REQUEST=1;//悔棋请求
    public static final int REPLAY_AGRRE = 2;//同意悔棋
    public static final int REPLAY_REFUSE = 3;//拒绝悔棋
    public int getFlag(){
        return flag;
    }

    public void steFlag(int flag){
        this.flag = flag;
    }


}
