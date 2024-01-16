import java.util.concurrent.Semaphore;

/**
 * Withdraw implements Runnable
 * Starts a Withdraw Thread
 * Uses Semaphore resource management
 * Restricts resource access
 */
public class Withdraw implements Runnable
{
	Semaphore sema;
	Account acc;
	Thread thrd;
	
	/**
	 * Constructor
	 * Initialize fields, start new Thread
	 * @param sem
	 * @param ac
	 */
	public Withdraw(Semaphore sem, Account ac)
	{
		sema = sem;
		acc = ac;
		
		System.out.println("---Starting Withdraw");
		
		thrd = new Thread(this);  //New (this)Withdraw Thread object
		thrd.start();             //Start Thread
	}
	
	@Override
	public void run()
	{
		System.out.println("---Withdrawing $");
		
		try
		{
			for(int i = 1; i < 11; i++)
			{
				sema.acquire();   //Ask for a permit
				acc.withdraw();  //Access resource withdraw method
				Thread.sleep(10); //Allow for context switch
				sema.release();   //Release permit
			}
		}
		catch(InterruptedException exc)
		{
			System.out.println(exc);
		}
		System.out.println("---End Withdraw : avail Permits: " + 
				sema.availablePermits());
	}
}
