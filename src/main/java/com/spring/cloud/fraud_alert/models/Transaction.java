package com.spring.cloud.fraud_alert.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private String id;
	private BigDecimal amount;
	private String accountId;
}
