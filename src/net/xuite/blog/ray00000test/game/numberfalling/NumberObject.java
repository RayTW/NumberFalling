package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Color;

/**
 * 掉落的數字物件
 * 
 * @author Ray
 * 
 */
public class NumberObject extends PaintObjBase {
	private boolean mColorFlag;
	private Color mColor;
	private int mScore; // 數字的分數

	public NumberObject() {
		inititalize();
	}

	public void inititalize() {
		mColorFlag = true;
	}

	@Override
	public void changeObj() {
		// 原本留著要畫動畫，目前拿字體顏色做變化
		if (mColorFlag) {
			mColorFlag = false;
			mColor = Color.DARK_GRAY;
		} else {
			mColorFlag = true;
			mColor = Color.PINK;
		}
	}

	/**
	 * 亂數設定分數為1~10隨機
	 * 
	 */
	public void randScore() {
		mScore = (int) (Math.random() * 10) + 1;
	}

	@Override
	public void process() {
		setY(getY()+ 1);
	}

	public Color getColor() {
		return mColor;
	}

	public int getScore() {
		return mScore;
	}
}