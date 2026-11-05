package model;

import java.math.BigDecimal;

public class Client {

    private String name;

    private BigDecimal personalDiscount;//=-1.0;

    public Client(String name, BigDecimal personalDiscount) {
        this.name = name;
        this.personalDiscount = personalDiscount;
    }

    public Client(){}


    public BigDecimal getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(BigDecimal personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return "name: "+name+" discount "+personalDiscount;
    }
}
