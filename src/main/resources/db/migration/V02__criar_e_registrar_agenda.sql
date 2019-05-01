
CREATE TABLE agenda (
  id INT NOT NULL AUTO_INCREMENT,
  medico_id INT NOT NULL,
  dia_da_semana VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agenda_horarios (
    agenda_id INT NOT NULL,
    horario TIME NOT NULL,
    PRIMARY KEY (agenda_id, horario)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agenda (id, medico_id, dia_da_semana) VALUES (1, 1, 'SEGUNDA');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '14:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '14:30:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '15:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '15:30:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '16:00:00');
INSERT INTO agenda_horarios (agenda_id, horario) VALUES (1, '16:30:00');