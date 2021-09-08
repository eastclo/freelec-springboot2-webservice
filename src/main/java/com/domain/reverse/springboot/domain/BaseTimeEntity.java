package com.domain.reverse.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 supper 클래스의 필드들도 칼럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 Auditing기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate    //Entity 생성시간이 자동 저장 됨
    private LocalDateTime createdDate;

    @LastModifiedDate   //Entity 수정 시간이 자동 저장 됨
    private LocalDateTime modifiedDate;
}
