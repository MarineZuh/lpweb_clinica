    
CREATE TABLE agenda (
  id INT NOT NULL AUTO_INCREMENT,
  medico_id INT NOT NULL,
  data_horario DATETIME NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agenda (medico_id, data_horario) VALUES (1, '2019-04-03 14:30:00');