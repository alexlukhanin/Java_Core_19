/**
 * Homework 19
 *
 */

package ua.lviv.lgs;

/**
 * @author alexl
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Methods {

	public static void serialize(File file, Serializable object) throws IOException {

		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(object);
		oos.close();
		fos.close();

	}

	public static Serializable deserialize(File file) throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Serializable object = (Serializable) ois.readObject();
		ois.close();
		fis.close();

		return object;

	}

}
