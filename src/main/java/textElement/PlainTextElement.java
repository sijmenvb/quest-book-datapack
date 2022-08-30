package textElement;

public class PlainTextElement extends TextElement{

	private String text;

	@Override
	public String toCommand() {
		return String.format("{\"text\":\"%s\"}", text);
	}
	
	
}
