package com.tc.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import com.tc.log.Log;

/**
 * 缓存数据加载
 * 
 * @author tang
 * @version 1.0
 * @date 2016-6-24
 */
@Service("com.tc.common.CacheAutoLoad")
public class CacheAutoLoad {
	private Log log = Log.getLog(this.getClass());
	/** 全局缓存管理器 */
//    @Resource(name = "ehCacheManager")
//    private EhCacheCacheManager ehCacheManager;
    /**
     * 启动加载标签测试
     */
    @PostConstruct
    public final void autoLoad() {
    	log.debug("启动加载标签测试");
    }

    @PreDestroy  
    public void  dostory(){  
    	log.debug("注销加载标签测试");  
    } 
}
