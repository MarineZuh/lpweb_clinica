CREATE TABLE IF NOT EXISTS `exame`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)engine = InnoDB
 DEFAULT CHARSET = utf8;
CREATE TABLE IF NOT EXISTS `medicamento`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)engine = InnoDB
 DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `plano_saude`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)engine = InnoDB
 DEFAULT CHARSET = utf8;

INSERT INTO exame(nome) VALUES ('ultrasonografia');
INSERT INTO exame(nome) VALUES ('endoscopia');
INSERT INTO exame(nome) VALUES ('sangue');
INSERT INTO exame(nome) VALUES ('raio-x');

INSERT INTO medicamento(nome) VALUES ('paracetamol');
INSERT INTO medicamento(nome) VALUES ('buscopan');
INSERT INTO medicamento(nome) VALUES ('motilium');
INSERT INTO medicamento(nome) VALUES ('amoxilina');
INSERT INTO medicamento(nome) VALUES ('buscofen');
INSERT INTO medicamento(nome) VALUES ('dipirona');
INSERT INTO medicamento(nome) VALUES ('tilenol');

INSERT INTO plano_saude(nome) VALUES ('unimed');
INSERT INTO plano_saude(nome) VALUES ('bradesco');
INSERT INTO plano_saude(nome) VALUES ('hapvida');