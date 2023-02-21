package pers.helen.javabasic.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileRead {

    public void readByByte(){
        String path = "D://temp/test.txt";
        File file = new File(path);
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(file);
            byte[] byteArr = new byte[1024];
            int byteCount;
            while((byteCount = in.read(byteArr)) != -1){
                out.write(byteArr, 0, byteCount);
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
