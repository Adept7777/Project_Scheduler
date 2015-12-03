package counter.logic.sjsu;

import java.awt.Color;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class which handles the file input and output for saving and loading schedules into the program.
 */
public class FileAccess {
	private final File file;

	/**
	 * Constructor that takes in the file that will be written and read from.
	 * @param file the file to read and write
	 */
	public FileAccess(File file) {
		this.file = file;
	}

	/**
	 * Basic constructor which just uses a default file.
	 */
	public FileAccess() {
		this.file = new File("Default_Schedule.txt");
	}

	/**
	 * Saves all the events in the passed ArrayList to a text file, with every parameter on a new line.
	 * @param events the ArrayList of events to save
	 */
	public void save(ArrayList<Event> events) {
		try (FileWriter out = new FileWriter(this.file, true)) {
			for (Event event : events) {
				out.write(event.getName() + "\n");
				out.write(event.getColor().toString() + "\n");
				out.write(event.getStartHour() + "\n");
				out.write(event.getEndHour() + "\n");
				out.write(event.getStartMinute() + "\n");
				out.write(event.getEndMinute() + "\n");
				out.write(event.getDay() + "\n");
				out.write(event.getDescription() + "\n");
			}
		}
		catch (IOException e) {
			System.out.println("Unable to save to file: " + this.file.getPath());
		}
	}

	/**
	 * Loads any present events from the file, assumes that only event data has been written to the file, in the format that
	 * the save method uses.
	 * @return an ArrayList containing all the loaded events
	 */
	public ArrayList<Event> load() {
		ArrayList<Event> events = new ArrayList<>();
		
		try (Scanner in = new Scanner(this.file)) {
			while(in.hasNextLine()) {
				String name = in.nextLine();
				String temp = in.nextLine();
				temp = temp.substring(temp.indexOf("=") + 1);
				int red = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
				temp = temp.substring(temp.indexOf("=") + 1);
				int green = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
				temp = temp.substring(temp.indexOf("=") + 1);
				int blue = Integer.parseInt(temp.substring(0, temp.indexOf("]")));
				Color color = new Color(red, green, blue);
				int startHour = Integer.parseInt(in.nextLine());
				int endHour = Integer.parseInt(in.nextLine());
				int startMinute = Integer.parseInt(in.nextLine());
				int endMinute = Integer.parseInt(in.nextLine());
				int day = Integer.parseInt(in.nextLine());
				String description = in.nextLine();

				events.add(new Event(name, color, startHour, endHour, startMinute, endMinute, day, description));
			}
		}
		catch (IOException e) {
			System.out.println("Unable to load from file: " + this.file.getPath());
		}

		return events;
	}

	/**
	 * Simple method which just opens a PrintWriter at the file then closes it immediately, which truncates the file to zero
	 * size, and thus deletes the contents of the file.
	 */
	public void clear() {
		try (PrintWriter out = new PrintWriter(this.file)) {
		}
		catch (IOException e) {
			System.out.println("Unable to delete contents of file: " + this.file.getPath());
		}
	}
}
