package counter.logic.sjsu;

import java.awt.Color;
import java.util.Date;

/**
 * Class to model data for events, keeping track of them for the scheduler.
 */
public class Event {
	public String name;
	public Date date;
	public Color color;
	
	public Event(String name, Date date, Color color)
	{
		this.name = name;
		this.date = date;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
