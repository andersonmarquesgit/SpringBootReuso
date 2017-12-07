-- Inserts de TB_CUSTOMER --
INSERT INTO tb_customer(id, name)
    VALUES (1,'Anderson Marques');

INSERT INTO tb_customer(id, name)
    VALUES (2,'Carlos Alberto');
    
INSERT INTO tb_customer(id, name)
    VALUES (3,'Heloisa Maria');
    
-- Inserts de TB_ORDER --
INSERT INTO tb_order(id, number, reason, service, customer_id)
    VALUES (1, 1111, 'Defeito', 'Conserto do Produto', 1);

INSERT INTO tb_order(id, number, reason, service, customer_id)
    VALUES (2, 2222, 'Manutenção', 'Manutenção do Produto', 1);
    
INSERT INTO tb_order(id, number, reason, service, customer_id)
    VALUES (3, 3333, 'Devolução', 'Entrega de Produto', 1);
