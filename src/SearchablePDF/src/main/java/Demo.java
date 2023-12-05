import java.net.URL;

public class Demo {
    public static void main(String args[]) {
        try {

            ScannedToSearchablePDFLambda obj = new ScannedToSearchablePDFLambda();
            String s3Url = "https://canopy-ul-recipes.s3.ap-southeast-1.amazonaws.com/ScannedToSearchablePDF/Input/jpmorgan_raw.pdf?response-content-disposition=inline&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEAQaCmFwLXNvdXRoLTEiSDBGAiEAyjSPhKgTdepwdBzdRWGnegDz8zKI5v57FL5igx%2F1QtcCIQD0RGV99FOv5XwAK8PMvsyBx%2B%2BuZBzyUjLZ4OLiYkyz1Sr%2FAwhtEAUaDDIyMTEyMDE2MzE2MCIMgIDlpx2CdScro6d1KtwD1ZnnnHbAEGho6IqkZwaJHdvFIhbRKWPdoTZIpxbpb%2F0RKePpOLnWhxTgsZ5Hq73hqEIZ7%2BibunjfXcM8Rcr3dXZ3jjX5Byie2G8mk7wHWatg0l50eL0ZYGxG1SAY%2FRk0UTtU0Axv31OQIDVcxtjr6xmOj04yZVfSdQyvwsRB655Nohp6w%2FkiWxAsVgIu%2Bw3fQ6E1%2F1SAtT8yIOhMeQMkY3b8whfS5uvYcY%2FYHBFxxtipOhSlj9ib3TPWXGlw6kgWkDzRIFFr30%2FZjOrltKOcijIIRLXMbofxJnFQ3HR%2F72rSpWgrzk5ZaClYEl80ce7u3zYr6r%2FOiQnQAJrq4bP5GldsT3NOlJXvT7%2Fc36edhtSb8xqyBsEOkJjKf9bXLbuK92Gbs7H5FvtBYdqpXG748EuqVcbZIWJYblNJMIpfRkv6b6zLwYC93FBncmtUKPvDx0z3bKZyq2FPqrM2d%2FbofNK3Vy3O6lHkNGiUMsaNMa5pKYPz0gvJci%2BVZhxC2OtX1kiGHrtLT0ag4xNtE%2BMQtMkTUR6gvhTeP8xF7KxskcwpAPdY7VC8mDQlrSfJl7OhDQ3BLCBcGi%2FGjA2jydOdNxQDNfyTxHkO5eg6OhLy1sFhIks%2BpijN%2FpbwwkYw2rS6qwY6kwJbBg%2BS5XGYLsd2mAixjH%2Bzc%2Ft5tR3Gh7boy51C%2F8Ei6uYlLozwpvjkFGHxPkHI2A7x1eeyn2BlDWm6TISY5r0nwJutdhvFE2dbEoOQfnNnpp%2FC5Ks0Eg3VMJ5TH2rluDNUHaDjBZGazmnfWMHQDwNFWeVjv7TSUcCUXpNxz%2BhcBY4TbvhB4TqbuIG3MOb6iJ6xPDXdFcSWpLq0aJYrkqHqLIBIq4qD0dfvVoE3zZa8rrTGGRfB8sqWTP%2BsGrHcVaMCVt7M214glbYu3rguc80DamjZmRrYDnMwF9auHT3lK%2FZTui3286VVa7RIljGno%2BISsSuP3rd25jh6Vxu7va64zp4SR7rl%2BFZfh8uxBPW2%2F7eCQA%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231205T033746Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Credential=ASIATG66J5VMO6M4OHRG%2F20231205%2Fap-southeast-1%2Fs3%2Faws4_request&X-Amz-Signature=b633403aaaa0422480caa213279da7ea33f73b9b2de3c5b53d70ab319a84b6c0";
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
