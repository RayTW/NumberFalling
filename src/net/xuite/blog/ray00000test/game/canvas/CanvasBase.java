package net.xuite.blog.ray00000test.game.canvas;

import java.awt.Canvas;

/**
 * 繪圖
 * 
 * @author Ray
 * 
 */
public abstract class CanvasBase extends Canvas implements Runnable {
	private static final long serialVersionUID = 6207860676509306398L;
	private boolean mIsRun;
	private boolean mIsPause;
	private int mFps; // 每秒要畫幾次

	public CanvasBase() {
		mIsRun = false;
		mIsPause = false;
		mFps = 30;
		CanvasBaseInit();
	}

	public void CanvasBaseInit() {

	}

	/**
	 * 開始繪圖
	 */
	public void startPaint() {
		if (!mIsRun) {
			mIsRun = true;
			new Thread(this).start();
		}
	}

	/**
	 * 結束繪圖
	 */
	public void stopPaint() {
		mIsRun = false;
	}

	/**
	 * 暫停繪圖
	 */
	public void pause() {
		mIsPause = true;
	}

	/**
	 * 繼續繪圖
	 */
	public void resume() {
		mIsPause = false;
	}

	/**
	 * 設定1秒要畫幾次
	 * 
	 * @param n
	 */
	public void setFPS(int n) {
		mFps = n;
	}

	/**
	 * 取得目前1秒畫幾次
	 * 
	 * @return
	 */
	public int getFPS() {
		return mFps;
	}

	/**
	 * 取得目前是否暫停中
	 * 
	 * @return
	 */
	public boolean isPause() {
		return mIsPause;
	}

	@Override
	public void run() {
		while (mIsRun) {

			if (!mIsPause) {
				repaint();// 子類別繼承後需要覆寫paint()或update();
			}
			int sec = (int) ((10.0 / mFps) * 100);

			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}