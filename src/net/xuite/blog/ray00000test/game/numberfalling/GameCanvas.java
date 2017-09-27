package net.xuite.blog.ray00000test.game.numberfalling;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.xuite.blog.ray00000test.game.canvas.CanvasDoulbebufferBase;
import net.xuite.blog.ray00000test.game.event.OnEventListener;

/**
 * 畫整個畫面的畫布
 * 
 * @author Ray
 * 
 */
public class GameCanvas extends CanvasDoulbebufferBase implements
		OnEventListener<GameEvent> {
	private static final long serialVersionUID = 8209868821288883028L;
	private List<PaintObjBase> mObjs;
	private NumberFallingNPC mNpc; // 丟數字的npc
	private Basket mBasket; // 接方塊的籃子
	private int mScore; // 吃到的數字個數

	public GameCanvas() {
		inititalize();
	}

	public void inititalize() {
		mObjs = Collections.synchronizedList(new ArrayList<PaintObjBase>());

		mBasket = new Basket();
		mBasket.setParent(this);
		mBasket.setBounds(0, 250, 30, 8);

		addPaintObj(mBasket);

		mNpc = new NumberFallingNPC();
		mNpc.setParent(this);
		mNpc.setBounds(0, 0, 30, 30);
		mNpc.setMovePix(3);// 設定npc移動的間隔
		addPaintObj(mNpc);

		mScore = 0;
	}

	/**
	 * 放入要被繪到畫布上的物件
	 * 
	 * @param obj
	 */
	public void addPaintObj(PaintObjBase obj) {
		mObjs.add(obj);
	}

	@Override
	public void paintCanvas(Graphics g) {
		for (int i = mObjs.size() - 1; i >= 0; i--) {
			PaintObjBase obj = mObjs.get(i);
			obj.countdown();

			// 畫數字
			if (obj instanceof NumberObject) {
				NumberObject fruit = (NumberObject) obj;

				g.setColor(fruit.getColor());
				g.drawString(String.valueOf(fruit.getScore()), fruit.getX(),
						fruit.getY());// 畫出數字分數
				g.setColor(Color.BLACK);
				// 判斷數字是否碰到籃子
				if (fruit.hitTest(mBasket)) {
					mObjs.remove(i);
					fruit.close();
					// System.out.println("吃到數字");
					mScore += fruit.getScore();// 加上吃到的數字分數
					continue;
				}

				if (fruit.getY() >= 320) {
					mObjs.remove(i);
					fruit.close();
				}

			} else if (obj instanceof Basket) { // 畫籃子
				Basket b = (Basket) obj;
				g.fillRect(b.getX(), b.getY(), b.getW(), b.getH());
			} else if (obj instanceof NumberFallingNPC) {// 畫丟數字npc
				NumberFallingNPC b = (NumberFallingNPC) obj;
				g.fillRect(b.getX(), b.getY(), b.getW(), b.getH());
			}
		}

		// 畫上吃到的數字總分
		g.drawString("總分:" + mScore, 0, 280);
	}

	@Override
	public void onEvent(GameEvent event, Object data) {
		if (event == GameEvent.POP_NUMBER) {
			NumberObject f = new NumberObject();
			f.setPaintCountdown(5);// 設定畫5次就變一次顏色
			f.setX(mNpc.getX());
			f.setW(10);
			f.setH(10);
			f.randScore();

			addPaintObj(f);
			return;
		}
	}

	/**
	 * 設定滑鼠移動時，籃子的x位置跟著變
	 * 
	 * @param x
	 */
	public void setMouseMoveBasketX(int x) {
		mBasket.setX(x);
	}

}