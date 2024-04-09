import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Weather> weatherReport = new ArrayList<>();

        System.out.print("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
        int numOfDays = scanner.nextInt();
        while (numOfDays < 1 || numOfDays > 7) {
            System.out.println("ERROR: INVALID NUMBER OF DAYS ENTERED. TRY AGAIN.");
            System.out.print("Enter the number of days in the Weather Report (min: 1 - max: 7): ");
            numOfDays = scanner.nextInt();
        }

        for (int i = 1; i <= numOfDays; i++) {
            System.out.println("\nEnter the weather conditions for day " + i + ":");
            System.out.println("     A - Sunny");
            System.out.println("     B - Cloudy");
            System.out.println("     C - Rainy");
            System.out.println("     D - Snowy");
            System.out.print("Enter your choice (A, B, C, or D): ");
            String conditionChoice = scanner.next().toUpperCase();
            while (!conditionChoice.equals("A") && !conditionChoice.equals("B") && !conditionChoice.equals("C") && !conditionChoice.equals("D")) {
                System.out.println("ERROR: INVALID CHOICE. Please try again.");
                System.out.print("Enter your choice (A, B, C, or D): ");
                conditionChoice = scanner.next().toUpperCase();
            }

            String skyCondition = "";
            switch (conditionChoice) {
                case "A":
                    skyCondition = "Sunny";
                    break;
                case "B":
                    skyCondition = "Cloudy";
                    break;
                case "C":
                    skyCondition = "Rainy";
                    break;
                case "D":
                    skyCondition = "Snowy";
                    break;
            }

            double kelvinTemp;
            if (skyCondition.equals("Snowy")) {
                System.out.print("Enter the high kelvin temperature for day " + i + " (min: 252.59K, max: 273.15K): ");
                kelvinTemp = scanner.nextDouble();
                while (kelvinTemp < 252.59 || kelvinTemp > 273.15) {
                    System.out.println("ERROR: INVALID HIGH TEMPERATURE ENTERED. Please try again.");
                    System.out.print("Enter the high kelvin temperature for day " + i + " (min: 252.59K, max: 273.15K): ");
                    kelvinTemp = scanner.nextDouble();
                }
            } else {
                System.out.print("Enter the high kelvin temperature for day " + i + " (min: 273.15K, max: 313.71K): ");
                kelvinTemp = scanner.nextDouble();
                while (kelvinTemp < 273.15 || kelvinTemp > 313.71) {
                    System.out.println("ERROR: INVALID HIGH TEMPERATURE ENTERED. Please try again.");
                    System.out.print("Enter the high kelvin temperature for day " + i + " (min: 273.15K, max: 313.71K): ");
                    kelvinTemp = scanner.nextDouble();
                }
            }

            Weather weather = new Weather(kelvinTemp, skyCondition);
            weatherReport.add(weather);
        }

        System.out.println("\nWeather Report");
        for (int i = 0; i < weatherReport.size(); i++) {
            System.out.println("\nDay " + (i + 1));
            System.out.println("--------------------------");
            System.out.println(weatherReport.get(i));
            System.out.println("--------------------------");
        }

        // Calculating Stuff
        double totalFahrenheit = 0;
        double totalCelsius = 0;
        double totalKelvin = 0;
        for (Weather weather : weatherReport) {
            totalFahrenheit += weather.calculateFahrenheitTemp();
            totalCelsius += weather.calculateCelsiusTemp();
            totalKelvin += weather.getKelvinTemperature();
        }
        double avgFahrenheit = totalFahrenheit / numOfDays;
        double avgCelsius = totalCelsius / numOfDays;
        double avgKelvin = totalKelvin / numOfDays;

        System.out.println("\nDays in weather report: " + numOfDays);
        System.out.println("Average Fahrenheit Temperature: " + String.format("%.2f", avgFahrenheit) + "F");
        System.out.println("Average Celsius Temperature:    " + String.format("%.2f", avgCelsius) + "C");
        System.out.println("Average Kelvin Temperature:     " + String.format("%.2f", avgKelvin) + "K");
    }
}
