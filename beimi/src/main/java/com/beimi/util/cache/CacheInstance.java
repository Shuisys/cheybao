package com.beimi.util.cache;

import com.beimi.util.cache.hazelcast.impl.QueneCache;


public interface CacheInstance {
	
	/**
	 * 在线用户
	 * @return
	 */
	public CacheBean getOnlineCacheBean();
	
	/**
	 * 系统缓存
	 * @return
	 */
	public CacheBean getSystemCacheBean();
	
	
	/**
	 * 游戏房间
	 * @return
	 */
	public CacheBean getGameRoomCacheBean();
	
	/**
	 * 游戏数据
	 * @return
	 */
	public CacheBean getGameCacheBean();
	
	
	/**
	 * IMR指令
	 * @return
	 */
	public CacheBean getApiUserCacheBean();
	
	/**
	 * 分布式队列
	 * @return
	 */
	
	public QueneCache getQueneCache();

	public PlayerCacheBean getGamePlayerCacheBean();
	
}