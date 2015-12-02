package counter.logic.sjsu;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Simple class to run a test on the saving/loading using the Controller.
 */
public class BackendTester {
	/**
	 * Uses one Controller to create some random events, saves them to the default file after clearing it to ensure it's 
	 * empty, then creates another controller using the default file and loads the events into its ArrayList and ensures 
	 * they loaded properly.
	 */
	@Test
	public void saveLoadTest() {
		Controller control = new Controller();
		control.clearData();
		Event class1 = new Event("Data Structures and Algorithms", Color.RED, 9, 10, 0, 15, "Mon", "SE 146");
		Event class2 = new Event("Data Structures and Algorithms", Color.RED, 9, 10, 0, 15, "Wed", "SE 146");
		Event class3 = new Event("Assembly Language Programming", Color.BLUE, 15, 17, 0, 45, "Mon", "SE 102");
		control.addEvent(class1);
		control.addEvent(class2);
		control.addEvent(class3);
		control.storeData();
		
		Controller control2 = new Controller();
		control2.retrieveData();

		for (Event event : control2.events) {
			System.out.println(event.getName());
		}

		assertEquals(class1, control2.events.get(0));
		assertEquals(class2, control2.events.get(1));
		assertEquals(class3, control2.events.get(2));
	}
}
