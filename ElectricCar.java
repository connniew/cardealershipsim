/**
   This part of the car dealership simulator sets, gets, and compares an electric car's classifications.
*/

public class ElectricCar extends Car {

   // instance variables
   private int rechargeTime;
   private String batteryType;

   // A default constructor method that initalizes new variables and inherited variables from superclasses Vehicle and Car to blank values.  
   public ElectricCar() {
      super();
      rechargeTime = 0;
      batteryType = "UNKNOWN";
   }

   /**
       A constructor method that initalizes new variables and inherited variables from superclasses Vehicle and Car to given values.
      @param VIN the vehicle identification number
      @param mfr the vehicle manufacturer name
      @param color the color 
      @param power the power type
      @param numWheels the number wheels
      @param model the model
      @param maxRange the max range
      @param safetyRating the safety rating
      @param AWD the all-wheel drive classification
      @param price the price
      @param rechargeTime the recharging time in minutes 
      @param batteryType the electric car's battery type
   */
   public ElectricCar(int VIN, String mfr, String color, String power, int numWheels, String model, int maxRange, double safetyRating, boolean AWD, double price, int rechargeTime, String batteryType) {
      super(VIN, mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price);
      this.rechargeTime = rechargeTime;
      this.batteryType = batteryType;
   }

   /**
      Accessor method for the recharge time in minutes
      @return the recharge time
   */
   public int getRechargeTime() {
      return rechargeTime;
   }

   /**
      Accessor method for the battery classification
      @return the electric car's battery type
   */
   public String getBatteryType() {
      return batteryType;
   }

   /**
      Mutator method to set the recharge duration
      @param rechargeTime the recharge time
   */
   public void setRechargeTime(int rechargeTime) {
      this.rechargeTime = rechargeTime;
   }

   /**
      Mutator method to set the battery classification
      @param batteryType the electric car's battery type
   */
   public void setBatteryType(String batteryType) {
      this.batteryType = batteryType;
   }

   /**
      Displays a string representation of the object
      @return string representation
   */
   public String display() {
      return super.display() + " RCH: " + rechargeTime + " BAT: " + batteryType;
   }
}
