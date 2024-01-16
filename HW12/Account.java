
/**
 *Account class
 *Track a balance amount
 *Deposit add to it
 *Withdraw subtract from it
 */
public class Account 
{
	//balance field
	private static int balance;

	//Initialize balance = 0
	public Account()
	{
		balance = 0;
	}
	
	/**
	 * deposit
	 * @param int num
	 * Adds num to balance
	 */
	public synchronized void deposit(int num)
	{
		balance += num;
		System.out.println("Deposit:  $" + num);
	}
	/**
	 * withdraw
	 * Withdraws total balance
	 * Sets balance = 0;
	 */
	public synchronized void withdraw()
	{
		System.out.println("Withdraw: $" + balance);
		balance = 0;
	}
}
