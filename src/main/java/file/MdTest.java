package file;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;

public class MdTest {
    public static void main(String[] args) {

        String path1 ="/Users/qufan/Downloads/code/personal/jianzhioffer/distribution.md";
        String path2 ="/Users/qufan/Downloads/code/personal/jianzhioffer/redis.md";
        String path3 ="/Users/qufan/Downloads/code/personal/jianzhioffer/mysql.md";
        String path4 ="/Users/qufan/Downloads/code/personal/jianzhioffer/basicjava.md";
        String path5 ="/Users/qufan/Downloads/code/personal/jianzhioffer/jvm.md";
        String path6 ="/Users/qufan/Downloads/code/personal/jianzhioffer/mutilthread.md";
        String path7 ="/Users/qufan/Downloads/code/personal/jianzhioffer/os.md";
        String path8 ="/Users/qufan/Downloads/code/personal/jianzhioffer/designpattern.md";
        String path9 ="/Users/qufan/Downloads/code/personal/jianzhioffer/computernetwork.md";
        String path10 ="/Users/qufan/Downloads/code/personal/jianzhioffer/dubbo.md";
        String path11 ="/Users/qufan/Downloads/code/personal/jianzhioffer/kafka.md";
        String path12 ="/Users/qufan/Downloads/code/personal/jianzhioffer/jvm.md";
        String path13 ="/Users/qufan/Downloads/code/personal/jianzhioffer/designpattern.md";
        AtxMarkdownToc.newInstance().genTocFile(path1);
        AtxMarkdownToc.newInstance().genTocFile(path2);
        AtxMarkdownToc.newInstance().genTocFile(path3);
        AtxMarkdownToc.newInstance().genTocFile(path4);
        AtxMarkdownToc.newInstance().genTocFile(path5);
        AtxMarkdownToc.newInstance().genTocFile(path6);
        AtxMarkdownToc.newInstance().genTocFile(path7);
        AtxMarkdownToc.newInstance().genTocFile(path8);
        AtxMarkdownToc.newInstance().genTocFile(path9);
        AtxMarkdownToc.newInstance().genTocFile(path10);
        AtxMarkdownToc.newInstance().genTocFile(path11);
        AtxMarkdownToc.newInstance().genTocFile(path12);
        AtxMarkdownToc.newInstance().genTocFile(path13);




    }
}
