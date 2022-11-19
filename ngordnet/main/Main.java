package ngordnet.main;

import ngordnet.hugbrowsermagic.HugNgordnetServer;
import ngordnet.ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        HugNgordnetServer hns = new HugNgordnetServer();
          // String wordFile = "./data/ngrams/top_49887_words.csv";
          // String countFile = "./data/ngrams/total_counts.csv";

        // // Debugger k > 0
       String wordFile = "./data/debug/debug1.csv";
       String countFile = "./data/debug/debug2.csv";
       String synsetFile = "./data/debug/Dsynsets11.txt";
       String hyponymFile = "./data/debug/Dhyponyms11.txt";

//         Debugger k = 0
         // String synsetFile = "./data/wordnet/synsets16.txt";
         // String hyponymFile = "./data/wordnet/hyponyms16.txt";

        NGramMap ngm = new NGramMap(wordFile, countFile);
        WordNet wm = new WordNet(synsetFile, hyponymFile);
        // HyponymHandler test = new HyponymHandler(ngm, wm);

        hns.startUp();
        hns.register("history", new HistoryHandler(ngm));
        hns.register("historytext", new HistoryTextHandler(ngm));
        hns.register("hyponyms", new HyponymsHandler(ngm, wm));
    }
}
