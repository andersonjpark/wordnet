package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;

import ngordnet.ngrams.NGramMap;
import java.util.HashSet;
import java.util.List;

public class HyponymsHandler extends NgordnetQueryHandler {
    private final WordNet wn;
    private final NGramMap ngm;
//    private List<String> debug = new ArrayList<>();

    public HyponymsHandler(NGramMap ngm, WordNet wn) {
        super();
        this.ngm = ngm;
        this.wn = wn;
        // Debugger k > 0
        // debug.add("action");
        // System.out.println("Handler initialized");
        // wn.returnStrings(wn.occurCheck(wn.graph.findWords(debug), this.ngm, 1990, 2000, 2));
    }
    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();

        HashSet<String> foundWords = wn.graph.findWords(words);
        if (k == 0) {
            return wn.returnStrings(foundWords);
        }
        else {
            HashSet<String> filterWords = wn.occurCheck(foundWords, this.ngm, startYear, endYear, k);
            return wn.returnStrings(filterWords);
        }
    }
}
