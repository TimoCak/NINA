package api;

import java.io.BufferedReader;
import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

public class FileHandle {

	private String path;
	private String content;

	public String getPath() {
		return this.path;
	}

	public String getContent() {
		return this.content;
	}

	public FileHandle(String path, String content) {
		this.path = path;
		this.content = content;
		createFile(path);
		writeFile(path, content);
	}

	private static void createFile(String path) {
		try {
			File file = new File(path);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static void writeFile(String path, String content) {
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(content);
			writer.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String readFile(String path) throws IOException {
		StringBuilder content = new StringBuilder();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));

			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}

			try {
				reader.close();
			} catch (IOException e) {
				System.err.println("File reader could not close!");
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println(content);
		return content.toString();
	}

}
