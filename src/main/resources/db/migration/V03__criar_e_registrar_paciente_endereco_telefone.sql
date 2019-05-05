CREATE TABLE IF NOT EXISTS `paciente`
(
    `id`               INT          NOT NULL AUTO_INCREMENT,
    `data_nascimento`  DATE         NULL DEFAULT NULL,
    `nome_crianca`     VARCHAR(255) NULL DEFAULT NULL,
    `nome_responsavel` VARCHAR(255) NULL DEFAULT NULL,
    `sexo`             CHAR(1)      NOT NULL,
    `endereco_id`      INT(11)      NULL DEFAULT NULL,
    `plano_saude_id`   INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `telefone`
(
    `id`           INT(11)      NOT NULL AUTO_INCREMENT,
    `nome_contato` VARCHAR(255) NULL DEFAULT NULL,
    `numero`       VARCHAR(255) NULL DEFAULT NULL,
    `tipo`         VARCHAR(255) NULL DEFAULT NULL,
    `paciente_id`  INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS `endereco`
(
    `cep`         VARCHAR(9)   NOT NULL,
    `bairro`      VARCHAR(255) NULL DEFAULT NULL,
    `cidade`      VARCHAR(255) NULL DEFAULT NULL,
    `complemento` VARCHAR(255) NULL DEFAULT NULL,
    `estado`      VARCHAR(255) NULL DEFAULT NULL,
    `numero`      INT(11)      NOT NULL,
    `rua`         VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`cep`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO endereco (cep, rua, bairro, numero, complemento, cidade, estado)
VALUES ('66066-666', '07', 'Cohatrac', 17, '', 'São Luis', 'Maranhão');
INSERT INTO paciente (nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES ('Maria', 'Ana', '2006-04-03', 'F', 1, null);
INSERT INTO telefone (tipo, numero, nome_contato, paciente_id)
VALUES ('celular', '09812344321', 'Ana', 1);
