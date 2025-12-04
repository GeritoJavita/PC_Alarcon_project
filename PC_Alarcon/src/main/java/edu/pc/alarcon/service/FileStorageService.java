package edu.pc.alarcon.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pc.alarcon.model.TextDocument;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final Path base = Path.of(System.getProperty("user.dir"), "data");
    private final File dictFile = base.resolve("dictionary.json").toFile();
    private final File textsFile = base.resolve("texts.json").toFile();

    public FileStorageService() throws Exception {
        base.toFile().mkdirs();
        if (!dictFile.exists()) mapper.writeValue(dictFile, new ArrayList<String>());
        if (!textsFile.exists()) mapper.writeValue(textsFile, new ArrayList<TextDocument>());
    }

    public List<String> readDictionary() throws Exception {
        return mapper.readValue(dictFile, new TypeReference<List<String>>(){});
    }
    public void writeDictionary(List<String> words) throws Exception {
        mapper.writeValue(dictFile, words);
    }
    public List<TextDocument> readTexts() throws Exception {
        return mapper.readValue(textsFile, new TypeReference<List<TextDocument>>(){});
    }
    public void writeTexts(List<TextDocument> texts) throws Exception {
        mapper.writeValue(textsFile, texts);
    }
}