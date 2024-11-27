package com.spring.cloud.fraud_alert;

import com.spring.cloud.fraud_alert.models.FraudAlert;
import com.spring.cloud.fraud_alert.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
@Slf4j
public class TransactionProcessor {

//	@Bean
//	public Function<Transaction, FraudAlert> transactionFraudProcessor() {
//		log.info("Fraud detection service started");
//		return transaction -> {
//			log.info("Processing transaction: " + transaction.getId());
//			if (isSuspicious(transaction)) {
//				return new FraudAlert(transaction.getId(), "Suspicious transaction detected");
//			}
//			return null;
//		};
//	}

	@Bean // no need of bean over as cloud auto sets it.
	public Function<Transaction, FraudAlert> transactionFraudProcessor() {
		log.info("Fraud detection service started");
		return transaction -> {
			log.info("Processing transaction: " + transaction.getId());

			if (isSuspicious(transaction)) {
				FraudAlert alert = new FraudAlert(transaction.getId(), "Suspicious transaction detected");
				log.info("Fraud detected: " + alert);
				return alert;
			}
			
			log.info("Transaction is valid: " + transaction.getId());
			return null;
		};
	}

	private boolean isSuspicious(Transaction transaction) {
		return transaction.getAmount().compareTo(BigDecimal.valueOf(40000)) > 0;
	}
}


