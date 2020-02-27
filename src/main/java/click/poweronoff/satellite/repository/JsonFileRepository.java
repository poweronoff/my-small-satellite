package click.poweronoff.satellite.repository;

import click.poweronoff.satellite.repository.dto.FeaturesCollection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Repository
public class JsonFileRepository {

    @Value("${storage.file.path}")
    private String filePath;

    private ObjectMapper objectMapper;

    @PostConstruct
    public void initRepository() {
        objectMapper = new ObjectMapper();
    }

    public FeaturesCollection[] readAllFeatures() throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        FeaturesCollection[] features = objectMapper.readValue(reader, FeaturesCollection[].class);
        reader.close();
        return features;
    }
}
