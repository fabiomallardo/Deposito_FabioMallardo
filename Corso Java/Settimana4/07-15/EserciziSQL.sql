-- ESERCIZIO 1 --
/* Elencare, senza ripetizioni, tutte le regioni (Region) dei paesi che appartengono al continente (Continent) 'Europe'. */

SELECT DISTINCT
    Region
FROM
    world.country
WHERE
    Continent = 'Europe';

-- ESERCIZIO 2 --
/* Elencare i nomi (Name) e la popolazione (Population) delle città (City) degli Stati Uniti (CountryCode = 'USA') 
che hanno una popolazione superiore a 1.000.000 abitanti, ordinando i risultati dalla città più popolosa alla meno popolosa. */

SELECT 
    Name, Population
FROM
    world.city
WHERE
    CountryCode = 'USA'
        AND Population > 1000000
ORDER BY Population DESC;

-- ESERCIZIO 3 --
/* Mostrare per ogni continente (Continent) presente nella tabella Country:
Il numero totale di paesi appartenenti a ciascun continente.
La popolazione totale del continente.
Ordinare il risultato per popolazione totale in ordine decrescente. */

SELECT Continent,
       COUNT(*),
       SUM(Population)
FROM world.country
GROUP BY Continent
ORDER BY SUM(Population) DESC;

