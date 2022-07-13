package com.delisting.demo.domain.user;

import com.delisting.demo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, name = "user_id")
    private String userId;

    @Column(length = 30, nullable = false)
    private String password="0000";

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Provider provider;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(nullable = true)
    private float hit_rate = 0;

    @Column(nullable = false)
    private boolean is_admin = false;

    @Builder
    public User(String userId, String password, Provider provider, String nickname) {
        this.userId = userId;
        this.password = password;
        this.provider = provider;
        this.nickname = nickname;
    }

    public User update(String nickname) {
        this.nickname = nickname;

        return this;
    }

    public String getProviderKey() {
        return this.provider.getProvider();
    }
}
