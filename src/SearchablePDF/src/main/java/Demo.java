public class Demo {
    public static void main(String args[]) {
        try {
            
            ScannedToSearchablePDFLambda obj = new ScannedToSearchablePDFLambda();
            String s3Url = "https://canopy-ul-recipes.s3.ap-southeast-1.amazonaws.com/ScannedToSearchablePDF/Input/citco_raw.pdf?response-content-disposition=inline&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEGAaCmFwLXNvdXRoLTEiSDBGAiEAoHl6YweZh8HAE%2FW83bbBORv4TowX006dD9dWsMBvqrMCIQDxRTzm79u3ezl3fv1GFeCZ1yGmvcUyD2Uy%2B9fv0Ok0nCqIBAi5%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAUaDDIyMTEyMDE2MzE2MCIMFL%2F%2FRddAL0Jc1%2FepKtwDk2fu4iZvwzJprdSdwufoOI2EI%2F6p6zz2QFmd%2FtrUD66oXvOIMlOcXky2L%2FkMmwJ982tlcTwLRtjQtqdfszD7ui0CpxDToFEnB5zboCQr%2B0iPk8jQK8kl1qor%2FVDJQQPFvImoXTTzi6q0DgDGl8jVpR%2BJiR6w3fj8vGxHWR%2B6asRIc4pugegsmBvZamV1xii1rU08Fw4uvAqcmbNZrAo9o1aanAWXI9HKojjeBUD9fj3bCIUGbM%2BzEAeFM2RZInkgiAzBI8CWJ9MXJFhTtWV4ADvY9r9Ba4g0S239WADRs7g%2BASuksy5uy8jyOu9hC51e0jszXGRl5CtrO5wyHU2ZvkUh0CZegjLAdE4Kwjmf611x0rgg78gWkZepNkz6WaoX6MHFACkmLHB8W3%2F67bjHpPo5nnpBoWEBr6Ial%2B%2FeWFuMlDb6OoCQ75dpy9HLASETtugCzIc22%2FLECHorMcHtQKC4CNh6wuBAabuGI3I37o5zXcejmfj4kZo8skMhy14Tza5IZiFvP15TwN1TN1kEy2%2FpvrPMibptkmxoWg089iZV1HKqRyChhBNLLSKfNdbmwDLyAztOeqsj3mu4oaD5gI4KdsMq8mquvuHzdOHVEG1RY5nuhvjDUEat8y4wvq6WqwY6kwJNBfvql8JEToO95QjkG7EWyc0GoXjmRTrZMxiqHouSYNwxieEW7yAFplu3w%2FqowhyYE39T2XeCDA4InwMd240XI8CnPUdWgaNt%2B7vDAN4mVaLdd77%2FdRbiqpDVWc4DzAd94KByw008YBim5H4V3hC%2FhN60KYcH0fMcGFx%2Fm2iu8CFb%2FWsVwZaDntVWZNbPzjgD1ATrRxjItb6PaVRkMAXAN8ad3uJ%2BPUW80hGYG66VGC%2FuS66GxXH1IMlNcwe%2B5bc3m%2FjYUuFytYtgYFEpacMACUGSXuzGjYB42ti7qxxkmvI0LT4c%2Bq0zDCr93iuZyftURer4HBzBhsYurIoCN0m7uKZ7T8fEDOi24%2BtfPk94PAOd9A%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231128T083330Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Credential=ASIATG66J5VMBTKHUBNN%2F20231128%2Fap-southeast-1%2Fs3%2Faws4_request&X-Amz-Signature=90ba6e248d399c93649a9e4bb57338276227aa1cdf6506abf250ae0f08904203";
            obj.handleRequest(s3Url, null);
           
           
            // //Generate searchable PDF from local image
            // DemoPdfFromLocalImage localImage = new DemoPdfFromLocalImage();
            // localImage.run("./documents/SampleInput.png", "./documents/SampleOutput.pdf");

//            //Generate searchable PDF from local pdf
//            DemoPdfFromLocalPdf localPdf = new DemoPdfFromLocalPdf();
//            localPdf.run("./documents/SampleInput.pdf", "./documents/SampleOutput.pdf");
//
//            //Generate searchable PDF from image in Amazon S3 bucket
//            DemoPdfFromS3Image s3Image = new DemoPdfFromS3Image();
//            s3Image.run("ki-textract-demo-docs", "SampleInput.png", "SampleOutput.pdf");
//
//            //Generate searchable PDF from pdf in Amazon S3 bucket
//            DemoPdfFromS3Pdf s3Pdf = new DemoPdfFromS3Pdf();
//            s3Pdf.run("ki-textract-demo-docs", "SampleInput.pdf", "SampleOutput.pdf");
//
//            //Generate searchable PDF from pdf in Amazon S3 bucket
//            //(by adding text to the input pdf document)
//            DemoPdfFromS3PdfAppend s3PdfAppend = new DemoPdfFromS3PdfAppend();
//            s3PdfAppend.run("ki-textract-demo-docs", "SampleInput.pdf", "SampleOutput.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
