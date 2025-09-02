/*
## Atividades de DQL
### **Intermediários**

### **1. Junção Simples (JOIN)**
- **Exercício:** Para cada pedido, mostre o ID do pedido e o nome completo do cliente que o realizou.
- **Dica:** Use o `JOIN` para combinar a tabela de pedidos com a de clientes e a cláusula `ON` para especificar a chave de ligação entre elas (`cliente_id`).
*/
SELECT pedido_id, nome_completo FROM techmarket.pedido
JOIN techmarket.cliente ON techmarket.pedido.cliente_id = techmarket.cliente.cliente_id

/*### **2. Junção com Filtro**
- **Exercício:** Liste o nome de todos os produtos que foram vendidos no pedido de `pedido_id = 1`.
- **Dica:** Combine `JOIN` (para unir `produtos` e `itens_do_pedido`) com a cláusula `WHERE` para filtrar pelo ID do pedido desejado.
*/


/*
### **3. Agrupamento e Contagem (GROUP BY e COUNT)**
- **Exercício:** Conte quantos pedidos cada cliente já fez e mostre o nome do cliente ao lado da contagem.
- **Dica:** Você precisará usar `JOIN`, agrupar os resultados por cliente com `GROUP BY` e usar a função `COUNT()` para contar os pedidos de cada grupo.
*/


/*
### **4. Agrupamento e Soma (GROUP BY e SUM)**
- **Exercício:** Calcule o valor total gasto por cada cliente. O resultado deve exibir o nome do cliente e o valor total.
- **Dica:** Similar ao anterior, mas use a função `SUM()` para somar os valores dos pedidos de cada cliente agrupado.
*/

