package application;

import java.io.File;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Isaiah Miller
 *
 */
public class Settings implements Exportable {

	private StringProperty myName;
	private StringProperty myEmailAddress;

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

		myName = new SimpleStringProperty("");
		myEmailAddress = new SimpleStringProperty("");
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

	// getters and setters

	public String getMyName() {
		return myName.getValue();
	}

	public void setMyName(String theName) {
//		System.out.println(myName);
		if(theName != null) {
			myName.setValue(theName);
		}
	}

//	public StringProperty myNameProperty() {
//		return myName;
//	}

	public String getMyEmailAddress() {
		return myEmailAddress.getValue();
	}

	public void setMyEmailAddress(String theEmailAddress) {
		if (theEmailAddress != null) {
			myEmailAddress.setValue(theEmailAddress);
		}
	}

//	public StringProperty myEmailAddressProperty() {
//		return myEmailAddress;
//	}
	
	@Override
	public boolean equals(Object other) {
		System.out.println("in equals");
		boolean res;
		if(other == null || other.getClass() != this.getClass()) {
			System.out.println("res not same type");
			res = false;
		} else { //check all fields equal
			Settings otherSettings = (Settings) other;
			final boolean emailAddressIsEqual =
			    this.myEmailAddress.getValue().equals(otherSettings.myEmailAddress.getValue());
			final boolean nameIsEqual = this.myName.getValue().equals(otherSettings.myName.getValue());
			res = emailAddressIsEqual && nameIsEqual;
		}
		return res;
		
	}
	
	@Override
	public String toString() {
		return "name" + myName + ", " + "email address: " + myEmailAddress;
	}
	
}
