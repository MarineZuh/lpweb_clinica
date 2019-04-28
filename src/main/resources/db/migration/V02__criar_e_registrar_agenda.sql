    
CREATE TABLE agenda (
  id INT NOT NULL AUTO_INCREMENT,
  medico_id INT NOT NULL,
  dataHorario DATETIME NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agenda (medico_id, dataHorario) VALUES (1, '2019-04-03 14:30:00');