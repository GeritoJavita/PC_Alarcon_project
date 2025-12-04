package edu.pc.alarcon.service;

import edu.pc.alarcon.model.TextDocument;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TextService {
    private final FileStorageService storage;

    public TextService(FileStorageService storage){ this.storage = storage; }

    public List<TextDocument> list() throws Exception { return storage.readTexts(); }

    public TextDocument add(TextDocument doc) throws Exception {
        List<TextDocument> texts = new ArrayList<>(storage.readTexts());

        texts.removeIf(t -> t.getId()!=null && t.getId().equals(doc.getId()));
        texts.add(doc);
        storage.writeTexts(texts);
        return doc;
    }

    public Optional<TextDocument> findById(String id) throws Exception {
        return storage.readTexts().stream().filter(t->t.getId()!=null && t.getId().equals(id)).findFirst();
    }

    public void clear() throws Exception { storage.writeTexts(new ArrayList<>()); }
}