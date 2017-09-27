package net.xuite.blog.ray00000test.game.canvas;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 實做雙重緩衝區繪圖
 * 
 * @author Ray
 * 
 */
public abstract class CanvasDoulbebufferBase extends CanvasBase {

	private static final long serialVersionUID = 6209730798488703951L;

	public CanvasDoulbebufferBase() {
	}

	/**
	 * 覆寫update是為了不讓系統自動清上次畫布的內容，覆寫paint()畫快一點會因為系統自動清畫面而一直閃爍
	 */
	@Override
	public void update(Graphics g) {
		Image img = createImage(getWidth(), getHeight());
		Graphics canvas = img.getGraphics();
		paintCanvas(canvas);

		g.drawImage(img, 0, 0, this);
	}

	/**
	 * 實際畫上圖的畫布
	 * 
	 * @param g
	 */
	public abstract void paintCanvas(Graphics g);

}