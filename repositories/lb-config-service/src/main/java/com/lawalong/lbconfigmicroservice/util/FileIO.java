package com.lawalong.lbconfigmicroservice.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIO {
    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     * @param data
     */
    public void writeUsingFiles(String filePath, String data) {
        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
