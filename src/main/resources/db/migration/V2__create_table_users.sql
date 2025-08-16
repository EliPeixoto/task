CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       telefone VARCHAR(20) NOT NULL,
                       status VARCHAR(1) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP
);
