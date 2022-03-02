package ru.ulstu.is.sbapp.operation.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperationKvadrat implements Operation {
    private final Logger log = LoggerFactory.getLogger(OperationKvadrat.class);

    @Override
    public String count(int num) {
        return String.format("Квадрат: %s", num * num);
    }

    public void init() {
        log.info("OperationKvadrat.init()");
    }

    public void destroy() {
        log.info("OperationKvadrat.destroy()");
    }
}
