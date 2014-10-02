/**
 * 
 */
package edu.depaul.se.account.hibernate;

import org.junit.Before;

import edu.depaul.se.account.AbstractAccountManagerTest;





public class AccountManagerTest extends AbstractAccountManagerTest {
	@Before
	public void setup() {
		setAccountManager(new AccountManager());
	}
}
