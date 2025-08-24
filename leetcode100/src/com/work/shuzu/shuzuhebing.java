package com.work.shuzu;

class shuzuhebing {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int a = 0;
        int finish = 0;//表示出现过cb区间 后面的不用比
        int[][] result = new int[length+1][2];

        if(length == 0) {
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }




        for(int i=0;i < length;i++){
            if(intervals[i][1] < newInterval[0]  || finish >0 ){
                result[a][0] = intervals[i][0];
                result[a][1] = intervals[i][1];
                a++;
                if(i == length-1){
                    result[a][0] = newInterval[0];
                    result[a][1] = newInterval[1];
                    a++;
                }

            }

            if(intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
                if(i == length-1){
                    result[a][0] = newInterval[0];
                    result[a][1] = newInterval[1];
                    a++;
                }

            }

            if(intervals[i][0] > newInterval[1]){
                result[a][0] = newInterval[0];
                result[a][1] = newInterval[1];
                a++;
                finish++;
                if(i == length-1){
                    result[a][0] = intervals[i][0];
                    result[a][1] = intervals[i][1];
                    a++;
                }
            }
        }

        int[][] over = new int[a][2];
        for(int j = 0;j < a;j++){
            over[j][0] = result[j][0];
            over[j][1] = result[j][1];
        }

        return over;
    }
}
