-- ESERCIZIO 1 --
-- RICHIAMARE LINGUE PARLATE PER NAZIONE E PERCENTUALE DI UTILIZZO --
SELECT
  country.Name AS NomeNazione,
  countrylanguage.Language AS LinguaParlata,
  countrylanguage.Percentage AS Percentuale
FROM 
  country
INNER JOIN countrylanguage
  ON country.Code = countrylanguage.CountryCode
ORDER BY
  country.Name;

-- ESERCIZIO 2 --
-- RICHIAMARE NAZIONI E PERCENTUALE DELLA LINGUA PIU PARLATA --
SELECT
  country.Name AS NomeDellaNazione,
  countrylanguage.Language AS LinguaPiuParlata,
  countrylanguage.Percentage AS PercentualeMassima
FROM
  country
INNER JOIN countrylanguage
  ON country.Code = countrylanguage.CountryCode
WHERE
  countrylanguage.Percentage = (
    SELECT MAX(countrylanguage2.Percentage)
    FROM countrylanguage AS countrylanguage2
    WHERE countrylanguage2.CountryCode = countrylanguage.CountryCode
  )
ORDER BY
  country.Name;


-- ESERCIZIO 3 --
-- UNION 1 E 2 PER MOSTRARE LINGUA PIU PARLATA DI UNA NAZIONA CON PERCENTUALE --
SELECT
  country.Name AS NomeDellaNazione,
  countrylanguage.Language AS LinguaParlata,
  countrylanguage.Percentage AS PercentualeDiUtilizzo,
  (
    SELECT  
    MAX(cl2.Percentage)
    FROM countrylanguage cl2
    WHERE cl2.CountryCode = countrylanguage.CountryCode
  ) AS PercentualeMassimaNellaNazione
FROM 
  country
INNER JOIN countrylanguage
  ON country.Code = countrylanguage.CountryCode
ORDER BY
  country.Name,
  countrylanguage.Percentage DESC;



