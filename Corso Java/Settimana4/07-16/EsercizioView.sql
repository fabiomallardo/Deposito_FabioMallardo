-- ESERCIZIO --
-- CREAREA VIEW DI CITY IN DB WORLD SU UNA QUERY CHE MOSTRA LE CITTA ITALIANE CON POPOLAZIONIONE < 100K --

CREATE VIEW CittaItaliane AS
SELECT 
city.Name AS NomeCitta,
city.Population AS Popolazione
FROM
city
WHERE 
CountryCode = 'ITA';

SELECT * FROM CittaItaliane
WHERE Popolazione < 100000;

DROP VIEW CittaItaliane;
