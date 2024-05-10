package creational;

//Abstract factory interface
interface GUIFactory {
	
	Button createButton();
	Checkbox createCheckbox();
}

//Abstract product interface for Button
interface Button {
	void render();
}

//Abstract product interface for Checkbox
interface Checkbox {
	void render();
}

//Concrete implementation of GUIFactory for Windows
class WindowsFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}

//Concrete implementation of GUIFactory for Mac
class MacFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

//Concrete implementation of Button for Windows
class WindowsButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering a Windows button");
	}
}

//Concrete implementation of Checkbox for Windows
class WindowsCheckbox implements Checkbox {
	@Override
	public void render() {
		System.out.println("Rendering a Windows checkbox");
	}
}

//Concrete implementation of Button for Mac
class MacButton implements Button {
	@Override
	public void render() {
		System.out.println("Rendering a Mac button");
	}
}

//Concrete implementation of Checkbox for Mac
class MacCheckbox implements Checkbox {
	@Override
	public void render() {
		System.out.println("Rendering a Mac checkbox");
	}
}

public class AbstractFactoryPatternExample {

	private final GUIFactory guiFactory;
	private final Button button;
	private final Checkbox checkbox;

	public AbstractFactoryPatternExample(GUIFactory guiFactory) {
		this.guiFactory = guiFactory;
		this.button = guiFactory.createButton();
		this.checkbox = guiFactory.createCheckbox();
	}

	public void createUI() {
		button.render();
		checkbox.render();
	}

	public static void main(String[] args) {
		// Create a Windows application
		AbstractFactoryPatternExample windowsApp = new AbstractFactoryPatternExample(new WindowsFactory());
		windowsApp.createUI();

		// Create a Mac application
		AbstractFactoryPatternExample macApp = new AbstractFactoryPatternExample(new MacFactory());
		macApp.createUI();
	}

}
