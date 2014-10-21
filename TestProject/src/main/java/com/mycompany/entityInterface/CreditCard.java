package com.mycompany.entityInterface;

public interface CreditCard {

    boolean equals(Object object);

    int getCardexpire();

    int getCardnumber();

    Integer getCreditid();

    void setCardexpire(int cardexpire);

    void setCardnumber(int cardnumber);

    void setCreditid(Integer creditid);

    String toString();
    
}
