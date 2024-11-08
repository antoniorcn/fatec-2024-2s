CREATE DATABASE agendadb;

USE agendadb;

CREATE TABLE contatos ( 
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone CHAR(50),
    PRIMARY KEY(id)
);

INSERT INTO contatos (nome, email, telefone)
VALUES ('Joao Silva', 'joao@teste.com', '(11)1111-1111')