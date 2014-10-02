package edu.depaul.se.account.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import edu.depaul.se.account.AccountNotFoundException;
import edu.depaul.se.account.IAccount;
import edu.depaul.se.account.IAccountManager;
import edu.depaul.se.account.InsufficientFundsException;
import edu.depaul.se.account.InvalidAmountException;

/**
 * Implementation of requirements using Hibernate
 * TODO:  Fix getting session
 * TODO:  Negative amount
 */

public class AccountManager implements IAccountManager {

	public AccountManager(){
		
	}

    /**
     * Check to see if the amount is valid amount
     * @param initialBalance
     * @throws InvalidAmountException
     */
    private void validateAmount(float initialBalance) throws InvalidAmountException {
    	if (initialBalance < 0) {
    		throw new InvalidAmountException();
    	}
    }
	
	public int createAccount(String name, float initialBalance) throws InvalidAmountException {
		validateAmount(initialBalance);
		IAccount account = new Account();
		account.setBalance(initialBalance);
		account.setName(name);
		
		 Session session = new Configuration().configure().buildSessionFactory().openSession();

	     session.beginTransaction();
	     session.save(account);
	     session.getTransaction().commit();
	     session.close();
	        
		return account.getId();
		
	}

	public float deposit(int accountNbr, float amount)
			throws AccountNotFoundException, InvalidAmountException {
	    validateAmount(amount);

		IAccount account = findAccount(accountNbr);
		account.setBalance( account.getBalance() + amount);
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
        session.saveOrUpdate(account);

        session.getTransaction().commit();
        session.close();
		
		return account.getBalance();
	}

	
	public List<IAccount> getAllAccounts() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
		
		Criteria crit = session.createCriteria(Account.class);
		List<IAccount> list = (List<IAccount>) crit.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	public float withdraw(int accountNbr, float amount)
			throws AccountNotFoundException, InsufficientFundsException, InvalidAmountException {
	    validateAmount(amount);

		IAccount account = findAccount(accountNbr);
		
		if( account.getBalance() < amount)
		{
			throw new InsufficientFundsException();
		}
		
		account.setBalance( account.getBalance() - amount);
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
        session.saveOrUpdate(account);

        session.getTransaction().commit();
        session.close();
		
		return account.getBalance();
	}

	public float closeAccount(int accountNbr) throws AccountNotFoundException {
		
		IAccount account = findAccount(accountNbr);
			
		 Session session = new Configuration().configure().buildSessionFactory().openSession();

	     session.beginTransaction();
	     session.delete(account);
	     session.getTransaction().commit();
	     session.close();
	        
		return account.getBalance();
	}

	public IAccount findAccount(int accountNbr) throws AccountNotFoundException {
		

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        String SQL_QUERY = " from Account where id = " + accountNbr + " ";
        Query query = session.createQuery(SQL_QUERY);
        List<IAccount> it = query.list();
        session.getTransaction().commit();
        session.close();
        
        if(it.isEmpty())
        {
        	 throw new AccountNotFoundException("No such account");
        }
        
        return it.get(0);
	}
	
	
}
