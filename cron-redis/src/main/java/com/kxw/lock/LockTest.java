package com.kxw.lock;

import org.redisson.Redisson;
import org.redisson.api.RExecutorService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Created by kangxiongwei on 2017/8/4 11:52.
 */
public class LockTest {

    public static void main(String[] args) {
        /**
         * 1. Create config object
         * 支持java，json，yaml，spring等配置方式
         */
        Config config = new Config();
        config.setUseLinuxNativeEpoll(true);
        config.useClusterServers().addNodeAddress("redis://127.0.0.1:7181");

        // 2. Create Redisson instance
        RedissonClient redisson = Redisson.create(config);

        // 3. Get object you need
        RMap<String, String> map = redisson.getMap("myMap");

        RLock lock = redisson.getLock("myLock");

        RExecutorService executor = redisson.getExecutorService("myExecutorService");

        // over 30 different objects and services ...
    }

}
