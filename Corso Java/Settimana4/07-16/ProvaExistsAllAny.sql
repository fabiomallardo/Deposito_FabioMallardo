-- HAVING --
SELECT CountryCode, COUNT(*) AS NumeroLingue
FROM CountryLanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode
HAVING COUNT(*) > 1;

SELECT Country.Name, COUNT(*) AS NumeroLingue
FROM Country
JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode
WHERE CountryLanguage.IsOfficial = 'T'
GROUP BY Country.Name
HAVING COUNT(*) > 1;

SELECT Country.Name, COUNT(City.ID) AS NumeroCittà
FROM Country
JOIN City ON Country.Code = City.CountryCode
GROUP BY Country.Name
HAVING COUNT(City.ID) > 10
ORDER BY NumeroCittà DESC;


-- EXISTS --
SELECT 
Country.Name
FROM 
country
WHERE EXISTS
(SELECT Country.Name FROM country WHERE Name = 'Iraq');

-- ANY --
SELECT 
country.Name, 
country.Population
FROM 
country
WHERE 
Population > ANY (
    SELECT Population
    FROM Country
    WHERE Continent = 'Africa'
);

-- ALL --
SELECT Name, Population
FROM Country
WHERE Population > ALL (
    SELECT Population
    FROM Country
    WHERE Continent = 'Europe'
);

