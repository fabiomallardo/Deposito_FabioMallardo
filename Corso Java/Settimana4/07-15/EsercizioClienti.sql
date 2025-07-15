-- ESERCIZIO CLIENTI --

-- CREAZIONE DATABASE --
CREATE DATABASE anagrafe;

-- USO DEL DATABASE --
USE anagrafe;

-- TABELLA CLIENTI --
CREATE TABLE Clienti (
    id INT,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    email VARCHAR(100),
    eta INT,
    citta VARCHAR(100)
);

-- INSERIMENTO DEI VALORI NELLA TABELLA --
INSERT INTO Clienti VALUES (1, 'Alessandro', 'Rossi', 'ale.rossi@gmail.com', 32, 'Roma');
INSERT INTO Clienti VALUES (2, 'Giulia', 'Bianchi', 'giulia.bianchi@yahoo.it', 45, 'Milano');
INSERT INTO Clienti VALUES (3, 'Andrea', 'Verdi', 'andreav@gmail.com', 29, 'Napoli');
INSERT INTO Clienti VALUES (4, 'Anna', 'Santi', 'anna.santi@gmail.com', 38, 'Torino');
INSERT INTO Clienti VALUES (5, 'Marco', 'Neri', 'marco.neri@gmail.com', 34, 'Palermo');
INSERT INTO Clienti VALUES (6, 'Chiara', 'Lodi', 'chiara.lodi@libero.it', 27, 'Verona');
INSERT INTO Clienti VALUES (7, 'Luca', 'Fonti', 'l.fonti@gmail.com', 30, 'Roma');
INSERT INTO Clienti VALUES (8, 'Francesca', 'Ferri', 'francesca.f@gmail.com', 31, 'Cagliari');
INSERT INTO Clienti VALUES (9, 'Antonio', 'Vinci', 'antonio.vinci@outlook.com', 52, 'Firenze');
INSERT INTO Clienti VALUES (10, 'Alberto', 'Bruni', 'al.bruni@gmail.com', 39, 'Genova');
INSERT INTO Clienti VALUES (11, 'Davide', 'Corti', 'd.corti@gmail.com', 33, 'Roma Nord');
INSERT INTO Clienti VALUES (12, 'Giorgia', 'Sole', 'giorgia.sole@gmail.com', 29, 'Roma Sud');
INSERT INTO Clienti VALUES (13, 'Stefano', 'Riva', 'stefano.riva@hotmail.com', 41, 'Bologna');
INSERT INTO Clienti VALUES (14, 'Martina', 'Fiore', 'martina.fiore@gmail.com', 35, 'Bari');
INSERT INTO Clienti VALUES (15, 'Aurora', 'Luna', 'aurora.l@gmail.com', 26, 'Perugia');
INSERT INTO Clienti VALUES (16, 'Adriano', 'Ponte', 'adriano.p@gmail.com', 40, 'Tivoli');
INSERT INTO Clienti VALUES (17, 'Beatrice', 'Alba', 'bea.alba@tiscali.it', 48, 'Roma');
INSERT INTO Clienti VALUES (18, 'Federico', 'Greco', 'federico.greco@gmail.com', 37, 'Catanzaro');
INSERT INTO Clienti VALUES (19, 'Arianna', 'Petra', 'arianna.p@gmail.com', 30, 'ROMA');
INSERT INTO Clienti VALUES (20, 'Nicola', 'Mauri', 'nicola.mauri@gmail.com', 36, 'Matera');


-- 1. Clienti con email su dominio Gmail
SELECT * 
FROM Clienti 
WHERE email LIKE '%@gmail.com';

-- 3. Clienti con nome che inizia con la lettera 'A'
SELECT * 
FROM Clienti 
WHERE nome LIKE 'A%';

-- 5. Clienti con cognome che contiene esattamente 5 lettere
SELECT * 
FROM Clienti 
WHERE LENGTH(cognome) = 5;

-- 7. Clienti con età compresa tra 30 e 40 anni (inclusi)
SELECT * 
FROM Clienti 
WHERE eta BETWEEN 30 AND 40;

-- 9. Clienti che vivono in città il cui nome contiene 'roma' (maiuscole/minuscole ignorate)
SELECT * 
FROM Clienti 
WHERE LOWER(citta) LIKE '%roma%';




