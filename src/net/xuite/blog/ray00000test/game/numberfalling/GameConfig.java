package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Color;

/**
 * 存放不同角色id，用於辨識物件角色種類
 * @author Ray Lee 
 * Created on 2017/09/29
 */
public interface GameConfig {
	public final static int ID_BASKET = 10;
	public final static int ID_NUMBER_FALLING_NPC = 20;
	public final static int ID_NUMBER_OBJECT = 30;
	
	//NumberObject 需要經過幾個fps才處理一次邏輯
	public final static int PROCESS_COUNT_DEFAULT = 2;
	
	//NumberObject噴發出去拋物線的距離
	public final static int NUMBER_OBJECT_VELOCITY_X_DEFAULT = 15;
	
	//NumberObject會變的顏色
	public final static Color [] NUMBER_OBJECT_COLORS = {Color.DARK_GRAY, Color.PINK,Color.BLUE,Color.CYAN,Color.GREEN};

	//NumberObject掉落的速度將會是MIN + random(Max)
	public final static int NUMBER_FALLING_TIME_BASIC_MIN_DEFAULT = 1;
	public final static int NUMBER_FALLING_TIME_RANDOM_MAX_DEFAULT = 5;
}
