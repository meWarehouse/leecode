package com.at.test;

public class Test {

    //K路
    int K = 5;
    //最小值 b[K]存放一个比所有记录都小的值，作为虚结点
    int min = Integer.MIN_VALUE;

    //叶子节点的值
    int[] k = new int[]{17,5,10,39,15,min};
    //失败者的序号
    int[] ls = new int[K];

    public static void main(String[] args) {


//
//        void Adjust(int s)
//        {
//            for (int t = (s + K) / 2; t > 0; t = t / 2)
//            {
//                if (b[s] > b[ls[t]])	//如果待调整结点大于父结点指向的元素值，说明目前的b[s]值为败者
//                {
//                    int temp = s;
//                    s = ls[t];		//s永远是指向这一轮比赛最小节点 —— 胜者
//                    ls[t] = temp;	//将败者的索引 —— s赋给父结点
//                }
//            }
//
//            ls[0] = s;	//将最小节点的索引存储在ls[0]
//
//            return;


    }

    public void CreateLoser(){

        //将 ls[0...k-1]=K 表示第K+1(虚设)个并归段的记录当前最小值
        for (int i = 0; i < K; i++) {
            ls[i] = K;
        }

        //从k-1到0，每次加入一个记录进行一次调整，算法自顶向下，直到所有记录加进来
        for (int i = K-1; i >= 0 ; i--) {
            Adjust(i);	//加入一个基点，要进行调整
        }

    }

    private void Adjust(int s) {
        for (int t = (s+K)/2; t > 0 ; t=t/2) {


        }
    }

}
