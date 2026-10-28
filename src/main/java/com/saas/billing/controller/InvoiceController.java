package com.saas.billing.controller;

import com.saas.billing.model.Invoice;
import com.saas.billing.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getInvoices() {
        return ResponseEntity.ok(invoiceService.getTenantInvoices());
    }

    @PostMapping
    public ResponseEntity<Invoice> generateInvoice(@RequestParam BigDecimal amount) {
        return ResponseEntity.ok(invoiceService.generateInvoice(amount));
    }
}
