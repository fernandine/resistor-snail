CREATE DATABASE IF NOT EXISTS resistor_db;
USE resistor_db;

CREATE TABLE IF NOT EXISTS tb_resistor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    value DECIMAL(19, 2),
    color_code VARCHAR(255)
);

INSERT INTO tb_resistor (value, color_code) VALUES (47.00, 'amarelo violeta preto dourado');
INSERT INTO tb_resistor (value, color_code) VALUES (100.00, 'marrom preto marrom dourado');
INSERT INTO tb_resistor (value, color_code) VALUES (220.00, 'vermelho vermelho marrom dourado');
INSERT INTO tb_resistor (value, color_code) VALUES (330.00, 'laranja laranja marrom dourado');
INSERT INTO tb_resistor (value, color_code) VALUES (470.00, 'amarelo violeta marrom dourado');