-- 1. Creazione nuova tabella --
CREATE TABLE Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5 , 2 ),
    anno_pubblicazione INT
);

-- 2. Inserimento dei nuovi dati nella tabella Libri -- 
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione) VALUES
(1, 'Il codice da Vinci', 'Dan Brown', 'Thriller', 12.99, 2003),
(2, '1984', 'George Orwell', 'Distopico', 9.50, 2008),
(3, 'Sapiens', 'Yuval Noah Harari', 'Saggistica', 14.90, 2014),
(4, 'Harry Potter e la Pietra Filosofale', 'J.K. Rowling', 'Fantasy', 11.99, 2001),
(5, 'Il Signore degli Anelli', 'J.R.R. Tolkien', 'Fantasy', 15.00, 2002),
(6, 'La ragazza del treno', 'Paula Hawkins', 'Giallo', 10.75, 2015);


/* 3. Scrivere una query che, usando il comando GROUP BY, mostri per ogni genere:
il numero totale di libri presenti;
il prezzo medio dei libri appartenenti a quel genere.
La query dovrà restituire il risultato ordinato alfabeticamente per genere.  */

SELECT 
    genere, COUNT(*), AVG(prezzo)
FROM
    Libri
GROUP BY genere
ORDER BY genere;


/* 4. Scrivere una query che elenchi tutti i libri pubblicati dopo l’anno 2010 ordinati in modo decrescente per anno di pubblicazione e,
in caso di anno uguale, in ordine crescente per prezzo. */

SELECT 
    *
FROM
    Libri
WHERE
    anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC , prezzo ASC

