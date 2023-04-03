/**
   This program is part of the car dealership simulation.
   It takes a linked list of salesperson names and performs a series of manipulations to it such as add, remove, filter, and sort by specfied circumstances.
*/
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class SalesTeam {

   // instance variable
   private LinkedList<String> salesTeam;
   
   //A default constructor method that initializes to blank values
   public SalesTeam() {
      salesTeam = new LinkedList<String>();
   }

   /**
      A constructor method that initializes to given values
      @param salesTeam LinkedList<String>
   */
   public SalesTeam(LinkedList<String> salesTeam) {
      this.salesTeam = salesTeam;
   }
   
   /**
      This method adds new salesperson name to the list
      @param name the salesperson's name
   */
   public void addSalesperson(String name) {
      salesTeam.add(name);
   }

   /**
      This method gets all the salesperson names
      @return the name of all the salespersons
   */
   public String getAllSalespersons() {
      ListIterator<String> iterator = salesTeam.listIterator();
      String name = "";
      while (iterator.hasNext()) {
         name = name + iterator.next() + " ";
      }
      return name;
   }

   /**
      This method gets a random salesperson name, in the list, by way of using a random generator
      @return the name of salesperson 
   */
   public String getRandomSalesperson() {
      Random random = new Random();
      ListIterator<String> iterator = salesTeam.listIterator();
      int counter = 0;
      String name = "";
      
      int index = random.nextInt((6-1)+1)+1;
      while (iterator.hasNext()) {
         counter++;
         if (counter == index) {
            name = iterator.next();
         }
         else {
            iterator.next();
         }
      }
      return name;
   }

   /**
      This method gets the number of salespersons 
      @return the number of salespersons 
   */
   public int getNumSalespersons() {
      ListIterator<String> iterator = salesTeam.listIterator();
      int counter = 0;
      while (iterator.hasNext()) {
         iterator.next();
         counter++;
      }
      return counter;
   } 

   /**
       This method gets the ith salesperson  
      @param ith the chosen ith number 
   */
   public String getIthSalesperson(int ith) {
      ListIterator<String> iterator = salesTeam.listIterator();
      int counter = 0; 
      String name = "";
      while (iterator.hasNext()) {
         counter++;
         if (counter == ith) {
            name = iterator.next();
         }
         else {
            iterator.next();
         }
      }
      return name;
   }

}
