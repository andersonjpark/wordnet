package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class Graph {
    // variables : what is our graph representation?
    private final HashMap<Integer, HashSet<String>> nodes;
    private final HashMap<Integer, HashSet<Integer>> edges;

    // Build graph based on synset file and hyponym file
    public Graph(String synsetFilename, String hyponymFilename) {
        nodes = new HashMap<>();
        edges = new HashMap<>();

        In synsetIn = new In(synsetFilename);
        while (synsetIn.hasNextLine()) {
            if (synsetIn.isEmpty()) {
                break;
            }
            String[] synElements = synsetIn.readLine().split(",");
            Integer key = Integer.parseInt(synElements[0]);
            String[] nodeWords = synElements[1].split("\\s+");
            HashSet<String> nodeBucket = new HashSet<>();
//            Collections.addAll(nodeBucket, nodeWords);
//            nodeBucket.addAll(Arrays.asList(nodeWords));
            for (String s : nodeWords) {
                nodeBucket.add(s);
            }
            nodes.put(key, nodeBucket);
            edges.put(key, new HashSet<>());
        }
        In hyponymIn = new In(hyponymFilename);
        while (hyponymIn.hasNextLine()) {
            if (hyponymIn.isEmpty()) {
                break;
            }
            String[] hypElements = hyponymIn.readLine().split(",");
            Integer key = Integer.parseInt(hypElements[0]);
            HashSet<Integer> edgeBucket = edges.get(key);
            for (int i = 1; i < hypElements.length; i++) {
                edgeBucket.add(Integer.parseInt(hypElements[i]));
            }
        }
    }

    public HashSet<String> findWords (List<String> words) {
        HashSet<String> filtGraph = null;
        for (String keyword : words) {
            HashSet<String> oneNode = new HashSet<>();
            for (int key : nodes.keySet()) {
                if (nodes.get(key).contains(keyword)) {
                    cumulate(key, oneNode);
                }
            }
            if (filtGraph == null) {
                filtGraph = oneNode;
            }
            else if (filtGraph.isEmpty())  {
                return new HashSet<>();
            }
            else {
                filtGraph.retainAll(oneNode);
            }
        }
        return filtGraph;
    }

    // recursion that finds all lower edges and cumulate it (Union)
    private void cumulate(int id, HashSet<String> build) {
        build.addAll(nodes.get(id));
        for (int key : edges.get(id)) {
            cumulate(key, build);
        }
    }
}
