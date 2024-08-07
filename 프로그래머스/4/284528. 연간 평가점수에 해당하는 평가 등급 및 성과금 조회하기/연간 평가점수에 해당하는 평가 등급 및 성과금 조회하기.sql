SELECT 
    e.EMP_NO, 
    e.EMP_NAME, 
    CASE
        WHEN avg_score >= 96 THEN 'S'
        WHEN avg_score >= 90 THEN 'A'
        WHEN avg_score >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN avg_score >= 96 THEN e.SAL * 0.20
        WHEN avg_score >= 90 THEN e.SAL * 0.15
        WHEN avg_score >= 80 THEN e.SAL * 0.10
        ELSE 0
    END AS BONUS
FROM 
    HR_EMPLOYEES e
JOIN (
    SELECT 
        EMP_NO, 
        AVG(SCORE) AS avg_score
    FROM 
        HR_GRADE
    WHERE 
        YEAR = 2022
    GROUP BY 
        EMP_NO
) g ON e.EMP_NO = g.EMP_NO
ORDER BY 
    e.EMP_NO;