package leetcode.dp.jingdianwenti;

public class AscentSequence {
    public static void main(String[] args) {
        int[] test = {2, 1, 4, 3, 1, 5, 6};
        AscentSequence as = new AscentSequence();
        System.out.println(as.findLongest(test));
    }

    public int findLongest(int[] arr) {
        int length = arr.length;
        int cur = 0;
        int[] tmp = new int[length];
        tmp[0] = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] > tmp[cur]) {
                tmp[++cur] = arr[i];
            } else {
                int pos = findpos(tmp, arr[i], 0, cur);
                tmp[pos] = arr[i];
            }
        }
        return cur + 1;
    }

    //寻找num在数组中的位置
    private int findpos(int[] tmp, int num, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (tmp[mid] == num) {
                return mid;
            }
            if (tmp[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}