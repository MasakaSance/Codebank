package com.work.shuzu;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: 添加所有在新区间左侧且不重叠的区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: 合并所有与新区间重叠的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // 插入合并后的区间

        // Step 3: 添加剩余的不重叠区间
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // 转换为二维数组返回
        return result.toArray(new int[result.size()][]);
    }
}
