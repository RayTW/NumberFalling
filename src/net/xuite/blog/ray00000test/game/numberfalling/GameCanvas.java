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
	private List<RoleBase> mObjs;
	private NumberFallingNPC mNpc; // 丟數字的npc
	private Basket mBasket; // 接方塊的籃子
	private int mScore; // 吃到的數字個數

	public GameCanvas() {
		inititalize();
	}

	public void inititalize() {
		mObjs = Collections.synchronizedList(new ArrayList<RoleBase>());

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
	public void addPaintObj(RoleBase obj) {
		mObjs.add(obj);
	}

	@Override
	public void paintCanvas(Graphics g) {
		for (int i = mObjs.size() - 1; i >= 0; i--) {
			RoleBase obj = mObjs.get(i);
			obj.countdown();
			obj.onDraw(g);
			hitTestBasket(obj, mBasket);
		}
		
		// 畫上吃到的數字總分
		g.drawString("Score:" + mScore, 0, 280);
		
		clearUnaliveRoles();
	}
	
	private void hitTestBasket(RoleBase obj, RoleBase basket){
		if(obj.getId() == GameConfig.ID_NUMBER_OBJECT){
			// 判斷數字是否碰到籃子
			if (obj.hitTest(basket)) {
				obj.release();
				mScore += obj.getScore();// 加上吃到的數字分數
				return;
			}

			if (getY() >= 320) {
				obj.release();
			}
		}
	}
	
	//清除不應存在畫面上的角色物件
	private void clearUnaliveRoles(){
		RoleBase obj = null;
		
		for (int i = mObjs.size() - 1; i >= 0; i--) {
			obj = mObjs.get(i);
			
			if(!obj.isAlive()){
				mObjs.remove(i);
			}
		}
	}

	@Override
	public void onEvent(GameEvent event, Object data) {
		if (event == GameEvent.POP_NUMBER) {
			NumberObject f = new NumberObject();
			f.setPaintCountdown(5);// 設定畫5次就變一次顏色
			f.setX(mNpc.getX());
			f.setW(25);
			f.setH(25);
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