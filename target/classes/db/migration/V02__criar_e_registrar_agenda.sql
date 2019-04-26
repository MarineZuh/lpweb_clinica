    
CREATE TABLE agenda (
  id INT NOT NULL AUTO_INCREMENT,
  medico_id INT NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agenda (medico_id) VALUES (1);