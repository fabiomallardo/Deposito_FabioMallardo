-- 1. CREAZIONE NUOVO DB --
CREATE DATABASE negozioVendita;

-- 2.  USARE IL DB --
USE negozioVendita;

-- 3. CREAZIONE TABELLA VENDITA --
CREATE TABLE Vendite (
    id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6 , 2 ),
    data_vendita DATE
);

-- 4. INSERIMENTO VALORI NELLA TABELLA --
INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'Laptop HP', 'Elettronica', 2, 750.00, '2024-01-10'),
(2, 'Mouse Logitech', 'Elettronica', 5, 25.99, '2024-01-12'),
(3, 'Monitor Samsung', 'Elettronica', 1, 190.50, '2024-02-03'),
(4, 'Cuffie Sony', 'Elettronica', 3, 89.90, '2024-03-15'),
(5, 'Tastiera meccanica', 'Elettronica', 4, 65.00, '2024-04-01'),
(6, 'Zaino scuola', 'Cartoleria', 6, 32.00, '2024-01-20'),
(7, 'Penna biro', 'Cartoleria', 20, 1.20, '2024-02-05'),
(8, 'Quaderno A4', 'Cartoleria', 10, 2.50, '2024-03-08'),
(9, 'Calcolatrice', 'Cartoleria', 2, 18.90, '2024-02-15'),
(10, 'Righello', 'Cartoleria', 8, 1.50, '2024-02-25'),
(11, 'Scarpe running', 'Sport', 2, 95.00, '2024-01-30'),
(12, 'Tappetino yoga', 'Sport', 1, 29.99, '2024-03-12'),
(13, 'Pallone calcio', 'Sport', 3, 35.00, '2024-04-02'),
(14, 'Racchetta tennis', 'Sport', 1, 120.00, '2024-03-20'),
(15, 'Guanti palestra', 'Sport', 4, 15.50, '2024-03-22'),
(16, 'Bottiglia termica', 'Sport', 5, 12.99, '2024-04-10'),
(17, 'Smartwatch', 'Elettronica', 1, 199.99, '2024-04-18'),
(18, 'Zaino scuola', 'Cartoleria', 3, 32.00, '2024-04-20'),
(19, 'Mouse Logitech', 'Elettronica', 2, 25.99, '2024-05-05'),
(20, 'Penna biro', 'Cartoleria', 10, 1.20, '2024-05-07');

-- 5. VENDITE PER CATEGORIE --
SELECT categoria, COUNT(*) AS Totale
FROM Vendite
GROUP BY categoria;

-- 6. PREZZO MEDIO PER CATEGORIA --
SELECT categoria, AVG(prezzo_unitario) AS PrezzoMedio
FROM Vendite
GROUP BY categoria;

-- 7. TOTALE PRODOTTI VENDUTI
SELECT prodotto, SUM(quantita) AS Totale
FROM Vendite
GROUP BY prodotto
ORDER BY Totale ASC;

-- 8. PREZZO MASSIMO E MINIMO --
SELECT prodotto, MAX(prezzo_unitario) AS PrezzoMassimo
FROM Vendite
GROUP BY prodotto
ORDER BY PrezzoMassimo DESC;

SELECT prodotto, MIN(prezzo_unitario) AS PrezzoMinimo
FROM Vendite
GROUP BY prodotto
ORDER BY PrezzoMinimo;

-- TOTALE RIGHE TABELLA --
SELECT COUNT(*) AS NumeroRighe
FROM Vendite;

-- 5 PRODOTTI PIU COSTOSI --
SELECT DISTINCT prodotto, prezzo_unitario
FROM Vendite
ORDER BY prezzo_unitario DESC
LIMIT 5;

-- 3 PRODOTTI MENO VENDUTI --
SELECT prodotto, SUM(quantita) AS ProdottoNonVenduto
FROM Vendite
GROUP BY prodotto
ORDER BY ProdottoNonVenduto ASC
LIMIT 3;


