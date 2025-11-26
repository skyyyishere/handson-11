package latihan4_isp.good;

public class PdfDocument implements ReadableDocument, PrintableDocument {
    private String filename;

    public PdfDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[PdfDocument] Reading PDF: " + filename);
    }

    @Override
    public void print() {
        System.out.println("[PdfDocument] Printing PDF: " + filename);
    }
}
