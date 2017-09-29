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
	private int mAccelerationY = 1;    // Y方向加速度，設一個合理的數字  
	private int mVelocityY = 1;        // Y方向原始速度 隨你設 
	public static int mVelocityX = 12;       // X方向原始速度 隨你設 
	private static final int mProcessCountDefault = 2;
	private int mProcessCount = mProcessCountDefault;
	

	public NumberObject() {
		inititalize();
	}

	public void inititalize() {
		mColorFlag = 0;
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
			mProcessCount = mProcessCountDefault;
			setX(getX() + mVelocityX);
			mVelocityY += mAccelerationY; 
			setY(getY()+ mVelocityY);
		}
	}

	public Color getColor() {
		return mColor;
	}

	public int getScore() {
		return mScore;
	}

	@Override
	public void onDraw(Graphics g) {
		g.setColor(getColor());
		g.fillArc(getX(), getY(), getW(), getH(),0,360);
//		g.drawString(String.valueOf(getScore()), getX(),
//				getY());// 畫出數字分數
		g.setColor(Color.BLACK);
	}

	@Override
	public int getId() {
		return GameConfig.ID_NUMBER_OBJECT;
	}
}