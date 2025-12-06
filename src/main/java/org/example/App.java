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
        // Main 에서 App으로, 그리고 각 클래스로 스캐너 전달
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);


        // 코드블록 무한 반복
        while (true) {

            // 명령어 입력
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            // "exit" > 종료
            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } // 명령어 미입력시
            else if(cmd.length() == 0){
                System.out.println("명령어를 작성하세요.\n");
                continue;
            }

            // "add" > 모티베이션, 출처
            if (cmd.equals("add")) {
                motivationController.doAdd();
            } // "list" > 목록
            else if (cmd.equals("list")) {
                motivationController.showList();

            } // "del" > 삭제
            else if(cmd.startsWith("del")){
                motivationController.doDel(cmd);

            }// "edit" > 수정
            else if(cmd.startsWith("edit")){
                motivationController.doEdit(cmd);

            }// "detail" > 상세보기
            else if(cmd.startsWith("detail")){
                motivationController.showDetail(cmd);

            } // 명령어 외 일괄
            else {
                System.out.println("[사용 가능 명령어]\n1. add (추가하기)\n2. list (목록조회)\n3. del (삭제하기)\n4. edit (수정하기)\n5. detail (상세보기)\n6. exit (종료하기)\n");
            }
        }
    }
}