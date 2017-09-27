package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Main 主程式，產生視窗
 * 
 * @author Ray
 * 
 */
public class NumberFallingGame extends JFrame implements MouseMotionListener {
	private static final long serialVersionUID = -8938684854250807158L;
	private GameCanvas mFruitCanvas;

	public NumberFallingGame() {
		inititalize();
	}

	public void inititalize() {
		mFruitCanvas = new GameCanvas();
		mFruitCanvas.setFPS(60);
		addCanvas(mFruitCanvas);

		mFruitCanvas.startPaint();

		mFruitCanvas.addMouseMotionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void addCanvas(Canvas c) {
		getContentPane().add(c);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mFruitCanvas.setMouseMoveBasketX(arg0.getX());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberFallingGame game = new NumberFallingGame();
		game.setBounds(100, 100, 530, 320);
		game.setVisible(true);
	}
}