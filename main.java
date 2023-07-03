import java.util.Random;

public class main {

public static void main(String[] args)

{
//creates number generator
Random randomNumberGenerator = new Random();

//create a large array to hold the results
int[] randomNumbers = new int[200000000];

//populate the array with randomly generated numbers between 1 and 10
for (int i = 0; i < randomNumbers.length; i++) 
{

	randomNumbers[i] = randomNumberGenerator.nextInt(10) + 1;

}
//convert time to milliseconds
long start = System.currentTimeMillis();

//print out results
System.out.println("The sum of the numbers using single thread is " + Summation.sum(randomNumbers));

System.out.println("The time calculating the single thread numbers was: " + (System.currentTimeMillis() - start) + " milliseconds");
//convert time to milliseconds
start = System.currentTimeMillis();

System.out.println("The sum of the numbers using parallelism is " + Summation.parallelSum(randomNumbers));

System.out.println("The time calculating the sum using paralleism was: " + (System.currentTimeMillis() - start) + " milliseconds");

}

}