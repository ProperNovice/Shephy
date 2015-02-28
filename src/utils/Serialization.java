package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {

	private static String textFile = "txt.txt";

	public Serialization() {
	}

	public static void writeToFile(ArrayList<Object> objects) {

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(textFile))) {

			objectOutputStream.writeObject(objects);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Object> readFromFile() {

		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new FileInputStream(textFile))) {

			ArrayList<Object> objects = (ArrayList<Object>) objectInputStream
					.readObject();

			return objects;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
