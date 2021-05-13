package com.geekbrains.lesson11_hibernate.homework;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order {

    @Embeddable
    public static class Id implements Serializable {
        static final long serialVersionUID = 1L;

        @Column(name = "buyer_id")
        int buyerId;
        @Column(name = "product_id")
        int productId;

        public int getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(int buyerId) {
            this.buyerId = buyerId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "buyerId=" + buyerId +
                    ", productId=" + productId +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj==null || getClass() != obj.getClass()) return  false;
            Id id = (Id) obj;
            return buyerId == id.buyerId &&
                    productId == id.productId;
        }

        @Override
        public int hashCode() {
            return buyerId + productId;
        }
    }
    @EmbeddedId
    private Id id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", insertable = false, updatable = false)
    private Buyer buyer;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "product_price")
    private int productPrice;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", product=" + product +
                ", productPrice=" + productPrice +
                '}';
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
