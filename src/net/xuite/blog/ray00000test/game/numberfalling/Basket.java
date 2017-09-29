package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Graphics;

/**
 * 接數字的盤子
 * 
 * @author Ray
 * 
 */
public class Basket extends RoleBase {
	public Basket() {
	}

	@Override
	public void changeObj() {
	}

	@Override
	public void process() {
	}

	@Override
	public void onDraw(Graphics g) {
		g.fillRect(getX(), getY(), getW(), getH());		
	}

	@Override
	public int getId() {
		return GameConfig.ID_BASKET;
	}
}