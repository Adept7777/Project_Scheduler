package counter.logic.sjsu;

import java.awt.Color;

/**
 * Class to model data for events, keeping track of them for the scheduler.
 */
public class Event {
	private String name; // Name of event
	private Color color; // Color in UI
	private int startHour; // Hour of start of event
	private int endHour; // Hour of end of event
	private int startMinute; // Minutes of start of event
	private int endMinute; // Minutes of end of event
	private int day; // Day of the week the event is on
	private String description; // Description of the event
	
	public Event(String name, Color color, int startHour, int endHour, 
			int startMinute, int endMinute, int day, String description) {

		this.name = name;
		this.color = color;
		this.startHour = startHour;
		this.endHour = endHour;
		this.startMinute = startMinute;
		this.endMinute = endMinute;
		this.day = day;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getStartHour() {
		return this.startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return this.endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getStartMinute() {
		return this.startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

	public int getEndMinute() {
		return this.endMinute;
	}

	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Basic equals method that compares the parameters of events to check equality.
	 * @param o the event to compare with
	 * @return true if they have the same parameters, false if not
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Event)) { return false; }
		else {
			Event e = (Event) o;
			return this.name.equals(e.name) && this.color.equals(e.color) && this.startHour == e.startHour &&
				this.endHour == e.endHour && this.startMinute == e.startMinute && this.endMinute == e.endMinute &&
				this.day == e.day && this.description.equals(e.description);
		}
	}
}
