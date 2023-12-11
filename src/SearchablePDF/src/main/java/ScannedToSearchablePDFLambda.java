import java.nio.file.Files;
import java.nio.file.Path;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ScannedToSearchablePDFLambda implements RequestHandler<PdfExtractRequest, PdfExtractResponse> {

    @Override
    public PdfExtractResponse handleRequest(PdfExtractRequest request, Context ctx) {
        // String outputS3FileUrl = null;
        String bucketName = "se1-parser-shared-private-temp";
        String inputFolder = "ScannedToSearchablePDF/Input/";
        String outputFolder = "ScannedToSearchablePDF/Output/";
        PdfExtractResponse response = null;
        try {
            Path inputPdfPath = FileUtilities.DownloadFileFromURL(request.PdfUrl, null);
            if (request.PagesForProcessing != null && request.PagesForProcessing.length > 0) {
                Path outputPdfPath = FileUtilities.CreateTempPDFFile();
                String s3KeyPrefix = outputPdfPath.getFileName().toString();
                String outputS3Key = outputFolder + s3KeyPrefix;
                DemoPdfFromLocalPdf s3Pdf = new DemoPdfFromLocalPdf();
                response = s3Pdf.run(inputPdfPath.toString(), outputPdfPath.toString(), request.PagesForProcessing);
                response.PdfUrl = FileUtilities.UploadToS3(bucketName, outputS3Key, "application/pdf", outputPdfPath,
                        true);
            } else {
                byte[] fileContent = Files.readAllBytes(inputPdfPath);
                String s3KeyPrefix = inputPdfPath.getFileName().toString();
                String inputS3Key = inputFolder + s3KeyPrefix;
                String outputS3Key = outputFolder + s3KeyPrefix;
                FileUtilities.UploadToS3(bucketName, inputS3Key, "application/pdf", fileContent, false);
                DemoPdfFromS3Pdf s3Pdf = new DemoPdfFromS3Pdf();
                response = s3Pdf.run(bucketName, inputS3Key, outputS3Key);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response = new PdfExtractResponse();
            response.ErrorMessage = e.getMessage();
            System.out.println(response.ErrorMessage);
        }
        return response;
    }
}