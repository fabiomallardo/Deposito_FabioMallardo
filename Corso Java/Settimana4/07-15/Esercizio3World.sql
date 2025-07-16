-- RECUPERARE LINGUA E NAZIONE DI OGNI CITTA --
SELECT 
City.Name AS Città, 
Country.Name AS Nazione, 
CountryLanguage.Language AS Lingua
FROM 
City
JOIN 
Country ON City.CountryCode = Country.Code
JOIN 
CountryLanguage ON Country.Code = CountryLanguage.CountryCode;

 
-- RECUPERARE NUMERO CITTA PER NAZIONE E NOME NAZIONE ORDINATI IN BASE AL NUMERO DI CITTA --
SELECT 
Country.Name AS Nazione, 
COUNT(City.ID) AS NumeroCittà
FROM 
Country
JOIN 
City ON Country.Code = City.CountryCode
GROUP BY 
Country.Name
ORDER BY 
NumeroCittà DESC;

-- RECUPERARE LISTA DI REPUBBLICHE CON ASPETTATIVA DI VITA > 70 E LINGUA PARLATA --
SELECT 
Country.Name AS Nazione, 
Country.GovernmentForm AS Governo, 
Country.LifeExpectancy AS VitaMedia, CountryLanguage.Language AS Lingua
FROM 
Country
JOIN
CountryLanguage ON Country.Code = CountryLanguage.CountryCode
WHERE 
Country.GovernmentForm LIKE '%Republic%'
AND 
Country.LifeExpectancy > 70
ORDER BY 
VitaMedia ASC;


