import solve.CoordCube;
import solve.Search;

import java.util.Objects;
import java.util.Scanner;

/*
 * 版本代码基于kociemba改动而来
 * 地址：http://kociemba.org/download.htm
 * 源代码下载连接 http://kociemba.org/downloads/twophase.jar
 * 有界面的版本下载连接 http://kociemba.org/downloads/GUI_example.jar
 * 作者：量子力学蛤
 * 时间：2022-11-4 凌晨一点三十分
 * 食用指南：new Search().solution(str, 24, 5, false);
 * 分别对于：魔方状态（56个面块的颜色），最大步数，最大搜索深度，结果字符串输出是否有间隔
 * 改进了什么：原来需要初始化很久，才发现是new CoordCube()需要初始化的东西太多了
 * 于是我特意开启了一个空的构造函数，用于static块，用于初始化
 * 同时采用多线程的方式，加快了初始化速度
 * 从一开始的60多秒，缩短到了几十毫秒
 * 输入测试用例 UBRLUFFUBLRUFRLLLRDBDRFDBBUDDBUDDLRFBFLDLBFFRFLRUBRDUU
 * 预期输出结果 "L' B' R2 D2 R L U F' D R U L2 U' D R2 D' F2 U D2"
 * 测试用例来自 https://blog.csdn.net/weixin_42846018/article/details/104809790
 * 结果准确无误
 */
public class Main {
    public static void main(String[] args) {
        new CoordCube();
        while (true) {
            //接受输入
            System.out.println("初始化完成");
            String str = new Scanner(System.in).nextLine();
            long startTime = System.currentTimeMillis();
            System.out.println("开始");
            String result = new Search().solution(str, 24, 5, false);
            System.out.println(result);
            // 结束时间
            System.out.println("程序运行时间："
                    + (System.currentTimeMillis() - startTime)
                    + "ms");
        }
    }
}
