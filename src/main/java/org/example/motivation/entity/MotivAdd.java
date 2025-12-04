package org.example.motivation.entity;


// 입력된 정보를 저장할 객체를 만드는 클래스
public class MotivAdd {
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
