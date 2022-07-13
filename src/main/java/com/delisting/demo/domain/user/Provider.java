package com.delisting.demo.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Provider {
    NORMAL("NORMAL"),
    GOOGLE("GOOGLE"),
    NAVER("NAVER"),
    FACEBOOK("FACEBOOK");


    private final String provider;
}
