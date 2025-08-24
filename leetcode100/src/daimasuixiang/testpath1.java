package daimasuixiang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testpath1 {
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static void dfs(List<LinkedList<Integer>> graph , int x, int n){
        if (x==n){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int xnext : graph.get(x)){
            path.add(xnext);
            dfs(graph,xnext,n);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<LinkedList<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<>());
        }

        while (m-->0){
            int s = sc.nextInt();
            int t = sc.nextInt();
            graph.get(s).add(t);
        }

        path.add(1);
        dfs(graph,1,n);

        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> pa :result){
            for (int i = 0; i < pa.size()-1; i++) {
                System.out.print(pa.get(i)+" ");
            }
            System.out.println(pa.get(pa.size()-1));
        }


    }
}
