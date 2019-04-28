    
CREATE TABLE medico (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  crm VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO medico (nome, crm) VALUES ('Dr. Monteiro', '00000000-0/BR');