import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileUtilities {


    public static Path DownloadFileFromURL(URL fileUrl, Path outputFile){
        if(outputFile == null){
            Path temp = CreateTempPDFFile();
            outputFile = temp;
        }
        try (BufferedInputStream in = new BufferedInputStream(fileUrl.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile.toString())) {

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            return outputFile;
        } catch (IOException e) {
             System.out.println(e.getMessage());
        }
        return null;
    }

    public static  String DownloadPdfFromS3(String bucketName, String documentName) throws IOException {

        AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient();
        com.amazonaws.services.s3.model.S3Object fullObject = s3client.getObject(new GetObjectRequest(bucketName, documentName));
        Path temp = Files.createTempFile(null,".pdf");
        String tempFilePath = temp.toString();
        InputStream response = fullObject.getObjectContent();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFilePath));
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = response.read(buffer)) !=  -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
                             
        response.close();
        outputStream.close();
        return tempFilePath;
    }

    public static URL UploadToS3(String bucketName, String s3Key, String contentType, byte[] fileContent, boolean generatePresignedUrl) {
       
        AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient();
        ByteArrayInputStream baInputStream = new ByteArrayInputStream(fileContent);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileContent.length);
        metadata.setContentType(contentType);
        PutObjectRequest putRequest = new PutObjectRequest(bucketName, s3Key, baInputStream, metadata);

        s3client.putObject(putRequest);
        if(generatePresignedUrl){
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, s3Key);
            return s3client.generatePresignedUrl(request);
        }
        return null;
    }

    public static Path CreateTempPDFFile() {
        try {
            return Files.createTempFile(null, ".pdf");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
