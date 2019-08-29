package leetcode.file;

import java.io.*;

/**
 * Author 范群松.
 * Date：2018/8/21
 * Time: 20:58
 */

public class File1 {
    public static void main(String[] args) {
        String fileName = "D:/data/kafkalogs/test.txt";
        readFileByLines(fileName);
    }


    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            System.out.println("以行为单位读取文件内容，一次读取一整行");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine())!=null){
                System.out.println("line"+line+":"+tempString);
                line ++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
