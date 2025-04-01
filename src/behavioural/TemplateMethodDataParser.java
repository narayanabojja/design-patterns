package behavioural;

abstract class DataParser {

	public final void parse() {
		openFile();
		parseData();
		closeFile();
	}

	protected void openFile() {
		System.out.println("Open file");
	}

	protected void closeFile() {
		System.out.println("Close file");
	}

	protected abstract void parseData();

}

class JSONParser extends DataParser {

	@Override
	protected void parseData() {
		System.out.println("Parsing JSON file");
	}

}

class CSVParser extends DataParser {

	@Override
	protected void parseData() {
		System.out.println("Parsing CSV file");
	}

}

public class TemplateMethodDataParser {
	public static void main(String[] args) {
		DataParser json = new JSONParser();
		json.parse();
		DataParser csv = new CSVParser();
		csv.parse();
	}
}
