-- CASE --
SELECT
Name AS Città,
Population AS Popolazione,
CASE
WHEN 
Population > 5000000 THEN 'Megalopoli'
WHEN 
Population > 1000000 THEN 'Grande città'
WHEN 
Population > 500000 THEN 'Media città'
ELSE 
'Piccola città'
END 
AS Categoria
FROM 
City
ORDER BY 
Population DESC;


SELECT
  Name AS NomeDellaCitta,
  CountryCode AS CodiceDellaNazione,
  Population AS Popolazione
FROM
  city
ORDER BY
  CASE
    WHEN Name IS NULL 
    THEN 
    CountryCode
    ELSE Name
  END;

-- IFNULL --
SELECT
  Name AS NomeDellaCitta,
  IFNULL(Population, 0) AS PopolazioneConValoreDiDefault
FROM
  city;

-- COALESCENCE --
SELECT
  CountryCode AS CodiceNazione,
  COALESCE(Language, 'Lingua sconosciuta') AS Lingua,
  COALESCE(IsOfficial, 'No info') AS StatoUfficialita
FROM
  countrylanguage;

