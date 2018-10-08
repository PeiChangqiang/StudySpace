package com.pcq.factory;

public class ProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        char flag = productNo.charAt(0);
        IProductFactory iProductFactory = null;
        switch (flag) {
            case '0' :
                iProductFactory = new ProductFactory1();
                break;
            case '1' :
                iProductFactory = new ProductFactory2();
                break;
            case '2' :
                iProductFactory = new ProductFactory3();
                break;
            default: break;
        }
        if(iProductFactory != null) {
            iProductFactory.createProduct(productNo);
        }
        return null;
    }
}
