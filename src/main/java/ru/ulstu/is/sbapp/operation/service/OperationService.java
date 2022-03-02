package ru.ulstu.is.sbapp.operation.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.ulstu.is.sbapp.operation.domain.Operation;

@Service
public class OperationService {
    private final ApplicationContext applicationContext;

    public OperationService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String count(int num, String method) {
        final Operation operation = (Operation) applicationContext.getBean(method);
        return String.format("%s", operation.count(num));
    }
}
