import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		this.fileName = fileName;
		setStringLength(stringLength);
		stringList = new ArrayList<String>();
			
	}//end empty-argument constructor
	
	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile() {
		try {
			File file = new File(this.fileName);
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				String string1 = input.nextLine();
				if(string1.length()<=this.stringLength) {
					stringList.add(string1);
				}else {
					throw new StringTooLongException("String too long!");
				}
				
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}catch(StringTooLongException e) {
			System.out.println(e.getMessage());
		}	
	}//end processFile
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStringLength() {
		return stringLength;
	}

	public void setStringLength(int stringLength) {
		if (stringLength < 5) {
			this.stringLength =5;
		}
		else {
			this.stringLength = stringLength;
		}
	}
	public void getString() {
		if(stringList == null) {
			System.out.println("null");
			return;
		}
		for(String listItem: stringList) {
			System.out.println(listItem);
		}
	}

	public ArrayList<String> getStringList() {
		return stringList;
	}

	public void setStringList(ArrayList<String> stringList) {
		this.stringList = stringList;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	class StringTooLongException extends Exception{
		public StringTooLongException(String message) {
			super(message);
		}
	}
	
}//end class
