package com.beimi.core;

import org.springframework.context.ApplicationContext;
import java.util.*;
import com.beimi.core.engine.game.GameEngine;

public class BMDataContext {
	public static final String USER_SESSION_NAME = "user";
	public static final String GUEST_USER = "guest";
	public static final String IM_USER_SESSION_NAME = "im_user";
	public static final String GUEST_USER_ID_CODE = "BEIMIGUESTUSEKEY" ;
	public static final String SERVICE_QUENE_NULL_STR = "service_quene_null" ;
	public static final String DEFAULT_TYPE = "default"	;		//默认分类代码
	public static final String BEIMI_SYSTEM_DIC = "com.dic.system.template";
	public static final String BEIMI_SYSTEM_GAME_TYPE_DIC = "com.dic.game.type";
	public static final String BEIMI_SYSTEM_GAME_SCENE_DIC = "com.dic.scene.item";

	public static final String BEIMI_SYSTEM_GAME_CARDTYPE_DIC = "com.dic.game.dizhu.cardtype";

	public static final String BEIMI_SYSTEM_GAME_ROOMTITLE_DIC = "com.dic.game.room.title";
	
	public static final String BEIMI_MESSAGE_EVENT = "command" ;
	public static final String BEIMI_PLAYERS_EVENT = "players" ;
	
	public static final String BEIMI_GAMESTATUS_EVENT = "gamestatus" ;
	
	public static final String BEIMI_SEARCHROOM_EVENT = "searchroom" ;
	
	public static final String BEIMI_GAME_PLAYWAY = "game_playway";
	
	public static final String BEIMI_SYSTEM_AUTH_DIC = "com.dic.auth.resource";

	public static final String BEIMI_SYSTEM_ROOM = "room" ;
	
	
	public static String SYSTEM_ORGI = "beimi" ;
	
	private static int WebIMPort = 9081 ;
	
	private static boolean imServerRunning = false ;			//IM服务状态
	
	private static ApplicationContext applicationContext ;

	public static Map<String , Boolean> model = new HashMap<String,Boolean>();
	
	
	private static GameEngine gameEngine ;
	
	public static int getWebIMPort() {
		return WebIMPort;
	}

	public static void setWebIMPort(int webIMPort) {
		WebIMPort = webIMPort;
	}
	
	public static void setApplicationContext(ApplicationContext context){
		applicationContext = context ;
	}
	
	public static void setGameEngine(GameEngine engine){
		gameEngine = engine ;
	}
	
	/**
	 * 根据ORGI找到对应 游戏配置
	 * @param orgi
	 * @return
	 */
	public static String getGameAccountConfig(String orgi){
		return BMDataContext.ConfigNames.ACCOUNTCONFIG.toString()+"_"+orgi ;
	}
	
	/**
	 * 根据ORGI找到对应 游戏配置
	 * @param orgi
	 * @return
	 */
	public static String getGameConfig(String orgi){
		return BMDataContext.ConfigNames.GAMECONFIG.toString()+"_"+orgi ;
	}
	
	/**
	 * 根据ORGI找到对应 游戏配置
	 * @param orgi
	 * @return
	 */
	public static String getGameAiConfig(String orgi){
		return BMDataContext.ConfigNames.AICONFIG.toString()+"_"+orgi ;
	}
	
	
	public static ApplicationContext getContext(){
		return applicationContext ;
	}
	
	public static GameEngine getGameEngine(){
		return gameEngine; 
	}
	/**
	 * 系统级的加密密码 ， 从CA获取
	 * @return
	 */
	public static String getSystemSecrityPassword(){
		return "BEIMI" ;
	}
	
	public enum NameSpaceEnum{
		
		SYSTEM("/bm/system") ,
		GAME("/bm/game");
		
		private String namespace ;
		
		public String getNamespace() {
			return namespace;
		}

		public void setNamespace(String namespace) {
			this.namespace = namespace;
		}

		NameSpaceEnum(String namespace){
			this.namespace = namespace ;
		}
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum ModelType{
		ROOM,
		HALL;
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum ConfigNames{
		GAMECONFIG,
		AICONFIG,
		ACCOUNTCONFIG,
		PLAYWAYCONFIG,
		PLAYWAYGROUP,
		PLAYWAYGROUPITEM;
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum UserDataEventType{
		SAVE,UPDATE,DELETE;
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum PlayerAction{
		GANG,
		PENG,
		HU,
		CHI,
		GUO;
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum PlayerGangAction{
		MING,		//明杠
		AN,			//暗杠
		WAN;		//弯杠
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum GameTypeEnum{
		MAJIANG,
		DIZHU,
		DEZHOU;
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum PlayerTypeEnum{
		AI,			//AI
		NORMAL,		//普通玩家
		OFFLINE,	//托管玩家
		LEAVE;		//离开房间的玩家
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum GameStatusEnum{
		READY,			//AI
		NOTREADY,		//普通玩家
		MANAGED,
		PLAYING,
		TIMEOUT;		//登录会话过期
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum CardsTypeEnum{
		ONE(1),		//单张      3~K,A,2
		TWO(2),		//一对	 3~K,A,2
		THREE(3),	//三张	 3~K,A,2
		FOUR(4),	//三带一	 AAA+K
		FORMTWO(41),	//三带对	 AAA+K
		FIVE(5),	//单顺	连子		10JQKA
		SIX(6),		//双顺	连对		JJQQKK
		SEVEN(7),	//三顺	飞机		JJJQQQ
		EIGHT(8),	//飞机	带翅膀	JJJ+QQQ+K+A
		EIGHTONE(81),	//飞机	带翅膀	JJJ+QQQ+KK+AA
		NINE(9),	//四带二			JJJJ+Q+K
		NINEONE(91),	//四带二对			JJJJ+QQ+KK
		TEN(10),	//炸弹			JJJJ
		ELEVEN(11);	//王炸			0+0
		
		private int type ;
		
		CardsTypeEnum(int type){
			this.type = type ;
		} 
		

		public int getType() {
			return type;
		}


		public void setType(int type) {
			this.type = type;
		}
	}
	
	public enum MessageTypeEnum{
		JOINROOM,
		MESSAGE, 
		END,
		TRANS, STATUS , AGENTSTATUS , SERVICE, WRITING;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum SearchRoomResultType{
		NOTEXIST,  //房间不存在
		FULL, 		//房间已满员
		OK,			//加入成功
		DISABLE,	//房间启用了 禁止非邀请加入
		INVALID;	//房主已离开房间
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum MaJiangWinType{
		TUI,
		RIVER,
		END,
		LOST;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum PVActionEnum{
		INCOME,	//
		CONSUME,
		EXCHANGE,
		VERIFY;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	public enum PVAStatusEnum{
		OK,
		NOTENOUGH,
		FAILD,
		NOTEXIST,
		INVALID;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	/**
	 * 收入类型 ， 1、充值，2、兑换、3、赢了，4、赠送，5、抽奖，6、接受赠与
	 */
	public enum PVAInComeActionEnum{
		RECHARGE,
		EXCHANGE,
		WIN,
		WELFARE,
		PRIZE,
		GIFT;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}
	
	/**
	 *  支出 1、输了，2、逃跑扣除、3、兑换扣除，4、送好友
	 */
	public enum PVAConsumeActionEnum{
		LOST,
		ESCAPE,
		DEDUCTION,
		SEND;
		
		public String toString(){
			return super.toString().toLowerCase() ;
		}
	}


	public static void setIMServerStatus(boolean running){
		imServerRunning = running ;
	}
	public static boolean getIMServerStatus(){
		return imServerRunning;
	}
	
}
