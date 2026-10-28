-- Seed default subscription plans
INSERT INTO subscription_plans (name, price, billing_interval, max_users) 
VALUES ('BASIC', 29.00, 'MONTHLY', 5)
ON CONFLICT (name) DO NOTHING;

INSERT INTO subscription_plans (name, price, billing_interval, max_users) 
VALUES ('PRO', 79.00, 'MONTHLY', 20)
ON CONFLICT (name) DO NOTHING;

INSERT INTO subscription_plans (name, price, billing_interval, max_users) 
VALUES ('ENTERPRISE', 199.00, 'MONTHLY', 100)
ON CONFLICT (name) DO NOTHING;

-- Seed test tenants
INSERT INTO tenants (tenant_identifier, name, email, active, created_at) 
VALUES ('company-alpha', 'Alpha Corp', 'admin@alpha.com', true, NOW())
ON CONFLICT (tenant_identifier) DO NOTHING;

INSERT INTO tenants (tenant_identifier, name, email, active, created_at) 
VALUES ('company-beta', 'Beta Industries', 'support@beta.com', true, NOW())
ON CONFLICT (tenant_identifier) DO NOTHING;
