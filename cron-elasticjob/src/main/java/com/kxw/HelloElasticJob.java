package com.kxw;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Hello world!
 */
public class HelloElasticJob implements SimpleJob {

    public static void main(String[] args) {
        JobCoreConfiguration simpleJobCoreConfig = JobCoreConfiguration.newBuilder("HelloElasticJob", "*/1 * * * * ?", 1).build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleJobCoreConfig, HelloElasticJob.class.getCanonicalName());
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        new JobScheduler(createRegistryCenter(), simpleJobRootConfig).init();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181", "elastic-job-demo"));
        regCenter.init();
        return regCenter;
    }

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(shardingContext);
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " " + HelloElasticJob.class.getCanonicalName());
    }
}
