/**
 * tflite
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      Irene Alvarado
 * @modified    February 8, 2019
 * @version     0.1.1
 */

package tensorflowlite;

import processing.core.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 <!-- * @example Hello  -->
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class Tflite {
	
	// PApplet myParent;

	int myVariable = 0;
	
	public final static String VERSION = "0.1.1";
	
	public Tflite() {
		// myParent = theParent;
		welcome();
	}
	
	
	private void welcome() {
		System.out.println("0.0.1");
	}

	public static String version() {
		return VERSION;
	}

	public MappedByteBuffer loadModelFile(Activity activity,String MODEL_FILE) throws IOException {
	    System.out.println(MODEL_FILE);
	    AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(MODEL_FILE);
	    FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
	    FileChannel fileChannel = inputStream.getChannel();
	    long startOffset = fileDescriptor.getStartOffset();
	    long declaredLength = fileDescriptor.getDeclaredLength();
	    return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
	}
	
	/*
	public String sayHello() {
		return "hello library.";
	}

	public void setVariable(int theA, int theB) {
		myVariable = theA + theB;
	}

	public int getVariable() {
		return myVariable;
	}
	*/
}

