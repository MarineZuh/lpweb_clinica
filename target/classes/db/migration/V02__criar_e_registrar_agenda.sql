CREATE TABLE IF NOT EXISTS `agenda`
(
    `id`            INT(11)      NOT NULL AUTO_INCREMENT,
    `dia_da_semana` VARCHAR(255) NULL DEFAULT NULL,
    `medico_id`     INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `agenda_horarios`
(
    `agenda_id` INT(11) NOT NULL,
    `horario`   TIME    NULL DEFAULT NULL
) engine = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO agenda (id, medico_id, dia_da_semana) VALUES (1, 1, 'SEGUNDA');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '14:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '14:30:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '15:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '15:30:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '16:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '16:30:00');