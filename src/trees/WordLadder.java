package trees;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    private Map<String, List<String>> allComboDict;
    private Map<Integer, ArrayList<Pair<String,String>>> levelMap;
    private Map<String, ArrayList<String>> graph;
    private int L;
    private ArrayList<LinkedHashSet<String>> ans;

    WordLadder(){
        this.allComboDict = new HashMap<>();
        this.levelMap = new HashMap<>();
        this.graph = new HashMap<>();
        this.ans = new ArrayList<>();
        this.L = 0;
    }

    public static void main(String[] args){

        String[] str = {"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(str);
        WordLadder obj = new WordLadder();


        obj.createDictionary("hit", "cog",list);

//        System.out.println(ladderLength("hit", "cog", list));
        obj.ladders("hit", "cog", list);


        for(HashSet<String> l : obj.ans){
            System.out.println(l);
        }
    }

    void createDictionary(String beginWord, String endWord,List<String> wordList){
        this.L = beginWord.length();
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        this.allComboDict.put(newWord, transformations);
                    }
                });
    }

    void bfs(String beginWord, String endWord){
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 0));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {



                    ArrayList<Pair<String,String>> levelWords= null;
                    levelWords = this.levelMap.getOrDefault(level+1, new ArrayList<>());
                    if(!levelWords.contains(new Pair(word,adjacentWord)))
                        levelWords.add(new Pair(word,adjacentWord));
                    this.levelMap.put(level+1, levelWords);


                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level +1));
                    }

                    ArrayList<String> neighbours = graph.getOrDefault(word,new ArrayList<String>());
                    if(!neighbours.contains(adjacentWord))
                        neighbours.add(adjacentWord);
                    graph.put(word,neighbours);
                }
            }
        }

//        for(Map.Entry<Integer, ArrayList<Pair<String,String>>> e : this.levelMap.entrySet()){
//            System.out.println("[ "+e.getKey()+" -> "+e.getValue()+" ]");
//        }
//
//        System.out.println("------------------------");
//
//        for(Map.Entry<String, ArrayList<String>> e : this.graph.entrySet()){
//            System.out.println("[ "+e.getKey()+" -> "+e.getValue()+" ]");
//        }
//
//        System.out.println("------------------------");


    }

    boolean isPresent(String str,  ArrayList<Pair<String,String>> levelwords){
        for(Pair<String,String> p : levelwords){
            if(str.equals(p.getValue()))
                return true;
        }
        return false;
    }

    boolean isMapping(String word, String neighbour,int level){
        ArrayList<Pair<String, String>> list = levelMap.get(level);

        for(Pair<String, String> p : list){
            if(p.getKey().equals(word) && p.getValue().equals(neighbour))
                return true;
        }

        return false;
    }

    void dfs(String beginWord,String endWord,LinkedHashSet<String> list,String word, int level){
        list.add(word);
        if(endWord.equals(word))
            ans.add(new LinkedHashSet<>(list));
        else{
            ArrayList<String> neigbours = graph.getOrDefault(word, new ArrayList<>());

            for(String neighbour : neigbours){
                ArrayList<Pair<String,String>> levelwords = levelMap.getOrDefault(level+1,new ArrayList<Pair<String,String>>() );

                if(isPresent(neighbour,levelwords) && isMapping(word,neighbour,level+1)){
                    dfs(beginWord,endWord,new LinkedHashSet<>(list), neighbour,level+1);
                }


            }
        }
        list.remove(list.size()-1);

     }

     void ladders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return;

        bfs(beginWord,endWord); // to construct graph
        ArrayList<ArrayList<String>> paths = new ArrayList<>();
        dfs(beginWord,endWord,new LinkedHashSet<>(),beginWord,0);
     }

    int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
