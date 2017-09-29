package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Graphics;

/**
 * 丟出數字，在最上面移動的npc
 * 
 * @author Ray
 * 
 */
public class NumberFallingNPC extends RoleBase {
	private boolean mMoveRight; // 記錄目前是否右移中,true:右移,false:左移
	private int mMovePix; // 移動的畫素(盡量不設定此變數，否則會npc移動會跳格)
	private int mNumberFallingTime;// 下次丟數字的時間

	public NumberFallingNPC() {
		mMoveRight = true;
		mMovePix = 1;
	}

	@Override
	public void changeObj() {

	}

	@Override
	public void process() {
		if (mMoveRight) {
			setX(getX() + mMovePix);
			if (getX() >= 480) {
				mMoveRight = false;
				notifyEvent(GameEvent.NPC_OUT_RIGHT, null);
			}
		} else {
			setX(getX() - mMovePix);
			if (getX() <= 0) {
				mMoveRight = true;
				notifyEvent(GameEvent.NPC_OUT_LEFT, null);
			}
		}

		mNumberFallingTime--;
		if (mNumberFallingTime <= 0) {
			mNumberFallingTime = (int) (Math.random() * GameConfig.NUMBER_FALLING_TIME_RANDOM_MAX_DEFAULT)
					+ GameConfig.NUMBER_FALLING_TIME_BASIC_MIN_DEFAULT;// npc下次丟出數字的間隔時間
			notifyEvent(GameEvent.POP_NUMBER, null);// 通知上層產生數字物件
		}
	}

	public void setMovePix(int pix) {
		mMovePix = pix;
	}

	@Override
	public void onDraw(Graphics g) {
		g.fillRect(getX(), getY(), getW(), getH() / 2);	
	}

	@Override
	public int getId() {
		return GameConfig.ID_NUMBER_FALLING_NPC;
	}
}
