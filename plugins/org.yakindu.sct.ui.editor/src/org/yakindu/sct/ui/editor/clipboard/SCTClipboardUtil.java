package org.yakindu.sct.ui.editor.clipboard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SCTClipboardUtil {
	
	private static final int KILOBYTE = 1024;
	private static final int BUFFER_SIZE = 128 * KILOBYTE;
	
	private SCTClipboardUtil(){
		//This class shouldn't be instantiated.
	}
	
	public static byte[] getByteArrayFromObject(Object object) {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
		try {
			ObjectOutputStream o = new ObjectOutputStream( out );
			o.writeObject(object);
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	public static Object getObjectFromByteArray(byte[] array) {
		
		ByteArrayInputStream out = new ByteArrayInputStream(array);
		
		try {
			ObjectInputStream o = new ObjectInputStream(out);
			return o.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
