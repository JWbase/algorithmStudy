SELECT 
    total_score.SCORE,
    e.EMP_NO,
    e.EMP_NAME,
    e.POSITION,
    e.EMAIL
FROM 
    (SELECT 
         EMP_NO,
         SUM(SCORE) AS SCORE
     FROM 
         HR_GRADE
     WHERE 
         YEAR = 2022
     GROUP BY 
         EMP_NO) AS total_score
JOIN 
    HR_EMPLOYEES e ON total_score.EMP_NO = e.EMP_NO
WHERE 
    total_score.SCORE = (SELECT MAX(SCORE) 
                          FROM (SELECT 
                                    EMP_NO,
                                    SUM(SCORE) AS SCORE
                                FROM 
                                    HR_GRADE
                                WHERE 
                                    YEAR = 2022
                                GROUP BY 
                                    EMP_NO) AS score_table)
