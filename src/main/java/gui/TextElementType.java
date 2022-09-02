package gui;

public enum TextElementType {
	Text("Text"), Score("Score");

	// the code below make sit possible to change the name of the enum without
	// having to change the code.
	private final String label;

	TextElementType(String s) {
		label = s;
	}

	@Override
	public String toString() {
		return label;
	}
}
