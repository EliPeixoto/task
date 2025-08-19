ALTER TABLE users
    ADD COLUMN criado_por VARCHAR(240),
    ADD COLUMN atualizado_por VARCHAR(240),
    ADD COLUMN criado_em TIMESTAMP,
    ADD COLUMN atualizado_em TIMESTAMP;

