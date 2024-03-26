import java.text.DecimalFormat;
import java.util.Scanner;

public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; 
    private double weight; 
    
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
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

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
