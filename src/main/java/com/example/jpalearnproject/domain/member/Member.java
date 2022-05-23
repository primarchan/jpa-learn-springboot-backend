package com.example.jpalearnproject.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@ToString
@Entity(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_SEQ_NO")
    private Long memberSeqNo;

    @NotBlank
    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotBlank
    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotBlank
    @NotEmpty
    @Column(name = "MEMBER_NAME")
    private String memberName;

    @CreatedDate
    @Column(name = "REG_DATE")
    private String regDate;

    @LastModifiedDate
    @Column(name = "MODIFY_DATE")
    private String modifyDate;

    @Builder
    public Member(String email, String password, String memberName, String regDate, String modifyDate) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
    }
}
