-- CREAZIONE DATABASE --
CREATE DATABASE pizzeria;

-- USO DEL DATABASE --
USE pizzeria;

-- TABELLA CLIENTI --
CREATE TABLE Clienti (
    id INT,
    nome VARCHAR(100),
    citta VARCHAR(100)
);

-- TABELLA ORDINI --
CREATE TABLE Ordini (
    id INT,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7 , 2 )
);

-- INSERIMENTO DATI CLIENTI --
INSERT INTO Clienti VALUES 
(1, 'Mario', 'Roma'),
(2, 'Luca', 'Milano'),
(3, 'Giulia', 'Torino'),
(4, 'Anna', 'Napoli'),
(5, 'Marco', 'Bologna'),
(6, 'Chiara', 'Firenze'),
(7, 'Francesco', 'Genova'),
(8, 'Sara', 'Palermo'),
(9, 'Davide', 'Verona'),
(10, 'Alessia', 'Bari'),
(11, 'Giorgio', 'Cagliari'),
(12, 'Elena', 'Trieste'),
(13, 'Simone', 'Modena'),
(14, 'Ilaria', 'Pisa'),
(15, 'Paolo', 'Parma'),
(16, 'Lucia', 'Livorno'),
(17, 'Stefano', 'Salerno'),
(18, 'Valentina', 'Trento'),
(19, 'Matteo', 'Lecce'),
(20, 'Beatrice', 'Reggio');

-- INSERIMENTO DATI ORDINI --
INSERT INTO Ordini VALUES 
(1, 1, '2024-06-01', 120.50),
(2, 2, '2024-06-03', 89.99),
(3, 1, '2024-06-15', 230.00),
(4, 4, '2024-07-01', 59.00),
(5, 6, '2024-07-02', 145.75),
(6, 10, '2024-07-04', 75.50),
(7, 12, '2024-07-05', 199.90),
(8, 14, '2024-07-06', 320.00),
(9, 17, '2024-07-08', 49.99),
(10, 1, '2024-07-10', 99.00),
(11, 18, '2024-07-11', 140.40),
(12, NULL, '2024-07-12', 80.00); 

-- ESERCIZIO 1 – INNER JOIN --
-- CLIENTI CON ALMENO UN ORDINE --
SELECT 
    Clienti.nome AS NomeCliente,
    Ordini.data_ordine AS DataOrdine,
    Ordini.importo AS Importo
FROM Clienti
INNER JOIN Ordini ON Clienti.id = Ordini.id_cliente
ORDER BY Ordini.data_ordine DESC;

-- ESERCIZIO 2 – LEFT JOIN --
-- TUTTI I CLIENTI ACHE SENZA ORDINI --
SELECT 
    Clienti.nome AS NomeCliente,
    Ordini.data_ordine AS DataOrdine,
    Ordini.importo AS Importo
FROM Clienti
LEFT JOIN Ordini ON Clienti.id = Ordini.id_cliente
ORDER BY Ordini.importo ASC;

-- ESERCIZIO 3 – RIGHT JOIN --
-- TTUTTI GLI ORDINI ANCHE SENZA CLIENTE ASSOCIATO --
SELECT 
    Clienti.nome AS NomeCliente,
    Ordini.data_ordine AS DataOrdine,
    Ordini.importo AS Importo
FROM Clienti
RIGHT JOIN Ordini ON Clienti.id = Ordini.id_cliente
ORDER BY Clienti.nome ASC, Ordini.data_ordine DESC;


-- ESERCIZIO 1 SLIDE SUCCESSIVA --
-- ELENCARE NOME CLIENTE, ORDINI EFFETTUATI, SOMMA TOTALE DEGLI IMPORTI SPESI --
SELECT 
    Clienti.nome AS NomeCliente,
    COUNT(Ordini.id) AS TotaleOrdini,
    SUM(Ordini.importo) AS SommaSpesa
FROM Clienti
INNER JOIN Ordini ON Clienti.id = Ordini.id_cliente
GROUP BY Clienti.nome
ORDER BY SommaSpesa DESC;

-- ESERCIZIO 2 SLIDE SUCESSIVA --
-- ELENCARE NOME CLIENTE E CITTA DI RESIDENZA --
SELECT 
    Clienti.nome AS NomeCliente,
    Clienti.citta AS CittaResidenza
FROM Clienti
LEFT JOIN Ordini ON Clienti.id = Ordini.id_cliente
WHERE Ordini.id IS NULL
ORDER BY Clienti.nome ASC;

-- ESERCIZIO 3 --
-- ELENCARE ID ORDINE, DATA ORDINE, IMPORTO, CLIENTE = NULL --
SELECT 
    Ordini.id AS IDOrdine,
    Ordini.data_ordine AS DataOrdine,
    Ordini.importo AS Importo,
    Clienti.nome AS NomeCliente
FROM Clienti
RIGHT JOIN Ordini ON Clienti.id = Ordini.id_cliente
WHERE Clienti.id IS NULL
ORDER BY Ordini.id;



