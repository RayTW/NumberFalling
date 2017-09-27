package net.xuite.blog.ray00000test.game.numberfalling;

import net.xuite.blog.ray00000test.game.event.OnEventListener;

/**
 * 可被拿來畫的物件
 * 
 * @author Ray
 * 
 */
public abstract class PaintObjBase {
	private OnEventListener mOnEventListener;
	// 顯示出來的範圍
	private int mX;
	private int mY;
	private int mW;
	private int mH;

	private int mPaintCount;// 此物件被繪幾次才執行本身的變動mehtod
	private int mPaintCountdown;

	public PaintObjBase() {
	}

	/**
	 * 設定上層
	 * 
	 * @param o
	 */
	public void setParent(OnEventListener o) {
		mOnEventListener = o;
	}

	/**
	 * 設定顯示的範圍,預設碰撞範圍與顯示範圍相同
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void setBounds(int x, int y, int w, int h) {
		this.mX = x;
		this.mY = y;
		this.mW = w;
		this.mH = h;
	}

	/**
	 * 對上層發事件
	 * 
	 * @param name
	 * @param data
	 */
	public void notifyEvent(GameEvent name, Object data) {
		mOnEventListener.onEvent(name, data);
	}

	public void setPaintCountdown(int c) {
		mPaintCount = c;
		mPaintCountdown = c;
	}

	public void countdown() {
		process();
		mPaintCountdown--;
		if (mPaintCountdown <= 0) {
			mPaintCountdown = mPaintCount;
			changeObj();
		}
	}

	/**
	 * 與fps相同執行次數
	 * 
	 */
	public abstract void process();

	/**
	 * 隨著設定的paintCount次數才會執行一次的mehtod
	 * 
	 */
	public abstract void changeObj();

	/**
	 * 判斷其他物件是否碰撞到目前物件
	 * 
	 * @param obj
	 * @return
	 */
	public boolean hitTest(PaintObjBase obj) {
		int hx = obj.mX;
		int hy = obj.mY;
		int hh = obj.mH;
		int hw = obj.mW;

		return ((hx + hw > mX) && (hx < mX + mW) && (hy + hh > mY) && (hy < mY
				+ mH));
	}
	
	public int getX(){
		return mX;
	}
	
	public int getY(){
		return mY;
	}
	
	public int getH(){
		return mH;
	}
	
	public int getW(){
		return mW;
	}
	
	public void setX(int x){
		mX = x;
	}
	
	public void setY(int y){
		mY = y;
	}
	
	public void setW(int w){
		mW = w;
	}
	
	public void setH(int h){
		mH = h;
	}

	public void close() {
		mOnEventListener = null;
	}
}