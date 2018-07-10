package com.cors.core.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	public static byte[] serialize(Object object) {
		byte[] result = null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			result = baos.toByteArray();
			oos.close();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			close(oos);
			close(baos);
		}
		
		return result;
	}
	
	public static Object unSerialize(byte[] bytes) {
		Object result = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			result = ois.readObject();
			ois.close();
			bais.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			close(ois);
			close(bais);
		}
		
		return result;
	}
	
	public static void close(Closeable closeable) {
		if(closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
