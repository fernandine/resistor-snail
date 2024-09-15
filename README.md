# Desafio Resistores – Código de Cores / Snail

## Introdução

Os resistores são componentes elétricos essenciais, marcados com listras ou faixas coloridas para indicar o valor da resistência em ohms e a tolerância permitida. Este projeto visa converter valores de resistência em suas respectivas sequências de cores, facilitando a identificação dos resistores necessários para o seu projeto.

## Código de Cores dos Resistores

Os códigos de cores dos resistores são:

- **0**: preto
- **1**: marrom
- **2**: vermelho
- **3**: laranja
- **4**: amarelo
- **5**: verde
- **6**: azul
- **7**: violeta
- **8**: cinza
- **9**: branco

### Estrutura do Código de Cores

Todos os resistores possuem pelo menos três bandas:
- **Primeira e Segunda Banda**: Correspondem ao primeiro e segundo dígito do valor de ohms.
- **Terceira Banda**: Indica a potência de 10 para multiplicar e obter o valor total em ohms.
- **Quarta Banda** (opcional): Indica a tolerância, geralmente representada por uma faixa dourada ou prata.


## Desafio

Sua tarefa é criar uma função que converta um valor de resistência fornecido como string, seguido pela palavra "ohms", para a sequência de cores correspondente. As regras de formatação dos valores são as seguintes:

- **Resistores menores que 1.000 ohms**: O valor é apresentado como um número simples. Exemplo: "47 ohms" deve retornar "amarelo violeta preto dourado".
- **Resistores de 1.000 ohms a menos de 1.000.000 ohms**: O valor é dividido por 1.000 e acrescentado de um "k". Exemplo: "4.7k ohms" deve retornar "amarelo violeta vermelho dourado".
- **Resistores de 1.000.000 ohms ou mais**: O valor é dividido por 1.000.000 e acrescentado de um "M". Exemplo: "1M ohms" deve retornar "marrom preto verde dourado".

### Mais Exemplos

- "10 ohms" → "marrom preto preto dourado"
- "100 ohms" → "marrom preto marrom dourado"
- "220 ohms" → "vermelho vermelho marrom dourado"
- "330 ohms" → "laranja laranja marrom dourado"
- "470 ohms" → "amarelo violeta marrom dourado"
- "680 ohms" → "azul cinza marrom dourado"
- "1k ohms" → "marrom preto vermelho dourado"
- "2M ohms" → "vermelho preto verde dourado"

## Observações

- Os números decimais de entrada são sempre separados por ponto.

## Documentação da API

A API está documentada via Swagger. Você pode acessar a interface do Swagger para visualizar e interagir com os endpoints através do seguinte link:

[Swagger UI - Documentação da API](http://localhost:8080/swagger-ui/index.html)

## Coleção do Postman

Você pode importar e testar os endpoints da API usando a coleção do Postman disponível no seguinte link:

[Collection do Postman](https://orange-escape-442392.postman.co/workspace/New-Team-Workspace~48c652ad-db8e-45b6-8aea-021ffa5b77ff/folder/20815894-cb7f0665-373d-467d-bc66-e801117ab118?action=share&source=copy-link&creator=20815894&ctx=documentation)

## Criação da Tabela no Banco de Dados

Para criar a tabela `tb_resistor` e popular com alguns valores iniciais, você pode usar o seguinte script SQL:

```sql
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

