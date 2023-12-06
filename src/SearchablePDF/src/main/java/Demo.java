import java.net.URL;

public class Demo {
    public static void main(String args[]) {
        try {

            ScannedToSearchablePDFLambda obj = new ScannedToSearchablePDFLambda();
            String s3Url = "";
            PdfExtractRequest req = new PdfExtractRequest();
            req.PdfUrl = new URL(s3Url);
            req.PagesForProcessing = new Integer[] { 8, 10 };

            PdfExtractResponse resp = obj.handleRequest(req, null);

            System.out.println("Generated searchable pdf with totalPages:" + resp.TotalPageCount
                    + " out of which processedPages:" + resp.ProcessedPageCount);

            // //Generate searchable PDF from local image
            // DemoPdfFromLocalImage localImage = new DemoPdfFromLocalImage();
            // localImage.run("./documents/SampleInput.png",
            // "./documents/SampleOutput.pdf");

            // //Generate searchable PDF from local pdf
            // DemoPdfFromLocalPdf localPdf = new DemoPdfFromLocalPdf();
            // localPdf.run("./documents/SampleInput.pdf", "./documents/SampleOutput.pdf");
            //
            // //Generate searchable PDF from image in Amazon S3 bucket
            // DemoPdfFromS3Image s3Image = new DemoPdfFromS3Image();
            // s3Image.run("ki-textract-demo-docs", "SampleInput.png", "SampleOutput.pdf");
            //
            // //Generate searchable PDF from pdf in Amazon S3 bucket
            // DemoPdfFromS3Pdf s3Pdf = new DemoPdfFromS3Pdf();
            // s3Pdf.run("ki-textract-demo-docs", "SampleInput.pdf", "SampleOutput.pdf");
            //
            // //Generate searchable PDF from pdf in Amazon S3 bucket
            // //(by adding text to the input pdf document)
            // DemoPdfFromS3PdfAppend s3PdfAppend = new DemoPdfFromS3PdfAppend();
            // s3PdfAppend.run("ki-textract-demo-docs", "SampleInput.pdf",
            // "SampleOutput.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
