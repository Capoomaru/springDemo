package com.delisting.demo.config.auth.dto;

import com.delisting.demo.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickName;
    private String user_id;

    public SessionUser(User user) {
        this.nickName = user.getNickname();
        this.user_id = user.getUserId();
    }
}
