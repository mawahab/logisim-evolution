package com.cburch.logisim.std.memory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.cburch.hex.HexModel;
import com.cburch.logisim.gui.hex.HexFile;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import javax.xml.ws.soap.AddressingFeature.Responses;
import java.io.*;
class NiosIIAsmFile extends HexFile {
	


	static public void open(HexModel dst, File file) throws IOException {
    byte[] fileData = new byte[(int) file.length()];
    DataInputStream dis = new DataInputStream(new FileInputStream(file));
    dis.readFully(fileData);
    dis.close();
    
     int off=0;
        int value=0;
        for (int addr=0;addr<fileData.length;addr++) {
        	value = (value<<8)+fileData[addr];
        	if (off==3) {
        		dst.set(addr/4, value);
        		value=0;
        	}
        	off++;
        }
        
	}

}
