/** 
   This program is the last piece to the car dealership simulation, it is ultimately the object-array assembley and user interaction aspect of the program.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class CarDealershipSimulator 
{
   /**
      This is the main method of the class, the first portion creates Car and ElectricCar objects and adding to an empty array. 
      The second half takes in the user input and displays what is requested through the commands. 
   */
   public static void main(String[] args) throws FileNotFoundException {
      
      CarDealership carDealer = new CarDealership();
      ArrayList<Car> newCars = new ArrayList<Car>();
      AccountingSystem accountingSystem = carDealer.getAccountingSystem();
      Scanner scanner = new Scanner(System.in); 
      double minPrice = 0.0;
      double maxPrice = 0.0;

      //adds salespersons to list
      LinkedList<String> salesTeam = new LinkedList<String>();
      salesTeam.addLast("Charlie");
      salesTeam.addLast("Dennis");
      salesTeam.addLast("Mac");
      salesTeam.addLast("Dee");
      salesTeam.addLast("Frank");
      salesTeam.addLast("Waitress");

      try {
         //gets the 'cars.txt' to be read
         File inputFile = new File("cars.txt");
         Scanner in = new Scanner(inputFile);

         //reads the inforamtion in 'cars.txt' file and creates Car or ElectricCar Objects with data
         Car newCar = null;
         while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner fileData = new Scanner(line);
            int VIN = fileData.nextInt();
            String mfr = fileData.next();
            String color = fileData.next();
            String power = fileData.next();
            //program adapts to data changes based on power 
            if (power.equals("ELECTRIC_MOTOR")) {
               int numWheels = fileData.nextInt();
               String model = fileData.next();
               int maxRange = fileData.nextInt();
               double safetyRating = fileData.nextDouble();
               Boolean AWD = fileData.nextBoolean();
               double price = fileData.nextDouble();
               int rechargeTime = fileData.nextInt();
               String batteryType = fileData.next();
               newCar = new ElectricCar(VIN, mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price, rechargeTime, batteryType);
            }
            else if (power.equals("GAS_ENGINE")){
               int numWheels = fileData.nextInt();
               String model = fileData.next();
               int maxRange = fileData.nextInt();
               double safetyRating = fileData.nextDouble();
               Boolean AWD = fileData.nextBoolean();
               double price = fileData.nextDouble();
               newCar = new Car(VIN, mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price);
            }
            newCars.add(newCar);
            fileData.close();
         }
         in.close();
      }
      //catches when input file doesnt match this program
      catch (FileNotFoundException exception) {
         System.out.println("Could not find required file 'cars.txt'. Please include file with the same name in the folder.");
         return;
      }
      //catches when input file's data doesnt match this program
      catch (NoSuchElementException exception) {
         System.out.println("File 'cars.txt' contents invalid to this program's requirements. \n  For cars: VIN(integer), mfr(String) , color(String) , power(String) , numWheels(integer), model(String), maxRange(integer), safetyRating(double), AWD(boolean), price(double) \n  For electric cars: VIN(integer), mfr(String), color(String), power(String), numWheels(integer), model(String), maxRange(integer), safetyRating(double), AWD(boolean), price(double), rechargeTime(integer), batteryType(String)");
         return;
      }
      //catches from buyCar() method in 'CarDealership.java' when VIN number is not found in list
      catch (IllegalArgumentException exception) {
         System.out.println(exception.getMessage());
      }
      //catches from returnCar() method in 'CarDealership.java', when there is no car to return
      catch (NullPointerException exception) {
         System.out.println(exception.getMessage());
      }

      // check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object, the while loop that reads a line of input from the user
      while(scanner.hasNextLine()) {
         String inputLine = scanner.nextLine();
         if (inputLine == null || inputLine.equals("")) 
         {
            System.out.println();
            continue;
         }
         Scanner commandLine = new Scanner(inputLine);
         String command = commandLine.next();
         if (command == null || command.equals("")) {
            System.out.println();
            continue;
         }
         // if input is 'L' this will display the inventory 
         else if (command.toUpperCase().equals("L")) {
            carDealer.displayInventory();
            System.out.println();
            continue;
         }

         // if input is 'Q' this will quit
         else if (command.toUpperCase().equals("Q") || command.toUpperCase().equals("QUIT")) {
            break;
         }
         
         // if input is 'BUY (index)' this will remove the desired car from the inventory list
         else if (command.toUpperCase().equals("BUY")) {
            int index = commandLine.nextInt();
            System.out.println(carDealer.buyCar(index));
            System.out.println();
            continue;
         }

         // if input is 'RET' this will return the last removed car back into the inventory list
         else if (command.toUpperCase().equals("RET")) {
            carDealer.returnCar();
            String a = carDealer.getRemovedCarTransaction();
            Scanner s = new Scanner(a);
            
            String transactionLabel = s.next();
            int transactionId = s.nextInt();
            s.close();

            System.out.println(carDealer.accountingSystem.getTransactionById(transactionId));
            System.out.println();
            continue;
         }

         // if input is 'ADD' this will load the newCars array (created here) into the array stored in the CarDealership object  
         else if (command.toUpperCase().equals("ADD")) {
            carDealer.addCars(newCars);
            carDealer.addSalespersons(salesTeam);
            System.out.println();
            continue;
         }

         // if input is 'SPR' this will sort and display the cars by price from most expensive to least expensive
         else if (command.toUpperCase().equals("SPR")) {
            carDealer.sortByPrice();
            System.out.println();
            continue;
         }

         // if input is 'SSR' this will sort and display the cars by safety rating from highest rating to lowest rating
         else if (command.toUpperCase().equals("SSR")) {
            carDealer.sortBySafetyRating();
            System.out.println();
            continue;
         }

         // if input is 'SMR' this will sort and display the cars by their max range from highest to lowest
         else if (command.toUpperCase().equals("SMR")) {
            carDealer.sortByMaxRange();
            System.out.println();
            continue;
         }

         // if input is 'FPR (min price) (max price)' this will display the cars in the desired price range
         else if (command.toUpperCase().equals("FPR")) {
            if (!commandLine.hasNextDouble()) {				  
               System.out.println("Invalid arguements");
               continue;
               }
            minPrice = commandLine.nextDouble();
            if (!commandLine.hasNextDouble()) {				  
               System.out.println("Invalid arguements");
               continue;
            }
            maxPrice = commandLine.nextDouble();
            if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {	
               System.out.println("Invalid arguements");
               continue;
            }		
            carDealer.filterByPrice(minPrice, maxPrice);
            System.out.println();
            continue;
         }

         // if input is 'FEL' this will display only the electric cars
         else if (command.toUpperCase().equals("FEL")) {
            carDealer.filterByElectric();
            System.out.println();
            continue;
         }

         // if input is 'FEL' this will display only the all-wheel drive cars
         else if (command.toUpperCase().equals("FAW")) {
            carDealer.filterByAWD();
            System.out.println();
            continue;
         }

         // if input is 'FCL' this will clear all the set filters 
         else if (command.toUpperCase().equals("FCL")) {
            carDealer.filtersClear();
            System.out.println();
            continue;
         }
         
         // if input is 'SALES', this will display all sales
         else if (command.toUpperCase().equals("SALES")) {
            if ((!commandLine.hasNextDouble()) && (!commandLine.hasNext()) && (!commandLine.hasNextInt())) {				  
               System.out.println(carDealer.accountingSystem.getAllTransactions());
               continue;
            }
            // if input is 'SALE (int month)' this will display the sales in the desired month
            else if (commandLine.hasNextInt()) {
               int month = commandLine.nextInt();
               if (month >= 0 && month < 12) {
                  System.out.println(accountingSystem.getMonthSales(month));
               }
               else {
                  System.out.println("Enter integer month between 0-11");
               }
               continue;
            }
            else if (commandLine.hasNext()) {
               String des = commandLine.next();
               // if input is 'SALES TEAM' this will display all the salespersons
               if (des.toUpperCase().equals("TEAM")) {				  
                  System.out.println("Team: " + carDealer.salesTeam.getAllSalespersons());
                  System.out.println();
               }
               // if input is 'SALES TOPSP' this will display the salesperson who sold the most number of cars
               else if (des.toUpperCase().equals("TOPSP")) {
                  Map<String, Integer> topSalesperson = new HashMap<String, Integer>();
                  int charlie = accountingSystem.getTransactionBySalesperson("Charlie");
                  int dennis = accountingSystem.getTransactionBySalesperson("Dennis");
                  int mac = accountingSystem.getTransactionBySalesperson("Mac");
                  int dee = accountingSystem.getTransactionBySalesperson("Dee");
                  int frank = accountingSystem.getTransactionBySalesperson("Frank");
                  int waitress = accountingSystem.getTransactionBySalesperson("Waitress");
      
                  topSalesperson.put("Charlie", charlie);
                  topSalesperson.put("Dennis", dennis);
                  topSalesperson.put("Mac", mac);
                  topSalesperson.put("Dee", dee);
                  topSalesperson.put("Frank", frank);
                  topSalesperson.put("Waitress", waitress);
      
                  int max = Collections.max(topSalesperson.values());
                  Set<String> keySet = topSalesperson.keySet();
                  for (String key : keySet) {
                     if (topSalesperson.get(key) == max) {
                        System.out.println("Top SP: " + key + " " + topSalesperson.get(key));
                     }
                  }
                  System.out.println();
               }
               // if input is 'SALES STATS' this will display total sales, average sales per month, total number of cars sold, highest sales month, total number of car returns	
               else if (des.toUpperCase().equals("STATS")) {
                  // total sales for the year
                  System.out.println("Total Sales: " + accountingSystem.getTotalSoldPrice());
                  System.out.println();

                  // total number of cars sold
                  System.out.println("Total Sold: " + accountingSystem.getNumCarsSold());
                  System.out.println();

                  // average sales per month
                  System.out.println("Avg Sales for Jan: " + accountingSystem.getMonthSalesAvg(0));
                  System.out.println("Avg Sales for Feb: " + accountingSystem.getMonthSalesAvg(1));
                  System.out.println("Avg Sales for Mar: " + accountingSystem.getMonthSalesAvg(2));
                  System.out.println("Avg Sales for Apr: " + accountingSystem.getMonthSalesAvg(3));
                  System.out.println("Avg Sales for May: " + accountingSystem.getMonthSalesAvg(4));
                  System.out.println("Avg Sales for Jun: " + accountingSystem.getMonthSalesAvg(5));
                  System.out.println("Avg Sales for Jul: " + accountingSystem.getMonthSalesAvg(6));
                  System.out.println("Avg Sales for Aug: " + accountingSystem.getMonthSalesAvg(7));
                  System.out.println("Avg Sales for Sept: " + accountingSystem.getMonthSalesAvg(8));
                  System.out.println("Avg Sales for Oct: " + accountingSystem.getMonthSalesAvg(9));
                  System.out.println("Avg Sales for Nov: " + accountingSystem.getMonthSalesAvg(10));
                  System.out.println("Avg Sales for Dec: " + accountingSystem.getMonthSalesAvg(11));
                  System.out.println();

                  // total number of car returns
                  System.out.println("Total Returned: " + carDealer.getNumCarsReturned());
                  System.out.println();

                  //highest sales month and number of cats
                  int jan = accountingSystem.getMonthNumCars(0);
                  int feb = accountingSystem.getMonthNumCars(1);
                  int mar = accountingSystem.getMonthNumCars(2);
                  int apr = accountingSystem.getMonthNumCars(3);
                  int may = accountingSystem.getMonthNumCars(4);
                  int jun = accountingSystem.getMonthNumCars(5);
                  int jul = accountingSystem.getMonthNumCars(6);
                  int aug = accountingSystem.getMonthNumCars(7);
                  int sept = accountingSystem.getMonthNumCars(8);
                  int oct = accountingSystem.getMonthNumCars(9);
                  int nov = accountingSystem.getMonthNumCars(10);
                  int dec = accountingSystem.getMonthNumCars(11);

                  Map<String, Integer> highestMonthSales = new HashMap<String, Integer>();
                  highestMonthSales.put("Jan", jan);
                  highestMonthSales.put("Feb", feb);
                  highestMonthSales.put("Mar", mar);
                  highestMonthSales.put("Apr", apr);
                  highestMonthSales.put("May", may);
                  highestMonthSales.put("Jun", jun);
                  highestMonthSales.put("Jul", jul);
                  highestMonthSales.put("Aug", aug);
                  highestMonthSales.put("Sept", sept);
                  highestMonthSales.put("Oct", oct);
                  highestMonthSales.put("Nov", nov);
                  highestMonthSales.put("Dec", dec);

                  int max = Collections.max(highestMonthSales.values());
                  Set<String> keySet = highestMonthSales.keySet();
                  for (String key : keySet) {
                     if (highestMonthSales.get(key) == max) {
                        System.out.println("Best Month: " + key + ": cars sold - " + highestMonthSales.get(key) );
                     }
                  }
                  System.out.println();
               } 
               continue;
            }
            else {
               System.out.println();
               continue;
            }
         }
         else {	
            System.out.println();
         } 
         commandLine.close();
      }
      scanner.close();
      System.out.println();
   }
}