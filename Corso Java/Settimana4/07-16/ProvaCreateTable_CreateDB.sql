-- 1. Crea un database chiamato testdb
CREATE DATABASE testdb;

-- 2. Usa il database
USE testdb;

-- 3. Crea una tabella chiamata utenti
CREATE TABLE utenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);

-- 4. Inserisci un utente di esempio
INSERT INTO utenti (nome, email) VALUES ('Mario Rossi', 'mario@example.com');

-- 5. Visualizza i dati inseriti
SELECT * FROM utenti;

-- 6. Crea una seconda tabella copiando struttura e dati da utenti
CREATE TABLE utenti_backup
SELECT nome, email FROM utenti;

-- 7. Verifica che la tabella di backup sia stata creata
SELECT * FROM utenti_backup;

-- 8. Elimina la tabella utenti
DROP TABLE utenti;

-- 9. Elimina anche la tabella utenti_backup
DROP TABLE utenti_backup;

-- 10. Esci dal database (opzionale)
USE mysql;

-- 11. Elimina il database
DROP DATABASE testdb;
