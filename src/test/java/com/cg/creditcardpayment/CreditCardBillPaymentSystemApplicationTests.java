package com.cg.creditcardpayment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardpayment.bean.Account;
import com.cg.creditcardpayment.bean.Address;
import com.cg.creditcardpayment.bean.CreditCard;
import com.cg.creditcardpayment.bean.Customer;
import com.cg.creditcardpayment.bean.Payment;
import com.cg.creditcardpayment.bean.Statement;
import com.cg.creditcardpayment.bean.Transaction;
import com.cg.creditcardpayment.bean.User;
import com.cg.creditcardpayment.dao.AccountImplementation;
import com.cg.creditcardpayment.dao.CreditCardImplementation;
import com.cg.creditcardpayment.dao.CustomerImplementation;
import com.cg.creditcardpayment.dao.PaymentImplementation;
import com.cg.creditcardpayment.dao.StatementImplementation;
import com.cg.creditcardpayment.dao.TransactionImplementation;
import com.cg.creditcardpayment.dao.UserServiceImplementation;
import com.cg.creditcardpayment.exception.AccountException;
import com.cg.creditcardpayment.exception.CreditcardException;
import com.cg.creditcardpayment.exception.CustomerException;
import com.cg.creditcardpayment.exception.PaymentException;
import com.cg.creditcardpayment.exception.StatementException;
import com.cg.creditcardpayment.exception.TransactionException;
import com.cg.creditcardpayment.exception.UserException;
import com.cg.creditcardpayment.exception.UserIdDoesNotExistException;
import com.cg.creditcardpayment.repository.IAccountRepository;
import com.cg.creditcardpayment.repository.ICreditCardRepository;
import com.cg.creditcardpayment.repository.ICustomerRepository;
import com.cg.creditcardpayment.repository.IPaymentRepository;
import com.cg.creditcardpayment.repository.IStatementRepository;
import com.cg.creditcardpayment.repository.IUserRepository;
import com.cg.creditcardpayment.repository.TransactionRepository;

@SpringBootTest
class CreditCardBillPaymentSystemApplicationTests {

	@Autowired
	private CustomerImplementation customerService;

	@Autowired
	private ICustomerRepository custRepo;

	@Autowired
	private UserServiceImplementation userService;

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IStatementRepository statementRepo;
	@Autowired
	private StatementImplementation statementService;

	@Autowired
	private AccountImplementation service;

