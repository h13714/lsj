package test2;

public class GoodsTest {
    public static void main(String[] args) {
        Goods[] arr = new Goods[3];
        Goods g1 = new Goods("001","apple",10,10);
        Goods g2 = new Goods("002","banana",20,20);
        Goods g3 = new Goods("003","orange",30,30);
        arr[0] = g1;
        arr[1] = g2;
        arr[2] = g3;
        for (Goods goods : arr) {
            System.out.println(goods.getId() + " " + goods.getName() + " " + goods.getPrice() + " " + goods.getCount());
        }
    }
}
