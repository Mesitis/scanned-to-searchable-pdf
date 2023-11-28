import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ScannedToSearchablePDFLambda implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String s3FileUrl, Context ctx) {
        String outputS3FileUrl = null;
        String bucketName = "se1-parser-shared-private-temp";
        String inputFolder = "ScannedToSearchablePDF/Input/";
        String outputFolder = "ScannedToSearchablePDF/Output/";
            try {
                Path inputPdf =  FileUtilities.DownloadFileFromURL(new URL(s3FileUrl), null);
                byte[] fileContent = Files.readAllBytes(inputPdf);
                String s3KeyPrefix = inputPdf.getFileName().toString(); //UUID.randomUUID().toString() + inputPdf.getFileName();
                String inputS3Key = inputFolder + s3KeyPrefix;
                String outputS3Key = outputFolder + s3KeyPrefix;
                FileUtilities.UploadToS3(bucketName, inputS3Key, "application/pdf", fileContent, false);
                DemoPdfFromS3Pdf s3Pdf = new DemoPdfFromS3Pdf();
                outputS3FileUrl = s3Pdf.run(bucketName, inputS3Key, outputS3Key).toString();
            } catch (Exception e) {
                e.printStackTrace();
                outputS3FileUrl = e.getMessage();
                System.out.println(outputS3FileUrl);
            }
        return outputS3FileUrl;
    }
}