	@Autowired
	private IAccountRepository accountRepository;

//	@Test
//	public void testAddCustomer() {
//		Customer c = new Customer();
//		c.setName("Sample");
//		c.setCustId(12912887);
//		c.setContactNo("1231415678");
//		LocalDate lDT = LocalDate.parse("2020-01-12");
//		c.setDob(lDT);
//		c.setEmail("Testing01@email.com");
//		User user = new User();
//		user.setPassword("Password@01");
//		user.setUserId(12341223);
//		user.setRole("ADMIN");
//		c.setUser(user);
//		Address a = new Address("Door", "street", "area", "city", "state", 123451);
//		List<Address> add = new LinkedList<Address>();
//		c.setAddress(add);
//
//		Customer cTest = null;
//		try {
//			cTest = customerService.addCustomer(c);
//		} catch (CustomerException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(cTest);
//	}
//
//	@Test
//	public void testGetCustomer() throws CustomerException {
//		Customer c = customerService.getCustomer(600036);
//		assertNotNull(c);
//	}
//
//	@Test
//	public void testGetAllCustomers() {
//		List<Customer> c = customerService.getAllCustomers();
//		assertNotNull(c);
//	}
//
//	@Test
//	public void testUpdateCustomer() throws CustomerException, UserIdDoesNotExistException {
//		Customer cTest = custRepo.existsByCustId(600036);
//		Customer c = customerService.updateCustomer(600036, cTest);
//
//		assertNotNull(c);
//
//	}
//
//	@Test
//	public void testRemoveCustomer() throws CustomerException {
//		Integer c = custRepo.removeCustomer(600036);
//		assertEquals(1, c);
//	}
//
//	@Test
//	public void testSignIn() throws UserException {
//		User u = new User();
//		u.setUserId(12341223);
//		u.setRole("ADMIN");
//		u.setPassword("Password@01");
//		User uTest = userService.signIn(u);
//
//		assertNotNull(u);
//	}
//
//	@Test
//	public void testSignOut() throws UserException {
//		User u = new User();
//		u.setUserId(12341223);
//		u.setRole("ADMIN");
//		u.setPassword("Password@01");
//		User uTest = userService.signOut(u);
//
//		assertEquals(0, uTest.getUserId());
//		assertEquals(null, uTest.getPassword());
//	}
//
//	@Test
//	public void testChangePassword() throws UserException {
//		User u = new User();
//		u.setUserId(12341223);
//		u.setRole("ADMIN");
//		u.setPassword("TestingChanged@01");
//		User uTest = userService.changePassword(12341223, u);
//
//		assertEquals(12341223, uTest.getUserId());
//		assertEquals("TestingChanged@01", uTest.getPassword());
//		assertEquals("ADMIN", uTest.getRole());
//
//	}
//
//	@Test
//	public void testAddAccount() throws AccountException {
//		Account ac = new Account();
//		// ac.setAccountNumber(1000000004);
//		ac.setAccountName("rohit");
//		ac.setBalance(1232.00);
//		ac.setType("salary");
//		Account account = null;
//		try {
//			account = service.addAccount(ac);
//		} catch (AccountException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(account);
//	}
//
//	@Test
//	public void testGetAccount() {
//		Account ac = service.getAccount(1000000004);
//		assertNotNull(ac);
//	}
//
//	@Test
//	public void testGetAllAccounts() {
//		List<Account> ac = service.getAllAccounts();
//		assertNotNull(ac);
//	}
//
//	@Test
//	public void testUpdateAccount() throws AccountException {
//		Account ac = accountRepository.existsByAccountNumber(1000000004);
//		Account a = service.updateAccount(1000000004, ac);
//		assertNotNull(a);
//	}
//
//	@Test
//	public void testRemoveaccount() throws AccountException {
//		Integer i = accountRepository.removeAccount(1000000029);
//		assertEquals(1, i);
//	}
//
//	@Test
//	public void addStatement() throws StatementException {
//		Statement s = new Statement();
//		s.setStatementId(1001);
//		s.setBillingDate(LocalDate.of(2022, 03, 20));
//		s.setDueDate(LocalDate.of(2022, 03, 21));
//		s.setDueAmount(5000);
//		s.setCustomer(null);
//
//		Statement s1 = null;
//		try {
//			s1 = statementService.addStatement(s);
//		} catch (StatementException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(s1);
//	}
//
//	@Test
//	public void testGetStatement() throws StatementException {
//		Statement s = statementService.getStatement(1023);
//		assertNotNull(s);
//	}
//
//	@Test
//	public void testGetAllStatement() throws StatementException {
//		List<Statement> s = statementService.getAllStatements();
//	}
//
//	@Test
//	public void testUpdateStatement() throws StatementException {
//		Statement s1 = statementRepo.getStatement(1023);
//		Statement s = statementService.updateStatement(1023, s1);
//	}
//
//	@Test
//	public void testRemoveStatement() throws StatementException {
//		Integer i = statementRepo.removeStatement(1023);
//		assertEquals(1, i);
//	}
//
//	@Autowired
//	private TransactionImplementation TransactionService;
//	@Autowired
//	private TransactionRepository transactionRepository;
//
//	@Test
//	public void testAddTransaction() throws TransactionException {
//		Transaction t = new Transaction();
//		t.setTransactionId(1265735276523l);
//		t.setCardNumber("2234");
//		LocalDate IDT = LocalDate.parse("2021-11-12");
//		t.setTransactionDate(IDT);
//		t.setDescription("testing");
//		t.setStatus(com.cg.creditcardpayment.bean.TranscationStatus.SUCCESSFUL);
//		LocalTime lT = LocalTime.parse("22:15:10");
//		t.setTransactionTime(lT);
//		t.setAmount(32762.32);
//
//		assertNotNull(TransactionService.addTransaction(t));
//
//		Transaction tTest = null;
//		try {
//			tTest = TransactionService.addTransaction(t);
//		} catch (TransactionException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(tTest);
//	}
//
//	@Test
//	public void testGetTransaction() throws TransactionException {
//		Transaction t = TransactionService.getTransactionDetails(10001);
//		assertNotNull(t);
//	}
//
//	@Test
//	public void testGetAllTransaction() {
//		java.util.List<Transaction> t = TransactionService.getAllTransactions();
//		assertNotNull(t);
//	}
//
//	@Test
//	public void testUpdateTransaction() throws TransactionException {
//		Transaction tTest = transactionRepository.existsByTransaction(10001);
//		Transaction t = TransactionService.updateTransaction(10012, tTest);
//
//		assertNotNull(t);
//
//	}
//
//	@Test
//	public void testRemoveTransaction() throws TransactionException {
//		Integer t = transactionRepository.removeTransaction(10002);
//
//		assertEquals(1, t);
//	}
//
//	@Autowired
//	private IPaymentRepository pRepository;
//
//	@Autowired
//	private PaymentImplementation pService;
//
//	@Test
//	public void testAddPayment() {
//		Payment pay = new Payment();
//		pay.setStatus("Sucessfull");
//		pay.setType("UPI");
//
//		CreditCard card = new CreditCard();
//		card.setBankName("akhil");
//		card.setCardName("akhil");
//		card.setCardType("Master");
//		card.setCardNumber("6782446587357842");
//		LocalDate IDT = LocalDate.parse("2023-04-18");
//		card.setCardExpiry(IDT);
//		card.setCvv(156);
//		pay.setCard(card);
//		Payment pTest = null;
//		try {
//			pTest = pService.addPayment(pay);
//		} catch (PaymentException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(pTest);
//	}
//
//	@Test
//	public void testGetPayment() throws PaymentException {
//		Payment pTest = pService.getPayment(1025);
//		assertNotNull(pTest);
//	}
//
//	@Test
//	public void testUpdatePayment() throws PaymentException {
//		Payment pTest = pRepository.getPayment(1025);
//		Payment p = pService.updatePayment(1025, pTest);
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testRemovePayment() throws PaymentException {
//		Integer pTest = pRepository.removePayment(1032);
//		assertEquals(1, pTest);
//	}
//
//	@Autowired
//	private ICreditCardRepository credidCardRepository;
//
//	@Autowired
//	CreditCardImplementation creditCardService;
//
//	@Test
//	public void testAddCard() {
//		CreditCard card = new CreditCard();
//		card.setBankName("akhil");
//		card.setCardName("akhil");
//		card.setCardType("Master");
//		card.setCardNumber("6782446587357897");
//		LocalDate IDT = LocalDate.parse("2023-04-18");
//		card.setCardExpiry(IDT);
//		card.setCvv(056);
//
//		CreditCard cTest = null;
//		try {
//			cTest = creditCardService.addCreditCard(card);
//		} catch (CreditcardException e) {
//			e.printStackTrace();
//		}
//		assertNotNull(cTest);
//	}
//
//	@Test
//	public void testGetCreditCard() throws CreditcardException {
//		CreditCard cTest = creditCardService.getCreditCard(1009);
//		assertNotNull(cTest);
//	}
//
//	@Test
//	public void testGetAllDetails() {
//		List<CreditCard> cTest = creditCardService.getAllCreditCards();
//		assertNotNull(cTest);
//	}
//
//	@Test
//	public void testUpdateCreditcard() throws CreditcardException {
//		CreditCard cTest = credidCardRepository.getCardId(1009);
//		CreditCard c = creditCardService.updateCreditCard(1009, cTest);
//		assertNotNull(c);
//
//	}
//
//	@Test
//	public void testRemoveCard() throws CreditcardException {
//		Integer cTest = credidCardRepository.removeCreditCard(1009);
//		assertEquals(1, cTest);
//	}

}
