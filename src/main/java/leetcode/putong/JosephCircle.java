package leetcode.putong;

/**
 * https://blog.csdn.net/weixin_38214171/article/details/80352921
 */

public class JosephCircle {


    public static void main(String[] args) {
        System.out.println(joseph(5,3));
        System.out.println(LastRemaining_Solution(5,3));
    }

    public static int joseph(int count,int doom){

        int alive = count; //幸存人数
        int number = 0;   //计数，number==dom时，淘汰这个人
        int index = 0;    //下标，为总人数-1

        //0表示这个人在约瑟夫环内，1表示这个人在约瑟夫环外
        int[] circle = new int[count];
        //只要幸存人数>0,则一直进行
        while (alive>0){
            number += 1-circle[index];
            if(number == doom){   //当number==dom时，就要淘汰这个人
                /**
                 * 淘汰一个人分四步
                 * 1.输出这个人的位置
                 * 2.把这个人的状态从圈内0，改为状态1
                 * 3.幸存人数alive--；
                 * 4.计数number归零
                 */
                System.out.println(index+1);
                circle[index] = 1;
                alive--;
                number = 0;
            }

            //与总人数count取余，则可以使index在0~count-1之间 一直循环，达到循环数组的目的
            index = (index+1)%count;
            System.out.println("index="+index);
        }

        if(index == 0){
            return count;
        }
        return index;
    }


    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
     * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
     * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
     * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
     * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * @param n   小朋友的个数
     * @param m    报数
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        int alive = n;

        int[] help = new int[n];

        int index = 0;

        int cur = -1;

        while (alive>0){

            cur+= 1-help[index];

            if(cur == m-1){

                help[index] = 1;
                alive--;
                cur = -1;

            }
            index = (index+1)%n;

        }
        if(index == 0){
            return n-1;
        }
        return index-1;
    }
}
