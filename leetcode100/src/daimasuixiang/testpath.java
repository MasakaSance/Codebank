package daimasuixiang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testpath {
    //定义path和result 两个集合都是ArrayList


    //定义dfs类 List<LinkedList<Integer>>graph x n (n表示有n个节点)
    public static void dfs(List<LinkedList<Integer>> graph,int x,int n){
        //条件1 x==n 时 把path加到result中




        //循环找到x指向的节点xnext ：
        //当xnext不为null时 添加到path中 递归dfs(graph ,xnext,n)
        //当xnext为null时 回溯path.remove(path.size()-1)



    }


    //main函数
    public static void main(String[] args) {
        //首先接受两个输入 n节点数 m路线数量


        //创建graph大小为n+1 再fori添加 graph.add(new LinkedList<>())

        //  条件m-->0  接受路线参数s t  graph.get(s).add(t)

        //path从1开始出发 dfs(graph,1,n)


        //输出结果
        //条件result.isEmpty() sout(-1)

        //for List<Integer> pa : result
     /*    for  i<pa.size()-1
            sout(pa.get(i)+" ")
         sout(pa.get(pa.size()-1)) 最后一项结束没有空格！！！
     */
    }

}
