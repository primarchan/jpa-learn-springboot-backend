package com.example.jpalearnproject.security.service;

import com.example.jpalearnproject.security.auth.MyUserDetail;
import com.example.jpalearnproject.security.entity.User;
import com.example.jpalearnproject.security.repository.ExRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExService implements UserDetailsService {

    private final ExRepository exRepository;

    @Transactional
    public void joinUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        exRepository.save(user);
    }

    /**
     * DB에서 계정 정보를 불러오는 메서드 -> 로그인을 시도했을 때 실행
     * @param email -> loginForm에서 입력 받은 email
     * @return User Entity 객체를 가져와 MyUserDetail 객체 반환
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = exRepository.findUserByEmail(email);
        return new MyUserDetail(user);
    }
}
