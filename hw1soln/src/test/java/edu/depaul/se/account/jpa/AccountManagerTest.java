/**
 * 
 */
package edu.depaul.se.account.jpa;

import org.junit.Before;

import edu.depaul.se.account.AbstractAccountManagerTest;





public class AccountManagerTest extends AbstractAccountManagerTest {
	@Before
	public void setup() {
		setAccountManager(new AccountManager());
	}
}
