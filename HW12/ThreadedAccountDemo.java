import java.util.concurrent.Semaphore;

/**
 * ThreadedAccountDemo
 * Demo managed access to a shared resource
 * Demo Semaphore and concurrent threads
 * Demo join(), wait from all threads to exit before main thread 
 */
public class ThreadedAccountDemo 
{
	public static void main(String[] args) 
	{
		//Account object
		Account acc = new Account();
		//New Semaphore object with 1 permit, enabled FIFO permit guarantee
		Semaphore sema = new Semaphore(1, true);
		
		System.out.println("Main ln 10 avail Permits: " + 
				sema.availablePermits());
		//New Deposit object, param Semaphore and Account object
		Deposit deposit = new Deposit(sema, acc);
		//New Withdraw object, param Semaphore and Account object
		Withdraw withdraw = new Withdraw(sema, acc);
		
		//join(), Prevents main thread from completing until
		//deposit and withdraw threads complete
		try
		{
			deposit.third.join();  //join thread
			withdraw.thrd.join(); //join thread
		}
		catch(InterruptedException exc)
		{
			System.out.println(exc);
		}
		
		System.out.println("***End Main");

	}

}
