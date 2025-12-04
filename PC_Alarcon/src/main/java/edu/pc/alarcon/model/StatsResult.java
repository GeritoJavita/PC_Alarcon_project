package edu.pc.alarcon.model;
public class StatsResult {
    private String word;
    private int totalOccurrences;
    private int documentsFound;
    public StatsResult() {}
    public StatsResult(String word,int totalOccurrences,int documentsFound){
        this.word=word; this.totalOccurrences=totalOccurrences; this.documentsFound=documentsFound;
    }
    public String getWord(){return word;}
    public int getTotalOccurrences(){return totalOccurrences;}
    public int getDocumentsFound(){return documentsFound;}
}