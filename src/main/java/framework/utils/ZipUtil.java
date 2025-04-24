package framework.utils;

import java.io.*;
import java.util.zip.*;

public class ZipUtil {
    public static void zipResults(String sourceDir, String zipFilePath) {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            File fileToZip = new File(sourceDir);
            zipFile(fileToZip, fileToZip.getName(), zipOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) return;

        if (fileToZip.isDirectory()) {
            for (File child : fileToZip.listFiles()) {
                zipFile(child, fileName + "/" + child.getName(), zipOut);
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0)
                zipOut.write(bytes, 0, length);
        }
    }
}
