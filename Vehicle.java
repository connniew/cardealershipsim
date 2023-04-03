/**
   This part of the car dealership simulator sets, gets, and compares a vehicle's classifications. 
*/
import java.util.Random;

public class Vehicle {
   
   // instance variables
   private String mfr;
   private String color;
   private String power;
   private int numWheels;
   private int VIN;
   Random random = new Random();

   //A default constructor method that initializes to blank values
   public Vehicle() {
      VIN = random.nextInt((499-100) + 1) + 100;
      mfr = "UNKNOWN";
      color = "UNKNOWN";
      power = "UNKNOWN";
      numWheels = 0;
   }

   /**
      A constructor method that initializes to given values
      @param VIN the vehicle identification number
      @param mfr the vehicle manufacturer name
      @param color the color 
      @param power the power type 
      @param numWheels the number wheels
   */
   public Vehicle(int VIN, String mfr, String color, String power, int numWheels) {
      this.VIN = random.nextInt((499-100) + 1) + 100;
      this.mfr = mfr;
      this.color = color;
      this.power = power;
      this.numWheels = numWheels;
   }

   /**
      Accessor method for the manufacturer name of vehicle
      @return the vehicle manufacturer name
   */
   public String getManufacturer() {
      return mfr;
   }

   /**
      Accessor method for the color of vehicle
      @return the color
   */
   public String getColor() {
      return color;
   }

   /**
      Accessor method for the type of vehicle power
      @return the power type
   */
   public String getPower() {
      return power;
   }

   /**
      Accessor method for the number of wheels on vehicle
      @return the number of wheels
   */
   public int getNumberOfWheels() {
      return numWheels;
   }

   /**
      Accessor method for the vehicle identification number (VIN) of vehicle
      @return the VIN
   */
   public int getVIN() {
      return VIN;
   }

   /**
      Mutator method to set the vehicle manufacturer name
      @param mfr the manufacturer name
   */
   public void setManufacturer(String mfr) {
      this.mfr = mfr;
   }

   /**
      Mutator method to set the color of vehicle
      @param color the color 
   */
   public void setColor(String color) {
      this.color = color;
   }

   /**
      Mutator method to set power type for vehicle
      @param power the type of power
   */
   public void setPower(String power) {
      this.power = power;
   }

   /**
      Mutator method to set the number of wheels for vehicle
      @param numWheels the number of wheels
   */
   public void setNumberOfWheels(int numWheels) {
      this.numWheels = numWheels;
   }

   /**
      Takes two Vehicle objects and checks for equality by comparing manufacturer, power, and number of wheels. 
       - results in TRUE, if all three characteristics are the same.
       - results in FALSE, if even one characteristic is different.
      @param otherObject the Vehicle object
      @return the boolean value representing the comparison result
   */
   public boolean equals(Object otherObject) {
      Vehicle other = (Vehicle) otherObject;         
      if (this.mfr.equals(other.mfr) && this.power == other.power && this.numWheels == other.numWheels) {
         return true;
      }
      else {
         return false;
      }
   }

   /**
      This method returns a string representation of the object
      @return the string representation
   */
   public String display() {
      return "VIN: " + VIN + " " + mfr + " " + color;
   }
}
