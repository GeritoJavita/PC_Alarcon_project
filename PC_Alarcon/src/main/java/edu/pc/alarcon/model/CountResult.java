package edu.pc.alarcon.model;
import java.util.Map;
public class CountResult {
    private Map<String,Integer> counts;
    public CountResult() {}
    public CountResult(Map<String,Integer> counts){this.counts=counts;}
    public Map<String,Integer> getCounts(){return counts;}
    public void setCounts(Map<String,Integer> counts){this.counts=counts;}
}