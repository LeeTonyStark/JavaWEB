package com.lifeng.java.day10.exer;

/**
 * @author lifeng
 * @create 2022-07-02 13:24
 */
public class exer2 {

    public static void main(String[] args) {
        notebook notebook = new notebook();
        notebook.notebookOpen();
        notebook.useMouse();
        notebook.closeMouse();
        notebook.useKeyboard();
        notebook.closeKeyboard();
        notebook.notebookClose();
    }

}

/**
 * 笔记本类
 */
class notebook implements Mouse,Keyboard{

    //笔记本开机功能
    public void notebookOpen(){
        System.out.println("开机");
    }

    //笔记本关机功能
    public void notebookClose(){
        System.out.println("关机");
    }

    @Override
    public void useMouse() {
        System.out.println("连接鼠标的USB");
    }

    @Override
    public void closeMouse() {
        System.out.println("断开鼠标的USB");
    }

    @Override
    public void useKeyboard() {
        System.out.println("连接键盘的USB");
    }

    @Override
    public void closeKeyboard() {
        System.out.println("断开键盘的USB");
    }

    @Override
    public void usbOpen() {
        System.out.println("USB功能开启");
    }

    @Override
    public void usbClose() {
        System.out.println("USB功能关闭");
    }
}

/**
 * 鼠标类
 */
interface Mouse extends USB {
    void useMouse();
    void closeMouse();
}

/**
 * 键盘类
 */
interface Keyboard extends USB {
    void useKeyboard();
    void closeKeyboard();
}

//USB接口
interface USB{

    //USB开启
    void usbOpen();

    //USB关闭
    void usbClose();
}

