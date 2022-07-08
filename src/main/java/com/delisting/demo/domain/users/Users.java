package com.delisting.demo.domain.users;

import com.delisting.demo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String user_id;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String provider;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(nullable = true)
    private float hit_rate = 0;

    @Column(nullable = false)
    private boolean is_admin = false;

    @Builder
    public Users(String user_id, String password, String provider, String nickname) {
        this.user_id = user_id;
        this.password = password;
        this.provider = provider;
        this.nickname = nickname;
    }

    public void update(String user_id, String password, String nickname) {
        this.user_id = user_id;
        this.nickname = nickname;
    }
}
