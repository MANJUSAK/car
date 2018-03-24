package com.dhcc.car.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * description:
 * ===>redis配置类
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-01-29 14:06
 * @version V1.1.0
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.pool.max-active}")
    private int redisMaxActive;
    @Value("${spring.redis.pool.max-wait}")
    private int redisMazWait;
    @Value("${spring.redis.pool.max-idle}")
    private int redisMaxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private int redisMinIdle;
    @Value("${spring.redis.sentinel.nodes}")
    private String redisNodes;
    @Value("${spring.redis.sentinel.master}")
    private String master;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * redis哨兵配置
     *
     * @return <code>RedisSentinelConfiguration</code>
     */
    //@Bean
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        this.LOG.info("car start inited redisSentinel");
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = redisNodes.split(",");
        for (String redisHost : host) {
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));

        }
        configuration.setMaster(master);
        return configuration;
    }

    /**
     * 连接redis的工厂类
     *
     * @return <code>JedisConnectionFactory</code>
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        this.LOG.info("car start inited redisConnectionFactory");
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(redisMaxIdle);
        jpc.setMinIdle(redisMinIdle);
        jpc.setMaxWaitMillis(redisMazWait);
        jpc.setTestOnBorrow(true);
        jpc.setMaxTotal(redisMaxActive);
        JedisConnectionFactory factory = new JedisConnectionFactory(/*redisSentinelConfiguration()*/);
        factory.setHostName(host);
        factory.setPort(port);
        factory.setTimeout(timeout);
        factory.setPassword(password);
        factory.setDatabase(database);
        factory.setPoolConfig(jpc);
        return factory;
    }

    /**
     * 配置RedisTemplate
     * 设置添加序列化器
     * key 使用string序列化器
     * value 使用Json序列化器
     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
     *
     * @return <code>RedisTemplate</code>
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        this.LOG.info("car start inited redisTemplate");
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //设置开启事务
        template.setEnableTransactionSupport(true);
        //set key serializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setConnectionFactory(jedisConnectionFactory());
        template.afterPropertiesSet();
        return template;
    }
}
