package ru.ulstu.is.sbapp.operation.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class OperationKoren implements Operation, InitializingBean, DisposableBean {
    private final Logger log = LoggerFactory.getLogger(OperationKoren.class);

    @Override
    public String count(int num) {
        return String.format("Корень: %s", Math.sqrt(num));
    }

    @Override
    public void afterPropertiesSet() {
        log.info("OperationKoren.afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        log.info("OperationKoren.destroy()");

    }
}
