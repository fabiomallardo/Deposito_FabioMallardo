USE world;

-- INNER JOIN --
SELECT 
    city.Name AS NomeCittà,
    city.Population AS PopolazioneCittà,
    country.Name AS NomePaese,
    country.Population AS PopolazionePaese
FROM
    city
        INNER JOIN
    country ON city.CountryCode = country.Code

-- LEFT JOIN --
SELECT 
    city.Name AS CityName,
    city.Population AS PopolazioneCittà,
    country.Name AS CountryName
FROM
    city
        LEFT JOIN
    Country ON City.CountryCode = Country.Code

-- RIGHT JOIN --
SELECT 
city.Name AS CittàNome,
city.Population AS PopolazioneCittà,
country.Name AS CountryName
FROM city
RIGHT JOIN Country ON City.CountryCode = Country.Code;

-- CROSS ORIGIN --
SELECT 
    city.Name AS CittàNome,
    country.Name AS PaeseNome
FROM city
CROSS JOIN country;

