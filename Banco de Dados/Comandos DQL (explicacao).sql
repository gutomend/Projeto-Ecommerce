-- DQL - Consulta campos especificos
SELECT nome_completo, telefone FROM techmarket.cliente;

SELECT nome, idade, cpf FROM clinica.paciente;

-- Consultar tudo
SELECT * FROM clinica.medico;

Select * from techmarket.cliente;

-- JOIN - juntar tabelas usando FK

-- Listar data, valor, nome do medico
SELECT data_, valor, nome FROM clinica.consulta
JOIN clinica.medico ON clinica.consulta.id_medico = clinica.medico.id_medico

--
SELECT cs.data_, cs.valor, med.nome 
FROM clinica.consulta AS cs
JOIN clinica.medico AS med
ON cs.id_medico = med.id_medico

SELECT * FROM techmarket.cliente;






