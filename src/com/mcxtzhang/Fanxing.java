package com.mcxtzhang;

import java.lang.reflect.ParameterizedType;

/**
 * Intro:  在子类中 获取泛型的实际Class
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/2.
 * History:
 */

class Parent<T> {
    public void method() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()));

        System.out.println(entityClass);
    }
}


public class Fanxing extends Parent<String> {
    public static void main(String[] args) {
        new Fanxing().method();
        //new Parent<>().method();

    }
}

class ShopGoods{
    private String shopcartGoodsId;
    private int supplierId;
    private String supplierShortName;
    private int offerType;
    private String offerName;
    private boolean checked;
    private int buyNum;
    private long shopcartTime;

    public ShopGoods setShopcartGoodsId(String shopcartGoodsId) {
        this.shopcartGoodsId = shopcartGoodsId;
        return this;
    }

    public ShopGoods setSupplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public ShopGoods setSupplierShortName(String supplierShortName) {
        this.supplierShortName = supplierShortName;
        return this;
    }

    public ShopGoods setOfferType(int offerType) {
        this.offerType = offerType;
        return this;
    }

    public ShopGoods setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public ShopGoods setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }

    public ShopGoods setBuyNum(int buyNum) {
        this.buyNum = buyNum;
        return this;
    }

    public ShopGoods setShopcartTime(long shopcartTime) {
        this.shopcartTime = shopcartTime;
        return this;
    }
}
