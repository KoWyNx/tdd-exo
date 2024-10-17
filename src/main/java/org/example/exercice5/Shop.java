package org.example.exercice5;

import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update(Product product) {
        product.setSellIn(product.getSellIn() - 1);

        int qualityChange = product.getSellIn() < 0 ? 2 : 1;

        if (product.getType().equals("brie")) {
            if (product.getQuality() < 50) {
                product.setQuality(Math.min(50, product.getQuality() + qualityChange));
            }
        } else if (product.getType().equals("laitier")) {
            if (product.getQuality() > 0) {
                product.setQuality(Math.max(0, product.getQuality() - qualityChange * 2));
            }
        } else {
            if (product.getQuality() > 0) {
                if (product.getQuality() < 50) {
                    product.setQuality(Math.max(0, product.getQuality() - qualityChange));
                }
            }
        }

        if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }
}
