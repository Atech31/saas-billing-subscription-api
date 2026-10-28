package com.saas.billing.service;

import com.saas.billing.model.Invoice;
import com.saas.billing.repository.InvoiceRepository;
import com.saas.billing.security.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getTenantInvoices() {
        String tenantId = TenantContext.getCurrentTenant();
        return invoiceRepository.findByTenantId(tenantId);
    }

    public Invoice generateInvoice(BigDecimal amount) {
        String tenantId = TenantContext.getCurrentTenant();

        Invoice invoice = Invoice.builder()
                .tenantId(tenantId)
                .amount(amount)
                .status("PENDING")
                .issueDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .build();

        return invoiceRepository.save(invoice);
    }
}
