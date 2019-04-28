    
CREATE TABLE paciente (
  id INT NOT NULL AUTO_INCREMENT,
  nome_crianca VARCHAR(100) NOT NULL,
  nome_responsavel VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  endereco_id INT,
  sexo CHAR NOT NULL,
  
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE telefone (
  id INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(10) NOT NULL,
  numero VARCHAR(15) NOT NULL,
  nome_contato VARCHAR(50) NOT NULL,
  paciente_id INT NOT NULL,
  
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE endereco (
  id INT NOT NULL AUTO_INCREMENT,
  rua VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  numero INT NOT NULL,
 	complemento VARCHAR(100) NOT NULL,
 	cidade VARCHAR(100) NOT NULL,
 	estado VARCHAR(100) NOT NULL,
  
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO endereco (id, rua, bairro, numero, complemento, cidade, estado) VALUES (1,'07', 'Cohatrac', 17, '', 'São Luis', 'Maranhão');
INSERT INTO paciente (id, nome_crianca, nome_responsavel, data_nascimento, sexo, endereco_id) VALUES (1,'Maria', 'Ana', '2006-04-03', 'F', 1);
INSERT INTO telefone (id, tipo, numero, nome_contato, paciente_id) VALUES (1, 'celular', '09812344321', 'Ana', 1);
