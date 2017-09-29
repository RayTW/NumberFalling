package net.xuite.blog.ray00000test.game.numberfalling;

/**
 * 
 * @author Ray Lee
 * 
 */
public enum GameEvent {
	POP_NUMBER("popNumber"),
	NPC_OUT_RIGHT("npcOutRight"),
	NPC_OUT_LEFT("npcOutLEFT");

	private final String mValue;

	private GameEvent(String s) {
		mValue = s;
	}

	@Override
	public String toString() {
		return mValue;
	}
}
