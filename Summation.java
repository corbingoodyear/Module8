import java.util.Random;

class Summation extends Thread {
//create array to hold random numbers generated
private int[] randomNumbers;
//declare variables to be used
private int low, high, partialSum;

public Summation(int[] arr, int low, int high)
{

	this.randomNumbers = arr;

	this.low = low;

	this.high = Math.min(high, arr.length);

}

public int getPartialSum()
{
	
	return partialSum;
	
}

public void run()
{

	partialSum = sum(randomNumbers, low, high);

}

public static int sum(int[] arr)
{

	return sum(arr, 0, arr.length);

}
//sums uo all randomly gnerated numbers using single thread
public static int sum(int[] arr, int low, int high)
{

	int total = 0;

		for (int i = low; i < high; i++) 
		{

			total += arr[i];

		}

	return total;

}

public static int parallelSum(int[] arr)
{

	return parallelSum(arr, Runtime.getRuntime().availableProcessors());

}
//sums up all randomly generated numbers using multiple threads
public static int parallelSum(int[] arr, int threads)
{

	int size = (int) Math.ceil(arr.length * 1.0 / threads);

	Summation[] sums = new Summation[threads];

	for (int i = 0; i < threads; i++) 
	{

		sums[i] = new Summation(arr, i * size, (i + 1) * size);

		sums[i].start();

	}

	try 
	{

		for (Summation sum : sums) 
		{
	
			sum.join();
	
		}

} 
	catch (InterruptedException e) { }
//create and set total to 0 which will hold sum of numbers generated
int total = 0;

for (Summation sum : sums) 
{
//sum up all random numbers generated using multiple threads
	total += sum.getPartialSum();

}
//print out final sum
return total;

}

}
