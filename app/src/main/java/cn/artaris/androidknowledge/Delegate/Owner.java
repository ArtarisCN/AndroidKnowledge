package cn.artaris.androidknowledge.Delegate;

/**
 * delegate
 * LeetCode
 * 2019.03.19.16:41
 *
 * @author : artairs
 */
class Owner implements Sales {
    @Override
    public void sell() {
        System.out.println("我是房东我正在出售我的房产");
    }

    @Override
    public void buy() {
        System.out.println("我是房东我正在买菜");
    }
}
