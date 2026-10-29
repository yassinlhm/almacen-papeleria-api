CREATE TABLE IF NOT EXISTS articulo (
    id        INTEGER      PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    precio    REAL         NOT NULL,
    stock     INTEGER      NOT NULL,
    categoria VARCHAR(50)  NOT NULL
);
