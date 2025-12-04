package edu.pc.alarcon.service;

import edu.pc.alarcon.model.CountResult;
import edu.pc.alarcon.model.StatsResult;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalysisService {
    private final DictionaryService dict;
    private final TextService texts;

    public AnalysisService(DictionaryService dict, TextService texts){
        this.dict = dict; this.texts = texts;
    }

    public CountResult countAll() throws Exception {
        List<String> words = dict.list();
        List<edu.pc.alarcon.model.TextDocument> docs = texts.list();

        Map<String,Integer> counts = new HashMap<>();
        for (String w : words) counts.put(w, 0);

        for (edu.pc.alarcon.model.TextDocument d : docs){
            String body = d.getBody() == null ? "" : d.getBody().toLowerCase();
            for (String w : words){
                int found = countOccurrences(body, w.toLowerCase());
                counts.put(w, counts.getOrDefault(w,0) + found);
            }
        }
        return new CountResult(counts);
    }

    public List<StatsResult> stats() throws Exception {
        Map<String,Integer> totals = countAll().getCounts();
        List<edu.pc.alarcon.model.TextDocument> docs = texts.list();
        List<StatsResult> out = new ArrayList<>();
        for (String w : totals.keySet()){
            int docsFound = 0;
            for (edu.pc.alarcon.model.TextDocument d : docs){
                if (countOccurrences((d.getBody()==null? "": d.getBody()).toLowerCase(), w.toLowerCase())>0) docsFound++;
            }
            out.add(new StatsResult(w, totals.get(w), docsFound));
        }
        return out;
    }

    private int countOccurrences(String text, String word){
        if (word==null || word.isBlank()) return 0;
        int count=0;
        int idx=0;
        while ((idx = text.indexOf(word, idx)) != -1){
     
            boolean leftOk = idx==0 || !Character.isLetterOrDigit(text.charAt(idx-1));
            int end = idx + word.length();
            boolean rightOk = end==text.length() || !Character.isLetterOrDigit(text.charAt(end));
            if (leftOk && rightOk) count++;
            idx = idx + word.length();
        }
        return count;
    }
}