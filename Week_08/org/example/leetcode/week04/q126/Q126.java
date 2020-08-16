package org.example.leetcode.week04.q126;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(isEmptyString(beginWord) || isEmptyString(endWord) || null == wordList || wordList.isEmpty() || !wordList.contains(endWord)) {
            return null;
        }

        // 记录单词与其索引的映射表
        Map<Integer, String> idWord = new HashMap<>();
        Map<String, Integer> wordId = new HashMap<>();
        for (int i = 0; i < wordId.size(); i++) {
            idWord.put(i, wordList.get(i));
            wordId.put(wordList.get(i), i);
        }
        idWord.put(wordList.size(), beginWord);
        wordId.put(beginWord, wordList.size());

        // 构建可转换的两个单词间的无向边
        ArrayList<Integer>[] edges = new ArrayList[wordId.size()];
        for (int i = 0; i < wordId.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < wordId.size(); i++) {
            for (int j = 0; j < wordId.size(); j++) {
                if (isWithOneDiffChar(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        // 起始单词与目标单词的代价
        int[] cost = new int[wordId.size()];
        for (int i = 0; i < wordId.size(); i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[wordId.get(beginWord)] = 0;

        // 起始节点开始的所有路径
        Queue<List<Integer>> allPath = new ArrayDeque<>();
        allPath.add(Arrays.asList(wordId.get(beginWord)));

        int endWordId = wordId.get(endWord);

        List<List<String>> res = new ArrayList<>();
        List<Integer> tmpPath = null;
        List<String> onePath = null;
        int lastWordId = -1;
        while (!allPath.isEmpty()) {
            tmpPath = allPath.poll();
            lastWordId = tmpPath.get(tmpPath.size() - 1);
            if (lastWordId == endWordId) {
                onePath = new ArrayList<>();
                for (int i : tmpPath) {
                    onePath.add(idWord.get(i));
                }
                res.add(onePath);
            } else {
                for (int i = 0; i < edges[lastWordId].size(); i++) {
                    int tmpDestId = edges[lastWordId].get(i);
                    if (cost[lastWordId] + 1 < cost[tmpDestId]) {
                        cost[tmpDestId] = cost[lastWordId] + 1;
                        allPath.add(Arrays.asList(lastWordId, tmpDestId));
                    }
                }
            }
        }
        return res;
    }

    private boolean isWithOneDiffChar(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < str1.length() && diffCount < 2; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    private boolean isEmptyString(String str) {
        return null == str || str.isEmpty();
    }
}
