--  Elenco di nomi unici delle nazioni -- 
SELECT DISTINCT
    Name
FROM
    world.country;

--  Numero di paesi distinti per nome --
SELECT 
    COUNT(DISTINCT Name)
FROM
    world.country;

-- WHERE CLAUSE --
SELECT 
    *
FROM
    world.country
WHERE
    Region = 'Caribbean';
    

-- NULL --
SELECT 
    *
FROM
    world.country
WHERE
    IndepYear IS NULL;
    
-- AND --
SELECT 
    *
FROM
    world.country
WHERE
    IndepYear IS NULL AND Name = 'Aruba';

-- OR ..
SELECT 
    *
FROM
    world.country
WHERE
    IndepYear IS NOT NULL OR Name = 'Aruba';

-- NOT --
SELECT 
    *
FROM
    world.country
WHERE
    IndepYear IS NOT NULL
        OR NOT (Name = 'Aruba');
        
-- ORDER BY ASC --
SELECT 
    name
FROM
    world.country
ORDER BY Name ASC;

-- ORDER BY DESC --
SELECT 
    name
FROM
    world.country
ORDER BY Name DESC;

-- ORDER BY --
SELECT 
    *
FROM
    world.country
ORDER BY Region, SurfaceArea DESC;

-- GROUP BY --
SELECT 
    Name, COUNT(CountryCode)
FROM
    world.city
GROUP BY Name
ORDER BY Name DESC;

-- INSERT INTO --
INSERT INTO world.city (Name, CountryCode, District, Population)
VALUES 
    ('BBB', 'ITA', 'Lazio', 120000),
    ('CCC', 'FRA', 'Île-de-France', 500000),
    ('DDD', 'ESP', 'Cataluña', 300000);

SELECT * FROM world.city
ORDER BY ID ASC;

-- UPDATE --
UPDATE world.city
SET Name = 'Fabio', CountryCode = 'ITA'
WHERE ID = 2;

SELECT * FROM world.city
ORDER BY ID ASC;

-- DELETE --
DELETE FROM world.city
WHERE ID = 2;



