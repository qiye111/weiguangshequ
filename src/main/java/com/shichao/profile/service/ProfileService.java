package com.shichao.profile.service;

import com.shichao.profile.api.dto.ProfilePatchRequest;
import com.shichao.profile.api.dto.ProfileResponse;
import com.shichao.user.domain.User;

import java.util.Optional;

/**
 * 个人资料业务接口。
 */
public interface ProfileService {

    Optional<User> getById(long userId);

    ProfileResponse updateProfile(long userId, ProfilePatchRequest req);

    ProfileResponse updateAvatar(long userId, String avatarUrl);
}