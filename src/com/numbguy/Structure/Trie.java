package com.numbguy.Structure;

import java.util.Arrays;
import java.util.HashMap;

public class Trie {
    private static class TrieNode{
        private boolean isEndOfWord = false;
        int freqs = 0;
        private HashMap<Character, TrieNode> subNode = new HashMap<>();
        public void addSubNode(Character c, TrieNode node){ subNode.put(c, node); }
        public TrieNode getTrieNode(Character c){ return subNode.get(c); }
        public void setEndOfWord(boolean end) { isEndOfWord = end; }
        public boolean isEndOfWord() { return isEndOfWord; }
    }

    private static TrieNode root = new TrieNode();

    private static void addWord(String lineText)
    {
        TrieNode tempNode = root;
        for(int i = 0; i < lineText.length();i++) {
            Character c = lineText.charAt(i);

            TrieNode node = tempNode.getTrieNode(c);
            if(node == null) {
                node = new TrieNode();
                tempNode.addSubNode(c, node);

            }
            tempNode = node;

            if(i == lineText.length() -1) {
                tempNode.setEndOfWord(true);
            }
        }
    }

    private static boolean isSymbol(char c) {
        int ic = (int)c;
        //东亚文字

        return (ic < 0x2E80||ic > 0x9FFF);
    }

    public  static String filter(String text)
    {
        if(text == null)
            return text;
        int pos = 0;
        int begin = 0;
        StringBuilder result = new StringBuilder();
        String replacement = "*";
        TrieNode tempNode  = root;

        while(pos < text.length()) {
            Character c = text.charAt(pos);
//            if(isSymbol(c)) {
//                if(tempNode == root) {
//                    result.append(c);
//                    ++begin;
//                }
//                ++pos;
//                continue;
//            }
            tempNode = tempNode.getTrieNode(c);
            if(tempNode == null) {
                result.append(text.charAt(begin));
                tempNode = root;
                begin++;
                pos = begin;
            }else if(tempNode.isEndOfWord()) {
                result.append(replacement);
                pos++;
                begin = pos;
                tempNode = root;
            }else {
                pos++;
            }
        }
        result.append(text.substring(begin));
        return result.toString();
    }
    public static void main(String[] args) {
        addWord("abcd");
        addWord("df");



    }
}