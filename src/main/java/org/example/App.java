package org.example;

import java.util.ArrayList;
import java.util.List;
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

        // add 하나 추가할 때마다 증가
        int lastid = 0;


        // 클래스를 정해진 타입으로 사용하는 동적 타입인 배열 리스트 객체
        // while 문에 들어가면 한번 반복될 때 마다 초기화 되기 때문에 반복문 밖에 있다
        List<MotivAdd> motivList = new ArrayList<>();


        // 코드블록 무한 반복
        while (true) {

            // 명령어 입력
            System.out.print("명령어 ) ");
            String input = sc.nextLine().trim();


            // "exit" > 종료
            if (input.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            }


            // "add" > 모티베이션, 출처
            if (input.equals("add")) {

                // 일단 첫번째 등록
                int id = lastid + 1;

                System.out.print("motivation : ");
                String motivation = sc.nextLine();

                System.out.print("source : ");
                String source = sc.nextLine();

                // 클래스로 객체 생성하고 입력된 값을 생성자를 사용해 자동 `조립`
                MotivAdd motivInfo = new MotivAdd(id, motivation, source);

                // 배열 리스트에 클래스로 만든 객체 계속 `저장`
                // add 의 역할은 저장까지
                motivList.add(motivInfo);

                System.out.printf("%d번 motivation이 등록 되었습니다.\n", id);

                // 1개째 들어갔으니까 마지막으로 추가된 id 는 1개
                lastid ++;


            } // "list" > 목록
            else if (input.equals("list")) {

                // 기본 상태
                System.out.println("=".repeat(50));
                System.out.println("번호     /     source     /     motivation");
                System.out.println("-".repeat(50));

                // 입력된 게 없다면
                if (motivList.isEmpty()) {
                    System.out.println("등록 없음");
                }

                // 입력된 게 있다면
                // 처음은 for each 문 사용, 향상된 for문으로 순회할 배열이나 배열리스트 지정
                // for (MotivAdd motivInfo : motivList) << for (타입 변수명 : 루프할 배열이나 배열리스트 이름)
                // 하지만 desc 로 출력해야 하기 때문에 취소
                // 리스트 맨 마지막 줄에서 0번째까지 출력하기
                for (int i = motivList.size() - 1; i >= 0; i--) {
                    // 클래스 객체에서 = 배열에 있는 i번째 변수 꺼내오기
                    MotivAdd motivInfo = motivList.get(i);

                    // 만약 source 길이가 너무 길면 0번째에서 5번째까지 줄이기
                    if (motivInfo.getSource().length() > 5 && motivInfo.getMotivation().length() > 9) {
                        System.out.printf("%d     /     %s     /     %s     \n", motivInfo.getId(), motivInfo.getSource().substring(0, 5)+"..", motivInfo.getMotivation().substring(0, 9)+"..");
                    } else {
                        System.out.printf("%d     /     %s     /     %s     \n", motivInfo.getId(), motivInfo.getSource(), motivInfo.getMotivation());
                    }
                    // 배열이름.배열 내 변수 이름 이었지만
                    //getter 메서드를 꺼내오는 거니까 메서드실행() 형식으로
                }

                System.out.println("=".repeat(50));
            }
            // 명령어 외 일괄
            else {
                System.out.println("[사용 가능 명령어]\n1. add (추가하기)\n2. list (목록조회)\n3. exit (종료하기)");
            }
        }
    }
}


// 입력된 정보를 저장할 객체를 만드는 클래스
class MotivAdd {
    // 여기서 만드는 객체 이름은 motivInfo

    // 필드로서 객체 내부에 인스턴스 변수로 사용
    private int id;
    private String motivation;
    private String source;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    // 생성자 : 입력된 값을 자동으로 규칙에 맞게 추가해준다
    public MotivAdd(int id, String motivation, String source) {
        this.id = id;
        this.motivation = motivation;
        this.source = source;
    }

    // 오버라이드, 객체 내부정보를 String 으로 변환
    @Override
    public String toString() {
        return "MotivAdd{" +
                "id=" + id +
                ", motivation='" + motivation + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}