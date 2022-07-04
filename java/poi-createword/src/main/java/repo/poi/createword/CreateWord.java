package repo.poi.createword;

import org.apache.poi.xwpf.usermodel.*;
import repo.poi.createword.model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class CreateWord {

    public void create(List<Group> groups) throws IOException, URISyntaxException {
        if (!Paths.get("./generated").toFile().exists()) Files.createDirectories(Paths.get("./generated"));

        XWPFDocument document = new XWPFDocument(new FileInputStream(App.getFileFromResource("template.docx")));

        for (Group group : groups) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setStyle("Heading1");
            paragraph.createRun().setText(group.getName());

            for (GroupItem item : group.getItems()) {
                appendOperation(item.getMethod(), item.getPath(), item.getOperation(), document);
            }
        }

        FileOutputStream out = new FileOutputStream("generated/api.docx");
        document.write(out);
        out.close();
    }

    private void appendOperation(String method, String path, Operation operation, XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading2");

        if (operation.isSetSummary()) {
            paragraph.createRun().setText(operation.getSummary());
        } else {
            paragraph.createRun().setText(format("%s %s", method.toUpperCase(), path));
        }

        if (operation.isSetDescription()) {
            setBrokenText(document.createParagraph(), operation.getDescription());
        }

        document.createParagraph().createRun().setText("Request");

        XWPFTable table = document.createTable(1, 1);
        table.setWidth("100%");
        table.getRow(0).getCell(0).setText(format("%s %s", method.toUpperCase(), path));

        document.createParagraph().createRun().setText("Parameters");

        XWPFTable details = document.createTable(1, 3);
        details.setWidth("100%");
        details.getRow(0).getCell(0).setText("Name");
        details.getRow(0).getCell(1).setText("Type");
        details.getRow(0).getCell(2).setText("Details");

        if (operation.hasParameters()) {
            for (int i = 0; i < operation.getParameters().size(); i++) {
                Parameter parameter = operation.getParameters().get(i);
                XWPFTableRow row = details.createRow();

                row.getCell(0).setText(parameter.getName());

                if (parameter.isSetSchema()) {
                    row.getCell(1).setText(resolveType(parameter.getSchema()));
                } else {
                    row.getCell(1).setText("");
                }

                if (parameter.isSetDescription()) {
                    row.getCell(2).setText(parameter.getDescription());
                } else {
                    row.getCell(2).setText("-");
                }
            }
        }

        if (operation.isSetRequestBody() && operation.getRequestBody().isSetContentSchema()) {
            XWPFTableRow row = details.createRow();
            row.getCell(0).setText("Body");
            row.getCell(1).setText(resolveType(operation.getRequestBody().getContentSchema()));
            row.getCell(2).setText("-");
        }

        if (operation.hasResponses()) {
            document.createParagraph().createRun().setText("Responses");

            XWPFTable responses = document.createTable(1, 3);
            responses.setWidth("100%");
            responses.getRow(0).getCell(0).setText("Http Status");
            responses.getRow(0).getCell(1).setText("Body");
            responses.getRow(0).getCell(2).setText("Details");

            for (Map.Entry<String, Response> entry : operation.getResponses().entrySet()) {
                Response response = entry.getValue();
                XWPFTableRow row = responses.createRow();

                row.getCell(0).setText(entry.getKey());

                if (response.isSetContentVariant()) {
                    row.getCell(1).setText(resolveType(response.getContentVariant().getSchema()));
                } else {
                    row.getCell(1).setText("");
                }

                row.getCell(2).setText(response.getDescription());
            }
        }
    }

    private String resolveType(Schema schema) {
        if (schema.isSetType()) {
            return schema.getType();
        } else if (schema.isSetRef()) {
            return schema.getRefTarget();
        } else {
            return "";
        }
    }

    private void setBrokenText(XWPFParagraph paragraph, String description) {
        XWPFRun run = paragraph.createRun();
        for (String s : description.split("</br>")) {
            run.setText(s);
            run.addBreak();
        }
    }
}
