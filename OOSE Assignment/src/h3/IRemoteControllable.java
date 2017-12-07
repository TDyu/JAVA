package h3;

/**
 * 負責定義遙控器通用的四個動作: on, off, up, down
 */
public interface IRemoteControllable {

	/**
	 * power on
	 * @return state
	 */
	String on();
	
	/**
	 * power off
	 * @return state
	 */
	String off();
	
	/**
	 * increase some value
	 * @return state
	 */
	String up();
	
	/**
	 * decrease some value
	 * @return state
	 */
	String down();
}
