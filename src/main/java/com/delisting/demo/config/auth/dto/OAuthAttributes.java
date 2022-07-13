package com.delisting.demo.config.auth.dto;

import com.delisting.demo.domain.user.Provider;
import com.delisting.demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nickNameAttributeKey;
    private String nickName;
    private String userId;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nickNameAttributeKey, String nickName, String user_id) {
        this.attributes = attributes;
        this.nickNameAttributeKey = nickNameAttributeKey;
        this.nickName = nickName;
        this.userId = user_id;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nickName((String) attributes.get("nickname"))
                .user_id((String) attributes.get("user_id"))
                .attributes(attributes)
                .nickNameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .nickname(nickName)
                .userId(userId)
                .provider(Provider.GOOGLE)
                .build();
    }
}
