WITH RECURSIVE Generation_CTE AS (
    SELECT ID, PARENT_ID, 1 AS generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT e.ID, e.PARENT_ID, g.generation + 1
    FROM ECOLI_DATA e
    JOIN Generation_CTE g ON e.PARENT_ID = g.ID
)
SELECT ID
FROM Generation_CTE
WHERE generation = 3
ORDER BY ID;