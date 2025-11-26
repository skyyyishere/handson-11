package latihan4_isp;

import java.util.ArrayList;
import java.util.List;

import latihan4_isp.good.*;

public class ISPPractice {
    public static void main(String[] args) {

        System.out.println("=== GOOD PRACTICE: Mengikuti ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();

        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();

        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument spreadsheet = new SpreadsheetDocument("Budget.xlsx");
        spreadsheet.read();
        spreadsheet.edit("A1: 1000");
        spreadsheet.calculate("SUM(A1:A10)");
        spreadsheet.print();

        System.out.println("\n--- Testing Image Document ---");
        ImageDocument goodImage = new ImageDocument("Photo.jpg");
        goodImage.read();
        goodImage.resize(800, 600);

        System.out.println("\n--- Polymorphic Usage ---");

        ReadableDocument readable1 = new PdfDocument("Doc1.pdf");
        ReadableDocument readable2 = new ImageDocument("Image1.jpg");
        readable1.read();
        readable2.read();

        List<PrintableDocument> printableDocuments = new ArrayList<>();
        printableDocuments.add(new PdfDocument("Doc.pdf"));
        printableDocuments.add(new WordDocument("Report.docx"));
        printableDocuments.add(new SpreadsheetDocument("Data.xlsx"));

        System.out.println("\nPrinting all printable documents:");
        for (PrintableDocument doc : printableDocuments) {
            doc.print();
        }
    }
}
