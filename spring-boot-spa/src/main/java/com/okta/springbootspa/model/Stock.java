//package com.okta.springbootspa.model;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//    public class Stock {
//
//        private Long id;
//        private String stock_symbol;
//        private String stock_name;
//
//        public double getAsk_min() {
//            return ask_min;
//        }
//
//        public void setAsk_min(double ask_min) {
//            this.ask_min = ask_min;
//        }
//
//        public double getAsk_max() {
//            return ask_max;
//        }
//
//        public void setAsk_max(double ask_max) {
//            this.ask_max = ask_max;
//        }
//
//        public double getBid_min() {
//            return bid_min;
//        }
//
//        public void setBid_min(double bid_min) {
//            this.bid_min = bid_min;
//        }
//
//        public double getBid_max() {
//            return bid_max;
//        }
//
//        public void setBid_max(double bid_max) {
//            this.bid_max = bid_max;
//        }
//
//        private double ask_min;
//        private double ask_max;
//        private double bid_min;
//        private double bid_max;
//        private Timestamp created_on;
//        private Timestamp updated_on;
//
//
//
//        public Long getID() {
//            return id;
//        }
//
//        public void setID(Long id) {
//            this.id = id;
//        }
//
//        public Timestamp getUpdated_on() {
//            return updated_on;
//        }
//
//        public void setUpdated_on(Timestamp updated_on) {
//            this.updated_on = updated_on;
//        }
//
//        public Timestamp getCreated_on() {
//            return created_on;
//        }
//
//        public void setCreated_on(Timestamp created_on) {
//            this.created_on = created_on;
//        }
//
//        public String getStock_name() {
//            return stock_name;
//        }
//
//        public void setStock_name(String stock_name) {
//            this.stock_name = stock_name;
//        }
//
//        public String getStock_symbol() {
//            return stock_symbol;
//        }
//
//        public void setStock_symbol(String stock_symbol) {
//            this.stock_symbol = stock_symbol;
//        }
//
//        @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + ((id == null) ? 0 : id.hashCode());
//            return result();
//        }
//
//        private int result() {
//            return 0;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)
//                return true;
//            if (obj == null)
//                return false;
//            if (getClass() != obj.getClass())
//                return false;
//            Stock other = (Stock) obj;
//            if (id == null) {
//                if (other.id != null)
//                    return false;
//            } else if (!id.equals(other.id))
//                return false;
//            return true;
//
//        }
//
//        public Stock() {
//            this.created_on = Timestamp.valueOf(LocalDateTime.now());
//            this.updated_on = Timestamp.valueOf(LocalDateTime.now());
//        }
//    }
//
//
