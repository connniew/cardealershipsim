/**
   This program is part of the car dealership simulation.
   It holds an array list of Transaction objects and performs a series of manipulations to it such as add, get, and sort by specfied circumstances.
*/
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class AccountingSystem {
   // instance variables
   private ArrayList<Transaction> accountingSystem;

   //A default constructor method that initializes to blank values
   public AccountingSystem() {
      accountingSystem = new ArrayList<Transaction>();
   }

   /**
       A constructor method that initializes to given values
      @param accountingSystem the accouting system
   */
   public AccountingSystem(ArrayList<Transaction> accountingSystem) {
      this.accountingSystem = accountingSystem;
   }

   /**
      This method takes in information to create a Transaction and finally adds it to the array list
      @param date the date 
      @param transactionId the id 
      @param car the car
      @param salesPerson the assigned salesperson
      @param type the type
      @param salePrice the price 
      @return the string represntation of Transaction object
   */
   public String add(GregorianCalendar date, int transactionId, Car car, String salesPerson, String type, double salePrice) {
      Transaction transaction = new Transaction(date, transactionId, car, salesPerson, type, salePrice);
      Random random = new Random();

      int index = random.nextInt((99-1)+1)+1;
      transaction.setTransactionId(index);
      accountingSystem.add(transaction);
      return transaction.display();
   }

   /**
       Takes in a transaction id and searches through all the Transaction objects to find one with a matching id.
      @param id the chosen transaction id
      @return the transaction object
   */
   public String getTransactionById(int transactionId) {
      Transaction transaction = null;
      String found = null;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         transaction = accountingSystem.get(i);
         if (transaction.getTransactionId() == transactionId) {
            found = accountingSystem.get(i).display();
         }
      }
      return found;
   } 

   /**
      Counts number of cars sold by salesperson
      @param name the salesperson's name
      @return the number of transactions
   */
   public int getTransactionBySalesperson(String name) {
      Transaction transaction = null;
      int counter = 0;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         transaction = accountingSystem.get(i);
         if (transaction.getSalesperson().equals(name)) {
            counter++;
         }
      }
      return counter;
   } 
    
   /**
      Gets the number of cars sold
      @return the number of transactions
   */
   public int getNumCarsSold() {
      return accountingSystem.size();
   }

   /**
      Gets all transactions in accounting system
      @return the string representation of transactions
   */
   public String getAllTransactions() {
      String transaction = "";
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         transaction = transaction + accountingSystem.get(i).display() + "\n";
      }
      return transaction;
   }

   /**
       Gets total of price of all cars sold
      @return the total price
   */
   public double getTotalSoldPrice() {
      double price = 0;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         price = price + accountingSystem.get(i).getPrice();
      }
      return price;
   }
    
   /**
      Gets the average sales in month
      @param monthNum the integer correlating to desired month
      @return the average price 
   */
   public double getMonthSalesAvg(int monthNum) {
      double price = 0;
      int counter = 0;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         int month = accountingSystem.get(i).getMonth();
         if (month == monthNum) {
            price = price + accountingSystem.get(i).getPrice();
            counter++;
         }
      }
      return price / counter;
   }

   /**
      Gets the number of cars sold in month
      @param monthNum the integer correlating to desired month (0-11)
      @return the number of cars  
   */
   public int getMonthNumCars(int monthNum) {
      int counter = 0;
      int month = 0;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         month = accountingSystem.get(i).getMonth();
         if (month == monthNum) {
            counter++;
         }
      }
      return counter;
   }
    
   /**
       Gets the all sales in month
      @param monthNum the number correlating to desired month (0-11)
      @return the string representation of transactions
   */
   public String getMonthSales(int monthNum) {
      String chosen = "";
      int month = 0;
      
      for (int i = 0; i < accountingSystem.size(); i++) {
         month = accountingSystem.get(i).getMonth();
         if (month == monthNum) {
            chosen = chosen + accountingSystem.get(i).display() + "\n";
         }
      }
      return chosen;
   }
    
}
