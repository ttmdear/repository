package repo.poi.createword;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import repo.poi.createword.model.ApiSchema;
import repo.poi.createword.model.Group;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        PrepareGroups prepareGroups = new PrepareGroups();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ApiSchema apiSchema = mapper.readValue(getFileFromResource("api-docs.json"), ApiSchema.class);

        CreateWord createWord = new CreateWord();
        createWord.create(prepareGroups.prepare(apiSchema));

        System.out.println("test");
    }

    public static File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = App.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }
    }
}
