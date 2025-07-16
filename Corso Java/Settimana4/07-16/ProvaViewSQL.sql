-- VIEW --
USE world;

CREATE VIEW EuropeanCountriesPopulous AS
SELECT Name, Continent, Population
FROM country
WHERE Continent = 'Europe' AND Population > 20000000;
