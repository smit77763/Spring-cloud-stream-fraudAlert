package com.spring.cloud.fraud_alert;

import com.spring.cloud.fraud_alert.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionProducer {
	
	@Autowired
	private StreamBridge streamBridge;
	
	@PostMapping()
	public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
		Message<Transaction> message = MessageBuilder.withPayload(transaction).build();
		streamBridge.send("transactionFraudProcessor-in-0", message);
		return ResponseEntity.ok("Transaction sent");
	}
}
