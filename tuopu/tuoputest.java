package com.work.tuopu;

public class tuoputest {
    //首先接受变量n 节点数   变量m  多少条边
    //创建umap记录依赖关系 并n遍历创建arraylist
    //创建indgree 记录入度
    //循环m接收变量s和t 表示从s指向t  umap.get(s).add(t)    indegree[t]++
    //创建排序队列queue LinkList  循环n 如果i的入度=0 queue.add(i)
    //创建结果列表result arraylist
    //拓扑排序 queue中不空 int current = queue.poll()     result.add(current)
    //遍历current指向的节点   for(int file :umap.get(current))   indegree[file]--
    //if indegree[file]=0     queue.add(file) 继续拓扑排序
    //
}
