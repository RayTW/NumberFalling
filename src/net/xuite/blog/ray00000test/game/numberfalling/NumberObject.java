package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 掉落的數字物件
 * 
 * @author Ray
 * 
 */
public class NumberObject extends RoleBase {
	private int mColorFlag;
	private Color mColor;
	private int mScore; // 數字的分數
	private int mProcessCount;
	

	public NumberObject() {
		inititalize();
	}

	public void inititalize() {
		mColorFlag = (int)(Math.random() * GameConfig.NUMBER_OBJECT_COLORS.length);
		mProcessCount = GameConfig.PROCESS_COUNT_DEFAULT;
	}

	@Override
	public void changeObj() {
		// 原本留著要畫動畫，目前拿字體顏色做變化
		mColor = GameConfig.NUMBER_OBJECT_COLORS[mColorFlag];
		mColorFlag++;
		
		if(mColorFlag > GameConfig.NUMBER_OBJECT_COLORS.length - 1){
			mColorFlag = 0;
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
		mProcessCount--;
		if(mProcessCount <= 0){
			mProcessCount = GameConfig.PROCESS_COUNT_DEFAULT;
			setX(getX() + mVelocityX);
			mVelocityY += mAccelerationY; 
			setY(getY()+ mVelocityY);
		}
	}

	public Color getColor() {
		return mColor;
	}

	@Override
	public int getScore() {
		return mScore;
	}

	@Override
	public void onDraw(Graphics g) {
		g.setColor(getColor());
		g.fillArc(getX(), getY(), getW(), getH(),0,360);
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(getScore()), getX() + (getW() / 2),
				getY() + (int)( (((getH() * 1.0)  / 1.4) * 10)) / 10);// 畫出數字分數
	}

	@Override
	public int getId() {
		return GameConfig.ID_NUMBER_OBJECT;
	}
}