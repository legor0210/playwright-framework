package framework.utils;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.*;

public class PDFReportUtil {
    public static void generatePdfFromHtml(String htmlPath, String pdfPath) {
        try (OutputStream os = new FileOutputStream(pdfPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri(htmlPath);
            builder.toStream(os);
            builder.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
