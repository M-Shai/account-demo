import java.util.concurrent.Semaphore;

/**
 * Deposit implements Runnable
 * Starts a Deposit Thread
 * Uses Semaphore resource management
 * Restricts resource access
 */
public class Deposit implements Runnable
{
	Semaphore semaphore;
	Account account;
	Thread third;
	
	/**
	 * Constructor
	 * Initializes fields, start new Thread
	 * @param sem
	 * @param ac
	 */
	public Deposit(Semaphore sem, Account ac)
	{
		semaphore = sem;
		account = ac;
		
		System.out.println("+++Starting Deposit");
		
		third = new Thread(this);  //New (this)Deposit Thread object 
		third.start();             //Start Thread
	}
	
	@Override
	public void run()
	{
		System.out.println("+++Depositing $");
		
		try
		{
			for(int i = 1; i < 11; i++)
			{
				semaphore.acquire();	  //Ask for a permit
				account.deposit(i);   //Access resource deposit method
				Thread.sleep(10); //Allow for context switch
				semaphore.release();   //Release the permit
			}
		}
		catch (InterruptedException exc)
		{
			System.out.println(exc);
		}
		System.out.println("+++End Deposit : avail Permits: " + 
				semaphore.availablePermits());
	}
}
