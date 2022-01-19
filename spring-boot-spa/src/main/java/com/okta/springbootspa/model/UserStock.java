package com.okta.springbootspa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@IdClass(Chave.class)
@Table(name = "users_stocks_balances")
public class UserStock implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @Id
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private Long volume;
    private Timestamp created_on;
    private Timestamp updated_on;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId_stock() {
        return id_stock;
    }

    public void setId_stock(Long id_stock) {
        this.id_stock = id_stock;
    }

    public String getStock_symbol() {
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    public UserStock(User user, Long id_stock, String stock_symbol, String stock_name, Long volume) {
        this.user = user;
        this.id_stock = id_stock;
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_stock == null) ? 0 : id_stock.hashCode());
        return result();
    }

    private int result() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserStock other = (UserStock) obj;
        if (id_stock== null) {
            if (other.id_stock != null)
                return false;
        } else if (!id_stock.equals(other.id_stock))
            return false;
        return true;

    }

    public UserStock() {
        this.created_on = Timestamp.valueOf(LocalDateTime.now());
        this.updated_on = Timestamp.valueOf(LocalDateTime.now());
    }


}
