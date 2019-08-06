package jianzhioffer.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * created by reedfan on 2019/8/1 0001
 */
public class Nqueue {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = (new Nqueue()).solveNqueues(n);
        for (List<String> board : res) {
            printBoard(board);
        }
    }

    private static void printBoard(List<String> board) {
        for (String s : board)
            System.out.println(s);
        System.out.println();
    }

    public List<List<String>> solveNqueues(int n) {

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        LinkedList<Integer> row = new LinkedList<Integer>();
        putQueen(n, 0, row);
        return res;
    }

    private void putQueen(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }

        }
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        assert (row.size() == n);
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }


}
