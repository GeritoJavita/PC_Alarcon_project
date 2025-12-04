package edu.pc.alarcon.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class DictionaryService {
    private final FileStorageService storage;

    public DictionaryService(FileStorageService storage){ this.storage = storage; }

    public List<String> list() throws Exception { return storage.readDictionary(); }

    public List<String> add(String word) throws Exception {
        List<String> dict = new ArrayList<>(storage.readDictionary());
        String w = word.trim().toLowerCase();
        if (!dict.contains(w)) dict.add(w);
        storage.writeDictionary(dict);
        return dict;
    }
    public void clear() throws Exception {
        storage.writeDictionary(new ArrayList<>());
    }
}