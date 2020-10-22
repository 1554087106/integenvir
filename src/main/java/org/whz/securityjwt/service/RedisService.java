package org.whz.securityjwt.service;

public interface RedisService {

    void set(String key, String value);

    String get(String key);

    /**
     * 设置超时时间
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key, long delta);
}
