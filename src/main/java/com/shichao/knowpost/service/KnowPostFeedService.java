package com.shichao.knowpost.service;

import com.shichao.knowpost.api.dto.FeedPageResponse;

/**
 * 知文 Feed 业务接口。
 */
public interface KnowPostFeedService {
    FeedPageResponse getPublicFeed(int page, int size, Long currentUserIdNullable);

    FeedPageResponse getMyPublished(long userId, int page, int size);

    /**
     * 失效公共 Feed 缓存（双删模式）。
     * 先立即删除，再延迟二次删除，防止并发回源时旧值回写。
     */
    void invalidatePublicFeedCache();

    /**
     * 失效指定用户的"我的 Feed"缓存（前缀批量清理）。
     * 按用户维度清理 feed:mine:{userId}:* 前缀的所有缓存。
     * @param userId 用户 ID
     */
    void invalidateMineFeedCache(long userId);

    /**
     * 重置指定缓存键的热度计数。
     * @param pageKey 缓存键
     */
    void resetHotKey(String pageKey);
}