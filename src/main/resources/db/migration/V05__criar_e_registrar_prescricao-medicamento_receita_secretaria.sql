CREATE TABLE IF NOT EXISTS `receita`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `medico_id` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `prescricao_medicamento`
(
    `id`             INT(11)      NOT NULL AUTO_INCREMENT,
    `administração`  VARCHAR(255) NULL DEFAULT NULL,
    `dosagem`        VARCHAR(255) NULL DEFAULT NULL,
    `tempo_uso`      VARCHAR(255) NULL DEFAULT NULL,
    `medicamento_id` INT(11)      NULL DEFAULT NULL,
    `prontuario_id`  INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE IF NOT EXISTS `receita_prescrioes_medicamento`
(
    `receita_id`               INT(11) NOT NULL,
    `pescricao_medicamento_id` INT(11) NOT NULL
) engine = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `secretaria`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO secretaria (nome) VALUES ('Juliana');