package com.work.tuopu;


import java.util.*;

public class tuopupaixu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> umap = new ArrayList<>(); // 记录文件依赖关系
        int[] inDegree = new int[n]; // 记录每个文件的入度

        for (int i = 0; i < n; i++)
            umap.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            umap.get(s).add(t); // 记录s指向哪些文件
            inDegree[t]++; // t的入度加一
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                // 入度为0的文件，可以作为开头，先加入队列
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 当前选中的文件
            result.add(cur);
            for (int file : umap.get(cur)) {
                inDegree[file]--; // cur的指向的文件入度-1
                if (inDegree[file] == 0) {
                    queue.add(file);
                }
            }
        }

        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
