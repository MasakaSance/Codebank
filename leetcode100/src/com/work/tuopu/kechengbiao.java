package com.work.tuopu;

import java.util.*;

public class kechengbiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> umap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            umap.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            umap.get(s).add(t);
            indegree[t]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0){
                queue.add(i);
            }
        }

        //BFS
        int visit = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            visit++;

            for (int file:umap.get(curr)){
                indegree[file]--;
                if (indegree[file] == 0){
                    queue.add(file);
                }
            }
        }

        System.out.println(visit == n);
    }

}
