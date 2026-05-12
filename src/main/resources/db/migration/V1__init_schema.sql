-- Tabla CLIENTE
CREATE TABLE IF NOT EXISTS clients (
    id         BIGSERIAL    PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    document   VARCHAR(20)  NOT NULL UNIQUE,
    created_at TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    CHECK (email LIKE '%@%.%')
);

-- Tabla CUENTA
CREATE TABLE IF NOT EXISTS accounts (
    id             BIGSERIAL      PRIMARY KEY,
    client_id      BIGINT         NOT NULL,
    account_number VARCHAR(20)    NOT NULL UNIQUE,
    balance        DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    status         VARCHAR(20)    NOT NULL DEFAULT 'ACTIVO',
    created_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    CHECK (balance >= 0),
    CHECK (status IN ('ACTIVO', 'CERRADO'))
);

-- Tabla TRANSACCION
CREATE TABLE IF NOT EXISTS transactions (
    id                     BIGSERIAL      PRIMARY KEY,
    account_origin_id      BIGINT         NOT NULL,
    account_destination_id BIGINT         NOT NULL,
    amount                 DECIMAL(15, 2) NOT NULL,
    commission             DECIMAL(15, 2) NOT NULL DEFAULT 5.00,
    type                   VARCHAR(20)    NOT NULL DEFAULT 'TRANSFERENCIA',
    status                 VARCHAR(20)    NOT NULL DEFAULT 'PENDIENTE',
    description            VARCHAR(255),
    created_at             TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_origin_id)      REFERENCES accounts(id),
    FOREIGN KEY (account_destination_id) REFERENCES accounts(id),
    CHECK (amount > 0),
    CHECK (account_origin_id != account_destination_id),
    CHECK (type   IN ('TRANSFERENCIA', 'DEPOSITO', 'RETIRO')),
    CHECK (status IN ('PENDIENTE', 'COMPLETADA', 'FALLIDA', 'CANCELADA'))
);

CREATE INDEX IF NOT EXISTS idx_accounts_client_id                  ON accounts(client_id);
CREATE INDEX IF NOT EXISTS idx_transactions_account_origin_id      ON transactions(account_origin_id);
CREATE INDEX IF NOT EXISTS idx_transactions_account_destination_id ON transactions(account_destination_id);
CREATE INDEX IF NOT EXISTS idx_transactions_created_at             ON transactions(created_at);

