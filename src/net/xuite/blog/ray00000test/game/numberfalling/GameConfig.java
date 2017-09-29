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
	
	public final static Color [] NUMBER_OBJECT_COLORS = {Color.DARK_GRAY, Color.PINK,Color.BLUE,Color.CYAN,Color.GREEN};
}
