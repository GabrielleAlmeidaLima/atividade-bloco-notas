CREATE TABLE IF NOT EXISTS nota(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conteudo VARCHAR(300) NOT NULL
);
