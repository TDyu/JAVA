package h3;

public class TV implements IRemoteControllable {
	
	/* state of TV */
	private String state = "OFF";
	/* current channel of TV. default channel is 7 */
	private int channel = 7;

	/**
	 * set state
	 * @param isOn
	 * @param channel
	 */
	private void setState(boolean isOn, String channel) {
		// if isOn is false
		if (!isOn) {
			this.state = "OFF";
		} else {
			this.state = "NOW CHANNEL:\n" + channel;
		}
	}
	
	/**
	 * power on
	 * default: channel 7
	 * @return state
	 */
	@Override
	public String on() {
		setState(true, Integer.toString(channel));
		showState();
		return state;
	}

	/**
	 * power off
	 * @return state
	 */
	@Override
	public String off() {
		setState(false, "");
		showState();
		return state;
	}

	/**
	 * next channel
	 * range: [1, 15]
	 * @return state
	 */
	@Override
	public String up() {
		// if current channel < 15 and state is not OFF, it can go to next channel.
		if (channel < 15 && !state.equals("OFF")) {
			channel++;
			setState(true, Integer.toString(channel));
			showState();
		}
		return state;
	}

	/**
	 * previous channel
	 * range: [1, 15]
	 * @return state
	 */
	@Override
	public String down() {
		// if current channel > 1 and state is not OFF, it can go to previous channel.
		if (channel > 1 && !state.equals("OFF")) {
			channel--;
			setState(true, Integer.toString(channel));
			showState();
		}
		return state;
	}
	
	/**
	 * show now state of TV
	 */
	public void showState() {
		System.out.println(this.state);
	}

}
