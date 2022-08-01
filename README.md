Teste Agrotis - Informações sobre o sistema
-------------------------------------------------------
itens concluídos:
- persistência de dados
- api com endpoints
- tela de cadastro e edição

Itens não concluídos:
- Testes unitários dos serviços
- Tela de listagem de dados



Persistência do projeto
-------------------------------------------------------
- Instalar banco de dados mysql e executar na porta 3306;
- criar usuário root com senha 'root';
- criar banco de dados com nome 'agrotis'
CREATE DATABASE `agrotis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

- criar as tabelas abaixo:
CREATE TABLE IF NOT EXISTS propriedades (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL unique,
	cnpj CHAR(14) NOT NULL unique,
	usuario_cadastro int NOT NULL,    
	data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_alteracao int,
	data_alteracao TIMESTAMP
)  ENGINE=INNODB;

- povoar a tabela com dados:
INSERT INTO agrotis.propriedades (nome, cnpj, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agrotis 1', '04909987000189', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.propriedades (nome, cnpj, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agrotis 2', '04909987000188', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.propriedades (nome, cnpj, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agrotis 3', '04909987000187', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.propriedades (nome, cnpj, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agrotis 4', '04909987000186', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.propriedades (nome, cnpj, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agrotis 5', '04909987000185', 9999, CURRENT_TIMESTAMP, 0, null);


CREATE TABLE IF NOT EXISTS laboratorios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL unique,
	usuario_cadastro int NOT NULL,    
	data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_alteracao int,
	data_alteracao TIMESTAMP
)  ENGINE=INNODB;

INSERT INTO agrotis.laboratorios (nome, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agro Skynet', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.laboratorios (nome, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Umbrella Agro', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.laboratorios (nome, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Osborn Agro', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.laboratorios (nome, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Skyrim Agro', 9999, CURRENT_TIMESTAMP, 0, null);
INSERT INTO agrotis.laboratorios (nome, usuario_cadastro, data_cadastro, usuario_alteracao, data_alteracao) VALUES('Agro Brasil', 9999, CURRENT_TIMESTAMP, 0, null);


CREATE TABLE IF NOT EXISTS teste_agrotis (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255) NOT NULL unique,
	data_inicial TIMESTAMP not null,
	data_final TIMESTAMP not null,
	propriedade_id int NOT NULL,    
	laboratorio_id int NOT NULL,    	
	observacoes VARCHAR(1000),
	usuario_cadastro int NOT NULL,    
	data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usuario_alteracao int,
	data_alteracao TIMESTAMP,
	CONSTRAINT fk_propriedade FOREIGN KEY (propriedade_id) REFERENCES propriedades(id),
	CONSTRAINT fk_laboratorio FOREIGN KEY (laboratorio_id) REFERENCES laboratorios(id)	
)  ENGINE=INNODB;


Telas do sistema
-------------------------------------------------------
http://localhost:8080/   (tela principal, faltou a listagem de dados visual e a paginação)
http://localhost:8080/cadastro (cadastro de registro)
http://localhost:8080/edicao/56  (edicao de dados, com id como parâmetro)

Endpoints
-------------------------------------------------------
Link do collection no POSTMAN:
https://www.getpostman.com/collections/5e6a02cb6929f8378329

Rotas detalhadas:
-------------------------------------------------------
ATUALIZAÇÃO DE REGISTRO:
PUT  http://localhost:8080/teste-agrotis/
JSON
{
    "id": 1,
    "nome": "NOME TESTE",
    "dataInicial": "2022-07-30 15:30:00",
    "dataFinal": "2022-07-30 15:30:00",
    "propriedadeId": 1,
    "laboratorioId": 1,
    "observacoes": " TESTE TESTE TESTE"
}

CADASTRO DE REGISTRO:
POST  http://localhost:8080/teste-agrotis/
JSON
{
    "nome": "NOME TESTE",
    "dataInicial": "2022-07-30 15:30:00",
    "dataFinal": "2022-07-30 15:30:00",
    "propriedadeId": 1,
    "laboratorioId": 1,
    "observacoes": " TESTE TESTE TESTE"
}

LISTAGEM DE DADOS:
GET http://localhost:8080/teste-agrotis/

LISTAGEM DE LABORATORIOS:
GET http://localhost:8080/laboratorios/

LISTAGEM DE PROPRIEDADES:
GET http://localhost:8080/propriedades/

DELETAR REGISTRO DA TABELA 'TESTE-AGROTIS':
DELETE http://localhost:8080/teste-agrotis/3






























