package com.example.jpalearnproject.dto.member;

import com.example.jpalearnproject.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long memberSeqNo;

    private String email;

    private String password;

    private String memberName;

    private String regDate;

    private String modifyDate;

    /* DTO -> Entity */
    public Member toEntity() {
        Member member = Member.builder()
                .email(email)
                .password(password)
                .memberName(memberName)
                .regDate(regDate)
                .modifyDate(modifyDate).build();

        return member;
    }

}
