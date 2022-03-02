package ru.ulstu.is.sbapp.operation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.sbapp.operation.service.OperationService;

@RestController
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/")
    public String calculate(@RequestParam(value = "num", defaultValue = "4") int num,
            @RequestParam(value = "method", defaultValue = "kvadrat") String method) {
        return operationService.count(num, method);
    }
}
