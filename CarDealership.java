/**
   This program is part of the car dealership simulation.
   It takes an array list of Car objects and performs a series of manipulations to it such as add, remove, filter, and sort by specfied circumstances.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class CarDealership {
   // instance variables
   private ArrayList<Car> cars;
   private Car removedCar =  null;
   private String removedCarTransaction = "";
   private boolean setFilterByAWD = false;
   private boolean setFilterByElectric = false;
   private boolean setFilterByPrice = false;
   private double minPrice = 0; 
   private double maxPrice = 0;
   AccountingSystem accountingSystem = new AccountingSystem();
   int counterForReturns = 0;
   SalesTeam salesTeam = new SalesTeam();

   // A default constructor method that initializes to blank values
   public CarDealership() {
      cars = new ArrayList<Car>();
   }

   /**
      This method takes a reference to an array list of Car objects and 
      adds the Car objects to the instance variable array list in the CarDealership object  
      @param newCars the array list of Cars objects
   */
   public void addCars(ArrayList<Car> newCars) {
      for (int i = 0; i < newCars.size(); i++) {
         cars.add(newCars.get(i));
      }
   }
   
   /**
      This method takes a reference to a linked list of salesperson names and
      adds the names to the instance variable linked list in the CarDealership object  
      @param salesTeam the linked list of salesperson names
   */
   public void addSalespersons(LinkedList<String> salesperson) {
      ListIterator<String> iterator = salesperson.listIterator();
      while (iterator.hasNext()) {
         salesTeam.addSalesperson(iterator.next());
      }
  }

   /**
      This method removes Car with the given VIN from the array list and returns a reference to it.
      @param VIN the index of Car object
      @return the string representation of transaction
   */
   public String buyCar(int VIN) {
      if (cars.size() > 0) {
         boolean found = false;
         for (int i = 0; i < cars.size(); i++) {
            if (VIN == cars.get(i).getVIN()) {
               //randomize date
               Random random = new Random();
               int month = random.nextInt((Calendar.DECEMBER - Calendar.JANUARY) + 1) + Calendar.JANUARY;
               int day = random.nextInt((31-1)+1)+1;
               GregorianCalendar date = new GregorianCalendar(2019, month, day);
               //adds found VIN to accounting system
               removedCar = cars.get(i);
               removedCarTransaction = accountingSystem.add(date, 0, removedCar, salesTeam.getRandomSalesperson(), "BUY", removedCar.getPrice());
               cars.remove(i);
               found = true;
            }
         }
         //exception is thrown, if no matching VIN is found
         if (!found) {
            throw new IllegalArgumentException("VIN number does not match available vehicles. ");
         }
      }
      //exception is thrown, if empty array list of cars
      else {
         throw new IllegalArgumentException("There are no cars in the list, please 'ADD' first");
      }
      return removedCarTransaction;
   }

   /**
      gets the number of cars returned
      @return the number 
   */
   public int getNumCarsReturned() {
      return counterForReturns;
   }

   /**
      gets the accounting system
      @return the accounting system
   */
   public AccountingSystem getAccountingSystem() {
      return accountingSystem;
   }

   /**
      gets the returned car transaction
      @return the removed transaction
   */	
   public String getRemovedCarTransaction() {
      counterForReturns++;
      return removedCarTransaction;
   }

   /**
      This method takes the reference of the removed (bought) Car object and adds it back to the array list 
    */
   public void returnCar() {
      if (removedCar != null) {
         cars.add(removedCar);
         removedCar = null;
      }
      else {
         throw new NullPointerException("There was no car to return");
      }
   }

   /**
      This method prints information about cars in the array list based on the setting of filter values
      If no filters are set, it prints information for all car objects in the array
   */
   public void displayInventory() {	
      // print all-wheel drive cars only
      if (setFilterByAWD == true && setFilterByElectric == false && setFilterByPrice == false) {
         for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getAWD() == true) {
               System.out.println(cars.get(i).display());
             }
         }
      }
      
      // print electric cars only
      else if (setFilterByAWD == false && setFilterByElectric == true && setFilterByPrice == false) { 
         for (int i = 0; i < cars.size(); i++) {
          if (cars.get(i).getPower().equals("ELECTRIC_MOTOR")) {
               System.out.println(cars.get(i).display());
             }
         }
      }

      // print cars in the given price range
      else if (setFilterByAWD == false && setFilterByElectric == false && setFilterByPrice == true) {
         for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPrice() >= minPrice && cars.get(i).getPrice() <= maxPrice) {
               System.out.println(cars.get(i).display());
             }
         }
      }
      
      // print electric all-wheel drive cars
      else if (setFilterByAWD == true && setFilterByElectric == true && setFilterByPrice == false) {
         for (int i = 0; i < cars.size(); i++) {
            if ((cars.get(i).getAWD() == true) && (cars.get(i).getPower().equals("ELECTRIC_MOTOR"))) {
               System.out.println(cars.get(i).display());
             }
          }
      }

      // print all-wheel drive cars in the given price range
      else if (setFilterByAWD == true && setFilterByElectric == false && setFilterByPrice == true) {
         for (int i = 0; i < cars.size(); i++) {
            if ( (cars.get(i).getAWD() == true) && 
            (cars.get(i).getPrice() >= minPrice && cars.get(i).getPrice() <= maxPrice) ) {
               System.out.println(cars.get(i).display());
             }
          }
      }

      // print electric cars in the given price range
      else if (setFilterByAWD == false && setFilterByElectric == true && setFilterByPrice == true) {
         for (int i = 0; i < cars.size(); i++) {
            if ( (cars.get(i).getPower().equals("ELECTRIC_MOTOR")) && 
            (cars.get(i).getPrice() >= minPrice && cars.get(i).getPrice() <= maxPrice) ) {
               System.out.println(cars.get(i).display());
             }
         }
      }

      // print electric, all-wheel drive cars in the given price range
      else if (setFilterByAWD == true && setFilterByElectric == true && setFilterByPrice == true) {
         for (int i = 0; i < cars.size(); i++) {
            if ( (cars.get(i).getAWD() == true) && (cars.get(i).getPower().equals("ELECTRIC_MOTOR")) && 
            (cars.get(i).getPrice() >= minPrice && cars.get(i).getPrice() <= maxPrice) ) {
               System.out.println(cars.get(i).display());
            }
         }
      }

      // print all cars in the array list
      else {
         for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).display());
         }
      }

   }
   
   // This method sets the filter to electric cars 
   public void filterByElectric() {
      setFilterByElectric = true;
   }

   // This method sets the filter to all-wheel drive cars
   public void filterByAWD() {
      setFilterByAWD = true;
   }

   /**
      This method sets the filter to cars from given price range
      @param the minimum price of car
      @param the maximum price of car
   */
   public void filterByPrice(double minPrice, double maxPrice) {	
      this.minPrice = minPrice;
      this.maxPrice = maxPrice;
      if (maxPrice < minPrice) {
         System.out.println("The minimum price needs to be less than the max price, please input again in the following form: \n   FPR (minimum price) (maximum price)");
         setFilterByPrice = false;
      }
      else {
         setFilterByPrice = true;
      }
   }

   // This method clears all the filter settings
   public void filtersClear() {
      setFilterByAWD = false;
      setFilterByElectric = false;
      setFilterByPrice = false;
   }

   // This method sorts by price
   public void sortByPrice() {
      Collections.sort(cars);
   }

   // This method sorts by safety rating criteria
   public void sortBySafetyRating() {
      Collections.sort(cars, new sortSR());
   }

   // This is the inner class that implements the Comparator interface for safety rating sorting
   class sortSR implements Comparator<Car> {
      public int compare(Car a, Car b) {
         if (a.getSafetyRating() > b.getSafetyRating()) {
            return -1;
         }
         else if (a.getSafetyRating() < b.getSafetyRating()) {
            return 1;
         }
         else {
            return 0;
         }
      }
   }

   // This method sorts by max range criteria
   public void sortByMaxRange() {
      Collections.sort(cars, new sortMR());
   }

   // This is the inner class that implements the Comparator interface for max range sorting
   class sortMR implements Comparator<Car> {
      public int compare(Car a, Car b) {
         if (a.getMaxRange() > b.getMaxRange()) {
            return -1;
         }
         else if (a.getMaxRange() < b.getMaxRange()) {
            return 1;
         }
         else {
            return 0;
         }
      }
   }

}