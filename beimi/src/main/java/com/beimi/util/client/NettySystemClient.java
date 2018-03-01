package com.beimi.util.client;

import java.util.HashMap;
import java.util.Map;

import com.beimi.util.server.handler.BeiMiClient;

public class NettySystemClient implements NettyClient{
	
	private Map<String, BeiMiClient> systemClientsMap = new HashMap<String,BeiMiClient>();
	
	public BeiMiClient getClient(String key){
		return  systemClientsMap.get(key);
	}
	
	public void putClient(String userid , BeiMiClient client){
		systemClientsMap.put(userid, client) ;
		systemClientsMap.put(client.getSession(), client) ;
	}
	
	public void removeClient(String id){
		BeiMiClient beiMiClient = this.getClient(id) ;
		systemClientsMap.remove(id) ;
		if(beiMiClient!=null){
			systemClientsMap.remove(beiMiClient.getUserid()) ;
		}
	}

	public void joinRoom(String userid, String roomid) {
		BeiMiClient beiMiClient = this.getClient(userid) ;
		if(beiMiClient!=null){
			beiMiClient.getClient().joinRoom(roomid);
		}
	}

	public void sendGameEventMessage(String userid, String event, Object data) {
		BeiMiClient beiMiClient = this.getClient(userid) ;
		if(beiMiClient!=null){
			beiMiClient.getClient().sendEvent(event, data);
		}
	}
}
