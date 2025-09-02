-- DML (Data Manipulation Language)
-- Insert (Cadastrar)
-- Update (Atualizar)
-- Delete (Apagar)

-- Opcional
SET search_path TO clinica;
--clinica.paciente -> paciente

--INSERT INTO <SCHEMA>.<TABELA>(<COLUNAS>) VALUES
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('Vinicio','Ortopedia','123456'),
('Ariel','Cardologia','654321'),
('José','Otorrinolaringologia','987654'),
('Daniel','Pediatria','789123'),
('Luciana','Oncologia','321987')

-- DQL (DATA QUERY LANGUAGE) - LINGUAGEM DE CONSULTA DE DADOS
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente(nome, idade, data_nascimento) VALUES
('Zagalo','23','2002-07-20'),
('Ziraldo','80','1940-11-05'),
('Felicia','32','1993-03-13'),
('Peter Parker','45','1980-05-11'),
('Green Goblin','55','1979-05-29')

SELECT * FROM clinica.paciente;

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('Delboni','Local de Exames Especificos X','Rua Niteroi, 180'),
('Senai','Exames de Tecnologia e Raio-X','Rua Vergueiro, 755'),
('ABC Exames','Clinica de exames fáceis','Rua Tatui,80'),
('EF Clinic','Hospital Geral de Clinicas','Rua Balbino,1050')

SELECT * FROM clinica.clinica;

INSERT INTO clinica.consulta(data_, valor, id_medico,id_clinica, id_paciente) VALUES
('2025-08-28 09:30:00-3', 350.75, 1, 2, 2)
(,,)
(,,)
SELECT * FROM clinica.consulta;

UPDATE clinica.consulta
SET valor = 200.50 
WHERE id_medico = 1;

UPDATE clinica.consulta
SET valor = 530
WHERE valor > 500 and valor < 1000;

--DELETE
DELETE FROM clinica.medico
WHERE nome = 'Vinicio';




