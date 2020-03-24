package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);
        String fileType = fileName.substring(fileName.length()-4,fileName.length());
        if (!fileType.equals(".txt")){
            System.out.println(fileType);
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        //TxtInputStream txtInputStream = new TxtInputStream("C:\\JavaRushTasks\\Tests\\src\\file2.txt");
    }
}

