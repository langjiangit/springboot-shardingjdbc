package com.xiao.web.init;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by sunjinwei on 2019/2/18.
 *
 * @author sunjinwei
 * <p>
 * 自定义分片算法
 * @See https://www.jianshu.com/p/20f2c50bf8f5
 */
@Slf4j
@Component
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        for (String tableName : availableTargetNames) {
            log.debug("### tableName:{}, shardingValue:{}", tableName, shardingValue);
            if (tableName.endsWith((shardingValue.getValue().hashCode() & 0x7FFFFFFF) % 2 + "")) {
                log.info("### result tableName:{}", tableName);
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
