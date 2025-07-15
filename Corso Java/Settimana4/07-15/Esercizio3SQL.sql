-- USO DEL DB WORLD --
USE world;

-- OPERATORE LIKE --
SELECT * FROM world.country
WHERE Name LIKE 'a%';

-- OPERATORE IN --
SELECT Name
FROM country
WHERE Name IN ('Aruba', 'Ciao');

SELECT *
FROM country
WHERE Name IN (SELECT Name FROM city);


-- BETWEEN --
SELECT Name 
FROM country
WHERE Name BETWEEN 'Armenia' AND 'Macao';

SELECT Population FROM city
WHERE Population BETWEEN 10000 AND 20000;

