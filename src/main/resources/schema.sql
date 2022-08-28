CREATE TABLE FACTURA (
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR NOT NULL
);

CREATE TABLE PAGO (
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PAGO DOUBLE PRECISION NOT NULL,
    FECHA_DE_PAGO DATE NOT NULL,
    FACTURA_ID BIGINT NOT NULL REFERENCES FACTURA(ID)
);