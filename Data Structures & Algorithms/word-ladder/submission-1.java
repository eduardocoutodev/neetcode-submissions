class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> regexMap = new HashMap<>();
        Set<String> visited = new HashSet<>();

        List<String> wordListToIterate = new ArrayList<>(wordList);
        wordListToIterate.add(beginWord);

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String wordWithRegex =
                    word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                regexMap.computeIfAbsent(wordWithRegex, k -> new ArrayList<>()).add(word);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        int result = 1;

        queue.addLast(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            for (int j = 0; j < queueLength; j++) {
                String word = queue.removeFirst();

                if (word.equals(endWord)) {
                    return result;
                }

                for (int i = 0; i < word.length(); i++) {
                    String wordWithRegex =
                        word.substring(0, i) + "*" + word.substring(i + 1, word.length());

                    List<String> neighboors = regexMap.getOrDefault(wordWithRegex, new ArrayList<>());
                    for (String neighboor : neighboors) {
                        if (visited.contains(neighboor))
                            continue;

                        queue.addLast(neighboor);
                        visited.add(neighboor);
                    }
                }
            }

            result++;
        }

        return 0;
    }
}
