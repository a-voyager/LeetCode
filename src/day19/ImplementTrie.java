package day19;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/5 18:40
 * Version: 1.0
 */
public class ImplementTrie {

//    static class TrieNode {
//        String val;
//        TrieNode next;
//
//        // Initialize your data structure here.
//        public TrieNode() {
//        }
//
//        public TrieNode(String val) {
//            this.val = val;
//        }
//    }
//
//    static class Trie {
//        private TrieNode root;
//
//        public Trie() {
//            root = new TrieNode("");
//        }
//
//        // Inserts a word into the trie.
//        public void insert(String word) {
//            TrieNode node = new TrieNode(word);
//            node.next = root.next;
//            root.next = node;
//        }
//
//        // Returns if the word is in the trie.
//        public boolean search(String word) {
//            for (TrieNode node = root; node != null; node = node.next) {
//                if (node.val.equals(word))
//                    return true;
//            }
//            return false;
//        }
//
//        // Returns if there is any word in the trie
//        // that starts with the given prefix.
//        public boolean startsWith(String prefix) {
//            for (TrieNode node = root; node != null; node = node.next) {
//                if (node.val.startsWith(prefix))
//                    return true;
//            }
//            return false;
//        }
//    }

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        // Initialize your data structure here.
        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode runner = root;
            for(char c : word.toCharArray()){
                if(runner.children[c-'a'] == null) {
                    runner.children[c-'a'] = new TrieNode();
                }
                runner = runner.children[c-'a'];
            }
            runner.isEndOfWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode runner = root;
            for(char c : word.toCharArray()) {
                if(runner.children[c-'a'] == null) {
                    return false;
                } else {
                    runner = runner.children[c-'a'];
                }
            }
            return runner.isEndOfWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode runner = root;
            for(char c : prefix.toCharArray()) {
                if(runner.children[c-'a'] == null) {
                    return false;
                } else {
                    runner = runner.children[c-'a'];
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("somestring");
        boolean key = trie.search("key");
        System.out.println(key);
        System.out.println(trie.startsWith("d"));
    }

}
