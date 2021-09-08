package com.domain.reverse.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Entity 클래스에선 절대 Setter 메소드를 만들지 말것*/
@Getter
@NoArgsConstructor //기본생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함.
public class Posts {    //실제 DB테이블과 매칭될 클래스(Entity 클래스라고도 함)

    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙. 스트링부트2.0에서 GenerationType.IDENTITY를 추가해야 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언 안 해도 해당 클래스의 필드는 모두 칼럼이됨.
    private String title;                   //문자열 Default는 VARCHAR(255)이므로 사이즈를 늘리기위해 선언

    @Column(columnDefinition = "TEXT", nullable = false) //타입 변경을 위해 선언
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
