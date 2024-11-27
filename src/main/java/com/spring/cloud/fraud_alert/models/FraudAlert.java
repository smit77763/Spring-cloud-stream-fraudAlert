package com.spring.cloud.fraud_alert.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudAlert {
	private String transactionId;
	private String message;
}
