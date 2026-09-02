CREATE TABLE usuario
(
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    email     VARCHAR(100) NOT NULL UNIQUE,
    senha     VARCHAR(20)  NOT NULL,
    telefone  CHAR(11),
    pontos    INT          NOT NULL DEFAULT 0
);

CREATE TABLE beneficio
(
    idBeneficio INT AUTO_INCREMENT PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    descricao   VARCHAR(255),
    custo       INT          NOT NULL
);

CREATE TABLE compra
(
    idCompra           INT AUTO_INCREMENT PRIMARY KEY,
    codigo_nota_fiscal CHAR(44)       NOT NULL UNIQUE,
    valor              DECIMAL(10, 2) NOT NULL,
    data_compra        TIMESTAMP      NOT NULL,
    fk_usuario         INT            NOT NULL,
    CONSTRAINT fk_compra_usuario
        FOREIGN KEY (fk_usuario) REFERENCES usuario (idUsuario)
);

CREATE TABLE resgate
(
    idResgate      INT         NOT NULL,
    custo          INT         NOT NULL,
    data_conquista TIMESTAMP   NOT NULL,
    data_resgate   TIMESTAMP,
    fk_usuario     INT         NOT NULL,
    fk_beneficio   INT         NOT NULL,
    status         VARCHAR(45) NOT NULL,
    CONSTRAINT pk_resgate
        PRIMARY KEY (idResgate, fk_usuario, fk_beneficio),
    CONSTRAINT fk_resgate_usuario
        FOREIGN KEY (fk_usuario)
            REFERENCES usuario (idUsuario),
    CONSTRAINT fk_resgate_beneficio
        FOREIGN KEY (fk_beneficio)
            REFERENCES beneficio (idBeneficio)
);