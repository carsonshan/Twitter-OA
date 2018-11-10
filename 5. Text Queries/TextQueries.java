import java.util.*;
public class TextQueries {
    public static List<List<Integer>> textQuery(String[] sentences, String[] phrases) {
        HashMap<String, HashSet<Integer>> wordsAppearInSentences = new HashMap<>();
        for (int i = 0; i < sentences.length; i++){
            for (String s : sentences[i].split(" ")){
                if (!wordsAppearInSentences.containsKey(s))
                    wordsAppearInSentences.put(s, new HashSet<>());
                wordsAppearInSentences.get(s).add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (String s : phrases){
            String[] words = s.split(" ");
            List<Integer> ans = new ArrayList<>();
            HashSet<Integer> appear = new HashSet<>(wordsAppearInSentences.get(words[0]));
            for (String i : words)
                appear.retainAll(wordsAppearInSentences.get(i));
            if (appear.size() > 0)
                ans.addAll(appear);
            else
                ans.add(-1);
            res.add(ans);
        }
        return res;
    }
    public static void main(String[] args){
        // testcase 1
        String[] sentences1 = {"bob and alice like to text each other", "bob does not like to ski", "alice likes to ski"};
        String[] phrases1 = {"bob alice", "alice", "like"};
        System.out.println(textQuery(sentences1, phrases1));
        // testcase 2
        String[] sentences2 = {"jim likes mary", "kate likes tom", "tom does not like jim"};
        String[] phrases2 = {"jim tom", "likes"};
        System.out.println(textQuery(sentences2, phrases2));
        // testcase 3
        String[] sentences3 = {"how it was done", "are you how", "it goes to", "goes done are it"};
        String[] phrases3 = {"done it", "it"};
        System.out.println(textQuery(sentences3, phrases3));
        // testcase 4
        String[] sentences4 = {"it go will away", "go do it", "what to will east"};
        String[] phrases4 = {"it will", "go east will", "will"};
        System.out.println(textQuery(sentences4, phrases4));
        // testcase 5
        String[] sentences5 = {"bob alice bob alice bob alice"};
        String[] phrases5 = {"bob alice"};
        System.out.println(textQuery(sentences5, phrases5));
    }
}
