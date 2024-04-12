package com.itwill.class06;

public class ClassMain06 {

    public static void main(String[] args) {
    	Account ac1 = new Account(1, 0);
    	ac1.info();
    	ac1.deposit(3000);
    	ac1.info();
    	ac1.deposit(7000);
    	ac1.info();
    	ac1.withdraw(5000);
    	ac1.info();
    	Account ac2 = new Account(2, 0);
    	ac2.info();
    	ac1.transfer(5000, ac2);
    	ac1.info();
    	ac2.info();
    }
}