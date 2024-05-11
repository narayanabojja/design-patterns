package behavioural;

/**
 * The Command Pattern is a behavioral design pattern that encapsulates a
 * request as an object, thereby allowing parameterization of clients with
 * queues, requests, and operations. It allows the parameterization of objects
 * with operations so that you can queue them, send them over the network, log
 * them, etc. Imagine you have a remote control for a light bulb. Normally, when
 * you press a button on the remote, the light turns on or off. Now, think about
 * how the remote control works behind the scenes.
 * 
 */
//Command interface
interface Command {
	void execute();
}

//Receiver class
class Light {
	public void turnOn() {
		System.out.println("Light is on");
	}

	public void turnOff() {
		System.out.println("Light is off");
	}
}

//Concrete command classes
class TurnOnCommand implements Command {
	private Light light;

	public TurnOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}
}

class TurnOffCommand implements Command {
	private Light light;

	public TurnOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
}

//Invoker class
class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}

public class CommandPatternExample {
	public static void main(String[] args) {
		// Create receiver
		Light light = new Light();

		// Create concrete command objects
		Command turnOnCommand = new TurnOnCommand(light);
		Command turnOffCommand = new TurnOffCommand(light);

		// Create invoker
		RemoteControl remoteControl = new RemoteControl();

		// Set and execute turn on command
		remoteControl.setCommand(turnOnCommand);
		remoteControl.pressButton();
		// Output: Light is on

		// Set and execute turn off command
		remoteControl.setCommand(turnOffCommand);
		remoteControl.pressButton();
		// Output: Light is off
	}
}
