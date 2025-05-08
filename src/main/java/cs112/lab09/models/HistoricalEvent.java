/* 
HistoricalEvent.Java - Represents any historical event with a description and date. 

Class Invarients- NO b/c of the Instance varibles 
*/
package cs112.lab09.models;

public class HistoricalEvent {
	public static final String DEFAULT_IMAGE = "default.jpg";
	public static final String DEFAULT_LOCATION = "Unknown";
	public static final String DEFAULT_DESCRIPTION = "No description available.";
	public static final Date DEFAULT_EVENT_DAY = new Date("01/01/1900");

	private String imageName;
	private String location;
	private String description;
	private Date eventDay;

	public HistoricalEvent(String imageName, String location, String description, Date eventDay) {
		setAll(imageName, location, description, eventDay);
	}

	public HistoricalEvent() {
		this(DEFAULT_IMAGE, DEFAULT_LOCATION, DEFAULT_DESCRIPTION, DEFAULT_EVENT_DAY);
	}

	public HistoricalEvent(HistoricalEvent original) {
		if (original != null) {
			setAll(original.imageName, original.location, original.description, new Date(original.eventDay));
		} else {
			System.out.println("ERROR: Cannot copy null HistoricalEvent.");
			System.exit(0);
		}
	}

	public boolean setAll(String imageName, String location, String description, Date eventDay) {
		if (imageName != null && location != null && description != null && eventDay != null) {
			this.imageName = imageName;
			this.location = location;
			this.description = description;
			this.eventDay = new Date(eventDay);
			return true;
		}
		return false;
	}

	public String getImageName() {
		return imageName;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public Date getEventDay() {
		return new Date(eventDay);
	}

	public String getDate() {
		return eventDay.toString(); // so it matches String expectation in RevisedHistoricalEvent
	}

	@Override
	public String toString() {
		return location + " - " + description + " (" + eventDay + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()) return false;
		HistoricalEvent o = (HistoricalEvent) other;
		return imageName.equals(o.imageName) &&
				location.equals(o.location) &&
				description.equals(o.description) &&
				eventDay.equals(o.eventDay);
	}
}