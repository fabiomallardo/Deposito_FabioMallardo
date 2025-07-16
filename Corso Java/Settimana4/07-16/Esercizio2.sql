-- ESERCIZIO --
/* 
RECUPERARE E MOSTRARE LA CITTA CON CODICE NAZIONE INDICATO DALL'UTENTE. INOLTRE DECIDE 
L'ORDINE CON CUI ORDINARE LA CITTA DESC O NO;
FILTRARE O MENO LE CITTA PER UN MINIMO DI POPOLAZIONE;
MOSTRAR O MENO IL NOME DELLA NAZIONE A CUI FA RIFERIMENTO IL CODICE 
*/

SELECT
  city.Name AS NomeDellaCitta,
  city.Population AS Popolazione,
  city.CountryCode AS CodiceDellaNazione,
  country.Name AS NomeDellaNazione,
  
  CASE
    WHEN city.Population >= 500000 THEN 'GRANDE'
    WHEN city.Population >= 100000 THEN 'MEDIA'
    ELSE 'PICCOLA'
  END AS CategoriaPopolazione

FROM
  city
INNER JOIN country 
  ON city.CountryCode = country.Code

WHERE
  city.CountryCode = 'ITA'
  AND city.Population >= 100000

ORDER BY
  city.Name DESC;

