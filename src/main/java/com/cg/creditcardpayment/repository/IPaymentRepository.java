package com.cg.creditcardpayment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardpayment.bean.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	// public Payment addPayment(Payment payment);
	@Transactional
	@Modifying
	@Query("delete from Payment p where p.paymentId= ?1")
	public int removePayment(long id);

	@Transactional
	@Modifying
	@Query(value = "Update Payment SET", nativeQuery = true)
	public Payment updatePayment(long id, Payment payment);

	@Query(value="select * from payment_info where payment_id=?1", nativeQuery=true)
	public Payment getPayment(long id);

}
