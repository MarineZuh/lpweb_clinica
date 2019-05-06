CREATE TABLE IF NOT EXISTS `historico_peso_altura`
(
    `id`     INT(11) NOT NULL AUTO_INCREMENT,
    `altura` DOUBLE  NULL DEFAULT NULL,
    `data`   DATE    NULL DEFAULT NULL,
    `peso`   DOUBLE  NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)engine = InnoDB
 DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `prontuario`
(
    `id`                       INT(11)      NOT NULL AUTO_INCREMENT,
    `observacao_clinica`       VARCHAR(255) NULL DEFAULT NULL,
    `sintomas`                 VARCHAR(255) NULL DEFAULT NULL,
    `historico_peso_altura_id` INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `consulta`
(
    `id`               INT(11)  NOT NULL AUTO_INCREMENT,
    `data_horario`     DATETIME NULL DEFAULT NULL,
    `eh_encaixe`       BIT(1)   NULL DEFAULT NULL,
    `eh_paciente_novo` BIT(1)   NULL DEFAULT NULL,
    `medico_id`        INT(11)  NULL DEFAULT NULL,
    `paciente_id`      INT(11)  NULL DEFAULT NULL,
    `prontuario_id`    INT(11)  NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE IF NOT EXISTS `prontuario_exames`
(
    `prontuario_id` INT(11) NOT NULL,
    `exame_id`      INT(11) NOT NULL
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO consulta(data_horario, eh_encaixe, eh_paciente_novo, medico_id, paciente_id)
    VALUES ('2019-05-05 14:30:00', false, false, 1, 1);