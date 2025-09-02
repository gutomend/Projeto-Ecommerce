INSERT INTO TECHMARKET.CLIENTE (NOME_COMPLETO, EMAIL, SENHA, TELEFONE) 
VALUES
('João Silva', 'joao.silva@email.com', 'senha1234', 987654321),
('Maria Oliveira', 'maria.oliveira@email.com', 'senha5678', 976543210),
('Pedro Souza', 'pedro.souza@email.com', 'senha91011', 345678901),
('Ana Costa', 'ana.costa@email.com', 'senha1213', 934567890);

INSERT INTO TECHMARKET.PRODUTO (NOME_PRODUTO, DESCRICAO, PRECO, ESTOQUE_DISPONIVEL, IMAGEM_URL) 
VALUES
('Notebook Dell', 'Notebook com 16GB de RAM e 512GB SSD', 3500, 50, 'https://www.example.com/img/dell-notebook.jpg'),
('Smartphone Samsung Galaxy', 'Smartphone com 128GB de armazenamento', 2000, 100, 'https://www.example.com/img/samsung-galaxy.jpg'),
('Fone de Ouvido JBL', 'Fone de ouvido Bluetooth, som de alta qualidade', 350, 200, 'https://www.example.com/img/jbl-headphones.jpg'),
('Câmera Canon EOS', 'Câmera digital DSLR de 24MP', 4500, 30, 'https://www.example.com/img/canon-camera.jpg');

INSERT INTO TECHMARKET.PEDIDO (CLIENTE_ID, DATA_PEDIDO, VALOR_TOTAL, STATUS) 
VALUES
(1, '2025-09-01 10:00:00', 3500, 'Em andamento'),
(2, '2025-09-02 14:30:00', 2000, 'Concluído'),
(3, '2025-09-03 16:00:00', 3850, 'Em andamento'),
(4, '2025-09-04 12:00:00', 4850, 'Cancelado');

INSERT INTO TECHMARKET.ITEM_DO_PEDIDO (PEDIDO_ID, PRODUTO_ID, QUANTIDADE) 
VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(3, 4, 1),
(4, 1, 1);

INSERT INTO TECHMARKET.PAGAMENTO (PEDIDO_ID, FORMA_PAGAMENTO, STATUS, DATA_PAGAMENTO) 
VALUES
(1, 'Cartão de Crédito', 'Pendente', '2025-09-01 11:00:00'),
(2, 'Boleto', 'Pago', '2025-09-02 15:00:00'),
(3, 'Pix', 'Pendente', '2025-09-03 17:00:00'),
(4, 'Cartão de Crédito', 'Cancelado', '2025-09-04 13:00:00');
