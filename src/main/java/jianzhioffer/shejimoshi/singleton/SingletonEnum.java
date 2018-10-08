package jianzhioffer.shejimoshi.singleton;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 10:57
 */

public enum SingletonEnum {
    SingletionEnum("单例的枚举方式");

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;
    private SingletonEnum(String str){
        this.setStr(str);

    }




}
