package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name =="") {
            throw new IllegalArgumentException();
        }
        this.name = name;
        if (price  == null) {
            throw new IllegalArgumentException();
        }
        if (price < "0") throw new IllegalArgumentException();
        this.price = price;

        this.taxPercent = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return price.add(taxPercent.multiply(price));
    }
}
