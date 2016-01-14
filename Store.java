@@ -0,0 +1,137 @@
import java.util.Scanner;
public class Store {
public static void main(String [] args) 
{
	String userChoice;
	double [] earnings = new double [7];
	double average = 0;
	double lowest = 0;
	double highest = 0;
	Scanner keyboard = new Scanner(System.in);
	int index = 0;
	do
	{
	System.out.println("Hello. Please select an option \n");
	System.out.println("Enter M to enter an amount for the day");
	System.out.println("Enter AV to have the average computed");
	System.out.println("Enter LA to have the lowest amount computed");
	System.out.println("Enter HA to have the highest amount computed");
	System.out.println("Enter I to display all information.");
	System.out.println("Enter Q to quit the program.");
	userChoice = keyboard.next();
	
	if(userChoice.equalsIgnoreCase("M"))
	{
		if(index<=6)
		{
			earnings[index] = dailyEarnings();
			index++;
		}
		else
		{
			System.out.println("The values for the week have already been entered.");
		}
	}
	if(userChoice.equalsIgnoreCase("AV"))
	{
	average = averageEarnings(earnings,index);
	}
	if(userChoice.equalsIgnoreCase("LA"))
	{
		lowest = lowestAmount(earnings,index);
	}
	if(userChoice.equalsIgnoreCase("HA"))
	{
		highest = highestAmount(earnings,index);
	}
	if(userChoice.equalsIgnoreCase("I"))
	{
		information(earnings, index, average, lowest, highest);
	}
	}
	while(!userChoice.equalsIgnoreCase("Q"));
	System.out.println("System will now exit");
	
	
}
public static double dailyEarnings()
{
	
	Scanner keyboard = new Scanner(System.in);
	double profit;
	do
	{
	System.out.println("Please enter the amount for today");
	profit = keyboard.nextDouble();
	if(profit<0)
	{
		System.out.println("Error! Enter a number greater than or equal to 0 for today");
	}
	}
	while(profit<0);
	return profit;
	}

public static double averageEarnings(double[] array,int index)
{
	
	double sum = 0;
	double average = 0;
	int day = 0;
	for(int i = 0; i<index; i++)
	{
		sum += array[day];
		day++;
	}
	if(index>0)
	{
		average = sum/index;	
	}
	System.out.println("The average for the week is: $" + average);
	return average;
}
public static double lowestAmount(double [] array, int index)
{
int day = 0;
double lowestValue = array[day];
for(int i = 0; i<index; i++)
{
	if(array[day]<lowestValue)
	{
		lowestValue = array[day];
	}
	day++;
}
System.out.println("The lowest amount earned is: $" + lowestValue);
return lowestValue;
}
public static double highestAmount(double [] array, int index)
{
	int day = 0;
	double highestValue = 0;
	for(int i = 0; i<index; i++)
	{
		if(array[day]>highestValue)
		{
			highestValue = array[day];
		}
		day++;
	}
	System.out.println("The highest amount earned is: $" + highestValue);
	return highestValue;
}
public static void information(double [] array, int index, double averageEarned, double lowestEarned, double highestEarned)
{
	int day = 0;
	System.out.println("Daily Earnings:");
	for(int i = 0; i < index; i++)
	{
	System.out.println("$" + array[day]);
	day++;
	}
	averageEarned = averageEarnings(array,index);
	lowestEarned = lowestAmount(array,index);
	highestEarned = highestAmount(array,index);
}
}
