import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Represents an insurance policy for one person.
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; 
    private double weight; 
    /**
     * Constructs a new Policy with default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "";
        this.height = 0.0;
        this.weight = 0.0;
    }   
    /**
     * Constructs a new Policy with specified attributes.
     *
     * @param policyNumber   The policy number.
     * @param providerName   The name of the insurance provider.
     * @param firstName      The first name of the policyholder.
     * @param lastName       The last name of the policyholder.
     * @param age            The age of the policyholder.
     * @param smokingStatus  The smoking status of the policyholder ("smoker" or "non-smoker").
     * @param height         The height of the policyholder in inches.
     * @param weight         The weight of the policyholder in pounds.
     */
    // Constructor with arguments
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }
    // Getters and setters
    
    // Getters and setters with Javadoc comments

    /**
     * Gets the policy number.
     *
     * @return The policy number.
     */
    public String getPolicyNumber() {
        return policyNumber;
    }
    /**
     * Sets the policy number.
     *
     * @param policyNumber The policy number to set.
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    /**
     * Gets the name of the insurance provider.
     *
     * @return The name of the insurance provider.
     */

    public String getProviderName() {
        return providerName;
    }
    /**
     * Sets the name of the insurance provider.
     *
     * @param providerName The name of the insurance provider to set.
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
     /**
     * Gets the first name of the policyholder.
     *
     * @return The first name of the policyholder.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name of the policyholder.
     *
     * @param firstName The first name of the policyholder to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the last name of the policyholder.
     *
     * @return The last name of the policyholder.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the policyholder.
     *
     * @param lastName The last name of the policyholder to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Gets the age of the policyholder.
     *
     * @return The age of the policyholder.
     */
    public int getAge() {
        return age;
    }
    /**
     * Sets the age of the policyholder.
     *
     * @param age The age of the policyholder to set.
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Gets the smoking status of the policyholder.
     *
     * @return The smoking status of the policyholder.
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }
    /**
     * Sets the smoking status of the policyholder.
     *
     * @param smokingStatus The smoking status of the policyholder to set.
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    /**
     * Gets the height of the policyholder in inches.
     *
     * @return The height of the policyholder in inches.
     */  
    public double getHeight() {
        return height;
    }
    /**
     * Sets the height of the policyholder in inches.
     *
     * @param height The height of the policyholder to set.
     */  
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     * Gets the weight of the policyholder in pounds.
     *
     * @return The weight of the policyholder in pounds.
     */  
    public double getWeight() {
        return weight;
    }
    /**
     * Sets the weight of the policyholder in pounds.
     *
     * @param weight The weight of the policyholder to set.
     */  
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /**
     * Calculates the BMI (Body Mass Index) of the policyholder.
     *
     * @return The BMI of the policyholder.
     */  
    // Method to calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
    /**
     * Calculates the price of the insurance policy.
     *
     * @return The price of the insurance policy.
     */  
    // insurance policy price
    public double calculatePrice() {
        double price = 600;

        if (age > 50) {
            price += 75; 
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100; 
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20; 
        }

        return price;
    }
     /**
     * Main method to interact with the user and display policy information.
     *
     * @param args Command-line arguments (not used).
     */  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Policy policy = new Policy();
        
        System.out.print("Please enter the Policy Number: ");
        policy.setPolicyNumber(scanner.nextLine());

        System.out.print("Please enter the Provider Name: ");
        policy.setProviderName(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s First Name: ");
        policy.setFirstName(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s Last Name: ");
        policy.setLastName(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s Age: ");
        policy.setAge(scanner.nextInt());
        scanner.nextLine(); 
        
        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        policy.setSmokingStatus(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        policy.setHeight(scanner.nextDouble());

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        policy.setWeight(scanner.nextDouble());

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
        System.out.println("Policyholder’s BMI: " + df.format(policy.calculateBMI()));
        System.out.println("Policy Price: $" + df.format(policy.calculatePrice()));
        
        scanner.close();
    }
}
