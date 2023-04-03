/**
   This program is part of the car dealership simulation.
   Objects of this class store information about the buying of a car or the returning of a car 
*/

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Transaction {
   // instance variables
   private int transactionId;
   private GregorianCalendar date;
   private Car car;
   private String salesperson;
   private String type;
   private double price;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

   // A default constructor method that initializes to blank values
   public Transaction() {
      transactionId = 0;
      car = null;
      salesperson = null;
      type = null;
      price = 0;
   }

   /** 
      A constructor method that initializes to given values
      @param date the date 
      @param transactionId the id
      @param car the car
      @param salesperson the name of salesperson
      @param type the type of transaction
      @param price the price of car
   */
   public Transaction(GregorianCalendar date, int transactionId, Car car, String salesperson, String type, double price) {
      this.date = date;
      this.transactionId = transactionId;
      this.car = car;
      this.salesperson = salesperson;
      this.type = type;
      this.price = price;
   }

   /**
      Accessor method for the transaction ID
      @return the transaction ID
   */
   public int getTransactionId() {
      return transactionId;
   }

   /**
      Mutator method for the transaction ID
      @param transactionId the transaction ID
   */
   public void setTransactionId(int transactionId) {
      this.transactionId = transactionId;
   }

   /**
      Accessor method for the salesperson's name
      @return the salesperson
   */
   public String getSalesperson() {
      return salesperson;
   }

   /**
      Accessor method for the car's price
      @return the price
   */
   public double getPrice() {
      price = car.getPrice();
      return price;
   }

   /**
      Accessor method for the month of transaction
      @return the month
   */
   public int getMonth() {
      return date.get(Calendar.MONTH);
   }

   /**
      This method returns a string representation of the object
      @return string representation
   */
   public String display() {
      return "ID: " + transactionId + " " + sdf.format(date.getTime()) + " " + type + " SalesPerson: " + salesperson + " Car: " + car.display();
   }

}



























/** 
public class Transaction {
   //instance variables
   private int transactionId;
   //date
   //Car object
   private String salespersonName;
   private TransactionType transactionType;
   //transaction sales price 

   //initializes constants
   public enum TransactionType {
      BUY, RETURN;
   }

   public Transaction() {
      transactionId = 0;
      salespersonName = "UNKNOWN";
      transactionType = TransactionType.BUY;
   }

   public Transaction(int transactionId, String salespersonName, TransactionType transactionType) {
      this.transactionId = transactionId;
      this.salespersonName = salespersonName;
      this.transactionType = transactionType;
   }

   public String display() {
      
   }
}
*/