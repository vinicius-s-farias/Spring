package com.okta.springbootspa.model;

import com.okta.springbootspa.keys.Chave;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users_orders")
public class UserOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_order;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User id_user;
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private double price;
    private int type;
    private int status;
    private Long volume;
    private Timestamp created_on;
    private Timestamp updated_on;

    public UserOrder(User id_user,Long id_stock, String stock_symbol, String stock_name,double price, int type, int status, Long volume) {
        this.id_user = id_user;
        this.id_stock = id_stock;
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.price = price;
        this.type = type;
        this.status = status;
        this.volume = volume;
        this.created_on = Timestamp.valueOf(LocalDateTime.now());
        this.updated_on = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrder userOrder = (UserOrder) o;
        return id_order == userOrder.id_order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_order);
    }

    public UserOrder() {

    }
}
