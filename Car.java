/**
   This part of the car dealership simulator sets, gets, and compares a car's classifications.
*/

public class Car extends Vehicle implements Comparable<Car> {

   //instance variable
   private String model;
   private int maxRange;
   private double safetyRating;
   private boolean AWD;
   private double price;

   //A default constructor method that initializes to blank values
   public Car() {
      super();
      model = "";
      maxRange = 0;
      safetyRating = 0.0;
      AWD = false;
      price = 0.0;
   }

   /** 
      A constructor method that initializes to given values
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
   */   
   public Car(int VIN, String mfr, String color, String power, int numWheels,  String model, int maxRange,  double safetyRating, boolean AWD, double price) {
      super(VIN, mfr, color, power, numWheels);
      this.model = model;
      this.maxRange = maxRange;
      this.safetyRating = safetyRating;
      this.AWD = AWD;
      this.price = price;
   }

   /**
      Accessor method for the model name
      @return the model name
   */
   public String getModel() {
      return model;
   }

   /**
      Accessor method for the max range 
      @return the max range
   */
   public int getMaxRange() {
      return maxRange;
   }

   /**
      Accessor method for the safety rating
      @return the safety rating
   */
   public double getSafetyRating() {
      return safetyRating;
   }

   /**
      Accessor method to determine if car is all-wheel drive 
      @return the boolean value for all-wheel drive classification
   */
   public boolean getAWD() {
      return AWD;
   }

   /**
      Accessor method for the price of car
      @return the price
   */
   public double getPrice() {
      return price;
   }

   /**
      Mutator method to set the model type of car
      @param model the model 
   */
   public void setModel(String model) {
      this.model = model;
   }

   /**
      Mutator method to set the max range
      @param maxRange the max range 
   */
   public void setMaxRange(int maxRange) {
      this.maxRange = maxRange;
   }

   /**
      Mutator method to set the safety rating
      @param safetyRating the safety rating
   */
   public void setSafetyRating(double safetyRating) {
      this.safetyRating = safetyRating;
   }

   /**
      Mutator method to set whether or not it is an all-wheel drive car
      @param AWD the value for all-wheel drive 
   */
   public void setAWD(boolean AWD) {
      this.AWD = AWD;
   }

   /**
      Mutator method to set the price of car
      @param price the price
   */
   public void setPrice(double price) {
      this.price = price;
   }
    
   /**
      This method returns a string representation of the object
      @return string representation
   */
   public String display() {
      return super.display() + " " + model + " RNG: " + maxRange + " SF: " + safetyRating + " " + AWD + " " + price + "$";
   }

   /**
      This method takes two Car objects and checks for equality by comparing manufacturer, power, number of wheels, model, and whether or not it is all-wheel drive.
       - results in TRUE, if all five characteristics are the same.
       - results in FALSE, if even one characteristic is different
      @param otherObject the Car object
      @return the value representing the comparison result
   */
   public boolean equals(Object otherObject) {
      Car other = (Car) otherObject;
      if (this.getManufacturer().equals(other.getManufacturer()) && this.getPower() == other.getPower()
                && this.getNumberOfWheels() == other.getNumberOfWheels() && this.model == other.model
                && this.AWD == other.AWD) {
         return true;
      }
      else {
         return false;
      }
   }

   /**
      This method takes two Car objects and compares the prices of the two.
      @param other the Car object
      @return the value representing the comparison result
   */
   public int compareTo(Car other) {
      if (this.getPrice() < other.getPrice()) {
         return -1;
      }
      else if (this.getPrice() > other.getPrice()) {
         return 1;
      }
      else {
         return 0;
      }
   }

}
