package ngordnet.main;

import java.util.*;

import ngordnet.ngrams.TimeSeries;
import ngordnet.ngrams.NGramMap;

public class WordNet {
    public Graph graph;
//    private List<String> debug = new ArrayList<>();

    public WordNet(String synsetFilename, String hyponymFilename) {
        graph = new Graph(synsetFilename, hyponymFilename);
        // Debugger
        // debug.add("occurrence");
        // debug.add("change");
        // returnStrings(graph.findWords(debug));
        // Debugger finished

    }

    // Implementing k > 0
    public HashSet<String> occurCheck (HashSet<String> foundWords, NGramMap ngm, int startYear, int endYear, int k) {
        if (k == 0) {
            return foundWords;
        }
        else  {
            HashSet<String> answers = new HashSet<>();
            ArrayList<Node> fnd = new ArrayList<>();
            for (String word : foundWords) {
                double count = 0.0;
                TimeSeries timeCount = ngm.countHistory(word, startYear, endYear);
                if (!timeCount.isEmpty()) {
                    for (int i=startYear; i <= endYear; i++) {
                        count += timeCount.getOrDefault(i, 0.0);
                    }
                    fnd.add(new Node(word, count));
                }
            }
            Collections.sort(fnd, new NodeComparator());
            for (int i=0; i<Math.min(k, fnd.size()); i++) {
                answers.add(fnd.get(i).w);
            }
            return answers;
        }
    }

    class Node {
        public String w;
        public double v;
        public Node(String word, double value) {
            w = word;
            v = value;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node nd1, Node nd2) {
            if (nd1.v > nd2.v) {
                return -1;
            } else if (nd1.v < nd2.v) {
                return 1;
            } else {
                return nd1.w.compareTo(nd2.w);
            }
        }
    }

    public String returnStrings (HashSet<String> answers) {
        ArrayList<String> sortWords = new ArrayList<>();
        sortWords.addAll(answers);
        Collections.sort(sortWords);
        return "["+String.join(", ", sortWords)+"]";
    }
}
