package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new App(sc).run();
        // 앱 클래스에 sc라는 인자를 넣어서 run 메서드로 전부 보내버린다
        // 그래서 앱 클래스에 스캐너를 매개변수로 넣는 생성자 필요

        sc.close();
    }
}