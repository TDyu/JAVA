package h3;

public class Main {

	public static void main(String[] args) {
		/* Deal with remote controller of TV */
		// new corresponding IRemoteControllable
		IRemoteControllable tv = new TV();
		// new corresponding remote controller
		RemoteController tvRemoteController = new RemoteController(tv, "TV Remote Controller");
		// turn on. should show "channel 7"
		tvRemoteController.on();
		// next channel. should show "channel 8"
		tvRemoteController.up();
		// previous channel. should show "channel 7"
		tvRemoteController.down();
		// turn off. should show "off"
		tvRemoteController.off();
		
		/* Deal with remote controller of air conditioner */
		// new corresponding IRemoteControllable
		IRemoteControllable airConditioner = new AirConditioner();
		// new corresponding remote controller
		RemoteController airConditionerRemoteController = new RemoteController(airConditioner, "Air Conditioner Remote Controller");
		// turn on. should show "25°C"
		airConditionerRemoteController.on();
		// next channel. should show "26°C"
		airConditionerRemoteController.up();
		// previous channel. should show "25°C"
		airConditionerRemoteController.down();
		// turn off. should show "off"
		airConditionerRemoteController.off();
	}

}
