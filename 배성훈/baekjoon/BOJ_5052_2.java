package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_5052_2 {

    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean isEnd;
        TrieNode(){
            children=new HashMap<>();
            isEnd=false;
        }
    }

    static class Trie{
        TrieNode root;
        Trie(){
            root=new TrieNode();
        }
        boolean insert(String word){
            TrieNode temp=root;
            for(char c:word.toCharArray()){
                temp=temp.children.computeIfAbsent(c,no->new TrieNode());
                if(temp.isEnd)return false;
            }
            if(!temp.children.isEmpty())return false;
            temp.isEnd=true;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        next:
        while(T-->0){
            Trie t=new Trie();
            int n=sc.nextInt();
            sc.nextLine();
            String[] arr=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLine();
            }
            Arrays.sort(arr);
            for(String s:arr){
                if(!t.insert(s)){
                    System.out.println("NO");
                    continue next;
                }
            }
            System.out.println("YES");
        }
    }
}
