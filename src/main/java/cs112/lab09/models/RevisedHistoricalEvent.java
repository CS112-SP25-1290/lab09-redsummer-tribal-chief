package cs112.lab09.models;

public class RevisedHistoricalEvent extends HistoricalEvent {
	public static final String DEFAULT_REVISED_DESCRIPTION = "Revised historical event description default";
	public static final String DEFAULT_CITATION = "Academic resource/citation";

	private String revisedDescription;
	private String citation;


	public RevisedHistoricalEvent(String imageName, String location, String description, Date eventDay, String revisedDescription, String citation) {
		super(imageName, location, description, eventDay);
		setRevisedDescription(revisedDescription);
		setCitation(citation);
	}

	public RevisedHistoricalEvent() {
		this(DEFAULT_IMAGE, DEFAULT_LOCATION, DEFAULT_DESCRIPTION, DEFAULT_EVENT_DAY, DEFAULT_REVISED_DESCRIPTION, DEFAULT_CITATION);
	}

	public RevisedHistoricalEvent(RevisedHistoricalEvent original) {
		super(original);
		if (original != null) {
			this.revisedDescription = original.revisedDescription;
			this.citation = original.citation;
		} else {
			System.out.println("ERROR: Cannot copy null RevisedHistoricalEvent.");
			System.exit(0);
		}
	}

	public RevisedHistoricalEvent(String[] values) {
		setAll(values);
	}

	public boolean setRevisedDescription(String revisedDescription) {
		if (revisedDescription != null) {
			this.revisedDescription = revisedDescription;
			return true;
		}
		return false;
	}

	public boolean setCitation(String citation) {
		if (citation != null) {
			this.citation = citation;
			return true;
		}
		return false;
	}

	public boolean setAll(String[] values) {
		if (values.length >= 6) {
			return setAll(values[0], values[1], values[2], new Date(values[3]), values[4], values[5]);
		}
		return false;
	}

	public boolean setAll(String imageName, String location, String description, Date eventDay, String revisedDescription, String citation) {
		if (super.setAll(imageName, location, description, eventDay)) {
			setRevisedDescription(revisedDescription);
			setCitation(citation);
			return true;
		}
		return false;
	}

	public String getRevisedDescription() {
		return revisedDescription;
	}

	public String getCitation() {
		return citation;
	}

	@Override
	public String toString() {
		return super.toString() + "\nRevised: " + revisedDescription + "\nSource: " + citation;
	}

	@Override
	public boolean equals(Object other) {
		if (!super.equals(other)) return false;
		RevisedHistoricalEvent o = (RevisedHistoricalEvent) other;
		return revisedDescription.equals(o.revisedDescription) && citation.equals(o.citation);
	}

	public void teach() {
		System.out.println("Original:\n" + super.toString());
		System.out.println("Revised:\n" + revisedDescription);
		System.out.println("Citation:\n" + citation);
	}
}
