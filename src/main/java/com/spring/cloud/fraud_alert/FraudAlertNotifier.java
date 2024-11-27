package com.spring.cloud.fraud_alert;

import com.spring.cloud.fraud_alert.models.FraudAlert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class FraudAlertNotifier {
	@Bean
	public Consumer<FraudAlert> fraudAlertNotifierService() {
		return fraudAlert -> {
			try {
				if (fraudAlert != null && fraudAlert.getMessage() != null) {
					log.info("Sending notification: " + fraudAlert.getMessage());
					
				} else {
					log.warn("Received an invalid FraudAlert: " + fraudAlert);
				}
			} catch (Exception e) {
				log.error("Error processing FraudAlert: " + e.getMessage(), e);
			}
		};
	}
}
