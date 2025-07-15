-- LIMIT --
SELECT 
    *
FROM
    world.country
LIMIT 10;

-- ALIAS --
SELECT 
    Name AS Nome
FROM
    world.country AS Nazione;
    
-- MIN MAX --
SELECT 
    MIN(Population) AS NumeroMinimoPopolazione
FROM
    world.city;

SELECT 
    MAX(Population) AS NumeroMassimoPopolazione
FROM
    world.city;

-- COUNT AVG SUM -- 
SELECT 
    COUNT(Name) AS TotaleNomi
FROM
    world.country;

SELECT 
    AVG(Population) AS ValoreMedio
FROM
    world.country;

SELECT 
    SUM(Population) AS Somma
FROM
    world.country;

