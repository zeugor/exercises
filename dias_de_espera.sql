SELECT ID, Fecha_Entrada, Fecha_Salida, DATEDIFF(Fecha_Salida, Fecha_Entrada) AS Dias_espera 
FROM testing.fechas 
WHERE Fecha_Salida IS NOT NULL

UNION 

SELECT ID, Fecha_Entrada, Fecha_Salida, DATEDIFF(CURDATE(), Fecha_Entrada) AS Dias_espera
FROM testing.fechas 
WHERE Fecha_Salida IS NULL