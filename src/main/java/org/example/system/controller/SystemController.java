package org.example.system.controller;

import java.util.Scanner;

public class SystemController {

    // 스캐너가 있다고 선언만 해주고
    Scanner sc;
    // App 에서 받은 스캐너를 사용
    public SystemController(Scanner sc) {
        this.sc = sc;
    }

    public void exit() {
        System.out.println("== motivation 종료 ==");
    }
}

