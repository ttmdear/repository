package repo.poi.createword;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
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

    public void create(List<Group> groups, ApiSchema apiSchema) throws IOException, URISyntaxException {
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

        // Components
        if (apiSchema.hasComponents()) {
            appendComponents(apiSchema.getComponents(), document);
        }

        FileOutputStream out = new FileOutputStream("generated/MANGO Api Documentation.docx");
        document.write(out);
        out.close();
    }

    private void appendComponents(Components components, XWPFDocument document) {
        if (!components.hasSchemas()) {
            return;
        }

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading1");
        paragraph.createRun().setText("Components");

        for (Map.Entry<String, Component> entry : components.getSchemas().entrySet()) {
            Component component = entry.getValue();

            paragraph = document.createParagraph();
            paragraph.setStyle("Heading2");
            paragraph.createRun().setText(entry.getKey());

            if (component.hasProperties()) {
                XWPFTable details = createDetailedTable("Name", "Type", "Details", document);

                for (Map.Entry<String, Schema> entry1 : component.getProperties().entrySet()) {
                    Schema schema = entry1.getValue();
                    XWPFTableRow row = details.createRow();
                    row.getCell(0).setText(entry1.getKey());
                    row.getCell(1).setText(resolveType(entry1.getValue()));

                    if (schema.hasEnum()) {
                        row.getCell(2).setText(String.format("Available values are %s", schema.getEnum().toString()));
                    } else {
                        row.getCell(2).setText("-");
                    }
                }
            } else {
                paragraph.createRun().setText("No properties");
            }
        }
    }

    private XWPFTable createRequestTable(XWPFDocument document, XWPFTable orgin) {
        if (orgin != null) {
            return orgin;
        }

        return createDetailedTable("Name", "Type", "Details", document);
    }

    private XWPFTable createDetailedTable(String col1, String col2, String col3, XWPFDocument document) {
        XWPFTable table = document.createTable(1, 3);
        table.setWidth("100%");
        table.setStyleID("PlainTable5");
        table.getCTTbl().getTblPr().unsetTblBorders();

        table.getRow(0).getCell(0).setText(col1);
        table.getRow(0).getCell(1).setText(col2);
        table.getRow(0).getCell(2).setText(col3);

        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(3120L);
        table.getCTTbl().getTblGrid().addNewGridCol().setW(3120L);
        table.getCTTbl().getTblGrid().addNewGridCol().setW(3120L);

        return table;
    }

    private void p(XWPFTableCell cell, String text, String style) {
        XWPFRun run = cell.addParagraph().createRun();
        run.setStyle(style);
        run.setText(text);
    }

    private void appendOperation(String method, String path, Operation operation, XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading2");

        if (operation.hasSummary()) {
            paragraph.createRun().setText(operation.getSummary());
        } else {
            paragraph.createRun().setText(format("%s %s", method.toUpperCase(), path));
        }

        if (operation.hasDescription()) {
            setBrokenText(document.createParagraph(), operation.getDescription());
        }

        setText(document.createParagraph().createRun(), "Request", true);

        XWPFTable table = document.createTable(1, 1);
        table.setStyleID("TableGrid");
        table.setWidth("9465");
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW("9465");
        table.getCTTbl().getTblPr().unsetTblBorders();
        table.getRow(0).getCell(0).setText(format("%s %s", method.toUpperCase(), path));

        XWPFTable requestTable = null;

        if (operation.hasParameters()) {
            setText(document.createParagraph().createRun(), "Parameters", true);

            requestTable = createRequestTable(document, null);

            for (int i = 0; i < operation.getParameters().size(); i++) {
                Parameter parameter = operation.getParameters().get(i);
                XWPFTableRow row = requestTable.createRow();

                row.getCell(0).setText(parameter.getName());

                if (parameter.hasSchema()) {
                    row.getCell(1).setText(resolveType(parameter.getSchema()));
                } else {
                    row.getCell(1).setText("");
                }

                if (parameter.hasDescription()) {
                    row.getCell(2).setText(parameter.getDescription());
                } else {
                    row.getCell(2).setText("-");
                }
            }
        }

        if (operation.hasRequestBody() && operation.getRequestBody().hasContentSchema()) {
            if (requestTable == null) {
                setText(document.createParagraph().createRun(), "Request", true);
            }

            requestTable = createRequestTable(document, requestTable);

            XWPFTableRow row = requestTable.createRow();
            row.getCell(0).setText("Body");
            row.getCell(1).setText(resolveType(operation.getRequestBody().getContentSchema()));
            row.getCell(2).setText("-");
        }

        if (operation.hasResponses()) {
            setText(document.createParagraph().createRun(), "Responses", true);
            XWPFTable responsesTable = createDetailedTable("Http Status", "Body", "Details", document);

            for (Map.Entry<String, Response> entry : operation.getResponses().entrySet()) {
                Response response = entry.getValue();
                XWPFTableRow row = responsesTable.createRow();

                row.getCell(0).setText(entry.getKey());

                if (response.hasContentVariant()) {
                    row.getCell(1).setText(resolveType(response.getContentVariant().getSchema()));
                } else {
                    row.getCell(1).setText("");
                }

                row.getCell(2).setText(response.getDescription());
            }
        }
    }

    private void setText(XWPFRun run, String text, boolean bold) {
        run.setText(text);

        if (bold) {
            run.setBold(true);
        }
    }

    private String resolveType(Schema schema) {
        if (schema.hasType()) {
            return schema.getType();
        } else if (schema.hasRef()) {
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
