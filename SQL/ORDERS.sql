Drop Table orders;

create table orders(
    order_id  NUMBER,
    username  VARCHAR2(20),
    paystatus VARCHAR2(20)
);
commit;

SELECT*
FROM orders;

ALTER TABLE orders
ADD ( CONSTRAINT order_id_pk PRIMARY KEY(order_id));

CREATE SEQUENCE order_seq;
