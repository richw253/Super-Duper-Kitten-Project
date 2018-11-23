package application;

import java.io.File;

import javafx.beans.property.StringProperty;

public class Settings implements Exportable {

	private String myName;
	private String myEmailAddress;

	// import/export fields
//	private final ObjectMapper myMapper;
//	private final ObjectReader myReader;
//	private final ObjectWriter myWriter;

	private final Exporter myExporter;

	/**
	 * @author Isaiah Miller
	 */
	public Settings() {
		// sets up JSON object mapper
//		myMapper = new ObjectMapper();
//		myReader = myMapper.readerForUpdating(this);
//		myWriter = myMapper.writerWithDefaultPrettyPrinter();

		myExporter = new Exporter(this);
	}

	/**
	 * Imports home data from save file into to this instance.
	 * 
	 * @author Isaiah Miller
	 */
	public void importJSON(final File srcFile) {
		myExporter.importFile(srcFile);
	}

	// Pre-refactor style
//		File srcFile = new File(Home.HOME_PATH);
//		try {
//			myReader.readValue(srcFile);
//		} catch (IOException e) {
//			System.out.println("Import failed... Making new Home save file.");
//			exportSettings();
//			e.printStackTrace();
//		}
//	}

	/**
	 * @author Isaiah Miller
	 */
	public void exportJSON(final File destFile) {
		myExporter.exportFile(destFile);
	}

//		File destFile = new File(Home.HOME_PATH);
//		try {
//			myWriter.writeValue(destFile, this);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
	
	
	
	
	//getters and setters	
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName=myName;
	}
	
//	public StringProperty myNameProperty() {
//		return myName;
//	}

	public String getMyEmailAddress() {
		return myEmailAddress;
	}

	public void setMyEmailAddress(String myEmailAddress) {
		this.myEmailAddress=myEmailAddress;
	}
	
//	public StringProperty myEmailAddressProperty() {
//		return myEmailAddress;
//	}
}
