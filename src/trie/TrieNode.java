package trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode(int max){
        isEndOfWord = false;
        for(int i=0;i<max;i++){
            children[i] = null;
        }
    }

    TrieNode insert(TrieNode root,String key, int max){
        int len = key.length();
        TrieNode ptr_root = root;
        for(int i=0;i<len;i++){
            int index = (int)key.charAt(i)-48;
            if(ptr_root.children[index] == null)
                ptr_root.children[index] = new TrieNode(max);
            ptr_root = ptr_root.children[index];
        }
        ptr_root.isEndOfWord = true;
        return root;
    }

    boolean search(TrieNode root,String key){
        if(key == null || key.length() == 0)
            return false;
        int len = key.length();
        TrieNode ptr_root = root;
        for(int i=0;i<len;i++){
            int index = key.charAt(i)-'a';
            if(ptr_root.children[index] == null)
                return false;
        }
        if(ptr_root != null && ptr_root.isEndOfWord)
            return true;
        return false;
    }
}
