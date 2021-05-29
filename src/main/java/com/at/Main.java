package com.at;

import sun.java2d.opengl.WGLGraphicsConfig;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
    }


}

//    public static void main(String[] args) throws InterruptedException {
//        Scanner in = new Scanner(System.in);
//        String workerNumStr = in.nextLine().trim();
//        Main main = new Main();
//        main.lead(Integer.parseInt(workerNumStr));
//
//
//
//    }
//
//    public void lead(int workerNum) throws InterruptedException {
//
//        System.out.println("预备");
//        System.out.println("比赛开始");
//
//        CountDownLatch downLatch = new CountDownLatch(workerNum);
//
//
//        for (int i = 0; i < workerNum; i++) {
//            new Runnable() {
//                @Override
//                public void run() {
//                    downLatch.countDown();
//                    System.out.println("运动员跑步中......");
//                }
//            }.run();
//        }
//
//
//        downLatch.await();
//        System.out.println("比赛结束");
//
//
//    }
