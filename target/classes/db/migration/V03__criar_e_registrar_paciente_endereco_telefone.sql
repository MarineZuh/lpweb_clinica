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
    `id`          INT(11)      NOT NULL AUTO_INCREMENT,
    `cep`         VARCHAR(9)   NOT NULL,
    `bairro`      VARCHAR(255) NULL DEFAULT NULL,
    `cidade`      VARCHAR(255) NULL DEFAULT NULL,
    `complemento` VARCHAR(255) NULL DEFAULT NULL,
    `estado`      VARCHAR(255) NULL DEFAULT NULL,
    `numero`      INT(11)      NOT NULL,
    `rua`         VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO endereco (id, cep, rua, bairro, numero, complemento, cidade, estado)
VALUES (1, '66066-666', '07', 'Cohatrac', 17, '', 'São Luis', 'Maranhão');
INSERT INTO endereco (id, cep, rua, bairro, numero, complemento, cidade, estado)
VALUES (2, '66066-444', '17', 'Cohab', 20, '', 'São Luis', 'Maranhão');
INSERT INTO endereco (id, cep, rua, bairro, numero, complemento, cidade, estado)
VALUES (3, '12341-444', 'Cardoso Filho', 'Vinhais', 15, '', 'São Luis', 'Maranhão');
INSERT INTO endereco (id, cep, rua, bairro, numero, complemento, cidade, estado)
VALUES (4, '66066-123', 'Afogados', 'Centro', 10, '', 'São Luis', 'Maranhão');
INSERT INTO endereco (id, cep, rua, bairro, numero, complemento, cidade, estado)
VALUES (5, '20195-123', 'Muidos', 'Alemanha', 09, '', 'São Luis', 'Maranhão');


INSERT INTO paciente (id, nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES (1, 'Maria', 'Ana', '2006-04-03', 'F', 1, null);
INSERT INTO paciente (id, nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES (2, 'João', 'Ana', '2007-10-10', 'M', 1, null);
INSERT INTO paciente (id, nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES (3, 'Paula', 'Julia', '2011-04-03', 'F', 2, null);
INSERT INTO paciente (id, nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES (4, 'Pedro', 'Marilene', '2018-10-10', 'M', 3, null);
INSERT INTO paciente (id,nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id, plano_saude_id)
VALUES (5, 'Paulo', 'Mario', '2011-04-03', 'F', 4, null);


INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (1, 'celular', '09812344321', 'Ana', 1);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (2, 'celular', '09812344321', 'Ana', 2);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (3, 'celular', '09815477251', 'Julia', 3);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (4, 'celular', '09846378163', 'Marilene', 4);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (5, 'celular', '09815477251', 'Miranda', 5);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id)
VALUES (6, 'celular', '09846378163', 'Mario', 5);