CREATE TABLE IF NOT EXISTS `medico`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `crm`  VARCHAR(255) NULL DEFAULT NULL,
    `nome` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO medico (nome, crm) VALUES ('Dr. Monteiro', '00000000-0/BR');