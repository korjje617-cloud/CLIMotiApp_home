package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;
import java.util.Scanner;

public class App {

    //스캐너 사용
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }


    // 실행되는 메서드
    public void run() {
        System.out.println("== motivation 실행 ==");

        // 각 클래스의 생성자 실행, 인자는 스캐너
        // 메인에서 App으로, 그리고 각 클래스로 스캐너 전달
        SystemController systemController = new SystemController(sc);
        MotivationController motivationController = new MotivationController(sc);


        // 코드블록 무한 반복
        while (true) {

            // 명령어 입력
            System.out.print("명령어 ) ");
            String input = sc.nextLine().trim();


            // "exit" > 종료
            if (input.equals("exit")) {
                systemController.exit();
                break;
            }
            // "add" > 모티베이션, 출처
            if (input.equals("add")) {
                motivationController.add();
            } // "list" > 목록
            else if (input.equals("list")) {
                motivationController.list();
            } // 명령어 외 일괄
            else {
                System.out.println("[사용 가능 명령어]\n1. add (추가하기)\n2. list (목록조회)\n3. exit (종료하기)");
            }
        }
    }
}

