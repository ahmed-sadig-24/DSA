package Graphs;

import java.util.*;

public class WordLadder {
      public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordDict = new HashSet<>(wordList);

            if (!wordDict.contains(endWord)) return 0;

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int steps = 0;
            while (!queue.isEmpty()) {
                  steps++;

                  int size = queue.size();
                  for (int s = 0; s < size; s++) {
                        String word = queue.poll();

                        char[] charArray = word.toCharArray();

                        for (int i = 0; i < charArray.length; i++) {
                              char old = charArray[i];

                              for (char c = 'a'; c <= 'z'; c++) {
                                    if (c == old) continue;

                                    charArray[i] = c;
                                    String newWord = new String(charArray);

                                    if (newWord.equals(endWord)) return steps + 1;

                                    if (wordDict.contains(newWord) && !visited.contains(newWord)) {
                                          visited.add(newWord);
                                          queue.offer(newWord);
                                    }
                              }

                              charArray[i] = old;
                        }
                  }
            }
            return 0;
      }

      public static void main(String[] args) {
            String beginWord = "hit", endWord = "cog";
            List<String> wordList = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

            System.out.println(ladderLength(beginWord, endWord, wordList));
      }
}
