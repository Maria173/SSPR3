package ru.ulstu.is.sbapp.operation.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.ulstu.is.sbapp.operation.domain.OperationKvadrat;
import ru.ulstu.is.sbapp.operation.domain.Operation;
import ru.ulstu.is.sbapp.operation.domain.OperationKoren;

@Configuration
public class OperationConfiguration {
    private final Logger log = LoggerFactory.getLogger(OperationConfiguration.class);

    @Bean(value = "kvadrat", initMethod = "init", destroyMethod = "destroy")
    public OperationKvadrat createKvadratOperation() {
        log.info("Call createKvadratOperation()");
        return new OperationKvadrat();
    }

    @Bean(value = "koren")
    public Operation createKorenOperation() {
        log.info("Call createKorenOperation()");
        return new OperationKoren();
    }
}
