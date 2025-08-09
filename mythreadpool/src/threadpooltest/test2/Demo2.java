package threadpooltest.test2;

public class Demo2 {
    public static void main(String[] args) {
        /**向Java虚拟机返回可用的处理器数量*/
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }
}
