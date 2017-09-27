package net.xuite.blog.ray00000test.game.event;

/**
 * 接收下層發出的事件名稱與data
 * 
 * @author Ray
 * 
 */
public interface OnEventListener<T> {
	public void onEvent(T name, Object data);
}
