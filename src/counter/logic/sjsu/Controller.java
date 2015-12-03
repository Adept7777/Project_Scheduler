package counter.logic.sjsu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class which controls all operations between the UI and the file system for the application, need to have a Controller in 
 * the main UI runner class, which will use the Controller's ArrayList and the Controller's methods to save and load.
 */
public class Controller {
	public ArrayList<Event> events; // Used to store all the events in the scheduler while the program is running
	private final FileAccess fileAccess; // Used to manage file IO

	/**
	 * Constructor which sets the ArrayList to an empty ArrayList and sets the FileAccess to work with the specified file.
	 * @param file the file that fileAccess will work with
	 */
	public Controller(File file) {
		this.events = new ArrayList<>();
		this.fileAccess = new FileAccess(file);
	}

	/**
	 * Simple constructor which also sets the ArrayList to an empty one, but sets the FileAccess to the default file.
	 */
	public Controller() {
		this.events = new ArrayList<>();
		this.fileAccess = new FileAccess();
	}

	/**
	 * Loads all the Events from the file into the ArrayList.
	 */
	public void retrieveData() {
		for (Event event : this.fileAccess.load()) {
			this.events.add(event);
		}
	}

	/**
	 * Saves all the events currently in the ArrayList to the file.
	 */
	public void storeData() {
		this.clearData();
		this.fileAccess.save(this.events);
	}

	/**
	 * Clears all the text from the file the Controller is working with.
	 */
	public void clearData() {
		this.fileAccess.clear();
	}

	/**
	 * Method to simply make adding events easier, instead of having to use Controller.events.add.
	 * @param event the event to add
	 */
	public void addEvent(Event event) {
		this.events.add(event);
	}

	/**
	 * Method to make removing events easier, rather than accessing the ArrayList directly.
	 * @param index the index of the ArrayList to be removed
	 */
	public void removeEvent(int index) {
		this.events.remove(index);
	}
}
