package h3;

public class AirConditioner implements IRemoteControllable {
	
	/* state of air conditioner */
	private String state = "OFF";
	/* current temperature. default temperature is 25°C */
	private int temperature = 25;
	
	/**
	 * set state
	 * @param isOn
	 * @param temperature
	 */
	private void setState(boolean isOn, String temperature) {
		// if isOn is false
		if (!isOn) {
			this.state = "OFF";
		} else {
			this.state = "NOW °C:\n" + temperature + "°C";
		}
	}

	/**
	 * power on
	 * default: 25°C
	 * @return state
	 */
	@Override
	public String on() {
		setState(true, Integer.toString(temperature));
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
	 * increase temperature
	 * range: [20, 30]
	 * @return state
	 */
	@Override
	public String up() {
		// if current temperature < 30 and state is not OFF, it can increase the temperature.
		if (temperature < 30 && !state.equals("OFF")) {
			temperature++;
			setState(true, Integer.toString(temperature));
			showState();
		}
		return state;
	}

	/**
	 * decrease temperature
	 * range: [20, 30]
	 * @return state
	 */
	@Override
	public String down() {
		// if current temperature > 20 and state is not OFF, it can decrease the temperature.
		if (temperature > 20 && !state.equals("OFF")) {
			temperature--;
			setState(true, Integer.toString(temperature));
			showState();
		}
		return state;
	}

	/**
	 * show now state of air conditioner
	 */
	public void showState() {
		System.out.println(this.state);
	}
	
}
