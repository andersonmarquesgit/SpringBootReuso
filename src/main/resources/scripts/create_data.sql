-- Inserts de TB_CUSTOMER --
INSERT INTO tb_customer(id, name)
    VALUES (1,'Anderson Marques');

INSERT INTO tb_customer(id, name)
    VALUES (2,'Carlos Alberto');
    
INSERT INTO tb_customer(id, name)
    VALUES (3,'Heloisa Maria');
    
-- Inserts de TB_ORDER e TB_CUSTOMER_ORDERS --
INSERT INTO tb_order(id, number, reason, service)
    VALUES (1, 1111, 'Defeito', 'Conserto do Produto');
INSERT INTO tb_customer_orders(customer_id, order_id)
    VALUES (1, 1);

INSERT INTO tb_order(id, number, reason, service)
    VALUES (2, 2222, 'Manutenção', 'Manutenção do Produto');
INSERT INTO tb_customer_orders(customer_id, order_id)
    VALUES (1, 2);
    
INSERT INTO tb_order(id, number, reason, service)
    VALUES (3, 3333, 'Devolução', 'Entrega de Produto');
INSERT INTO tb_customer_orders(customer_id, order_id)
    VALUES (1, 3);