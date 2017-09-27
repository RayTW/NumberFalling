package net.xuite.blog.ray00000test.game.numberfalling;

/**
 * 
 * @author Ray Lee
 * 
 */
public enum GameEvent {
	POP_NUMBER("pop_number");

	private final String mValue;

	private GameEvent(String s) {
		mValue = s;
	}

	@Override
	public String toString() {
		return mValue;
	}
}
