WITH skill_codes AS (
    SELECT 
        SUM(CASE WHEN CATEGORY = 'Front End' THEN CODE ELSE 0 END) AS front_end_mask,
        SUM(CASE WHEN NAME = 'Python' THEN CODE ELSE 0 END) AS python_mask,
        SUM(CASE WHEN NAME = 'C#' THEN CODE ELSE 0 END) AS csharp_mask
    FROM SKILLCODES
)
SELECT 
    CASE 
        WHEN (d.SKILL_CODE & sc.front_end_mask) > 0 AND (d.SKILL_CODE & sc.python_mask) > 0 
            THEN 'A'
        WHEN (d.SKILL_CODE & sc.csharp_mask) > 0 
            THEN 'B'
        WHEN (d.SKILL_CODE & sc.front_end_mask) > 0 
            THEN 'C'
        ELSE NULL
    END AS GRADE,
    d.ID,
    d.EMAIL
FROM 
    DEVELOPERS d,
    skill_codes sc
WHERE 
    CASE 
        WHEN (d.SKILL_CODE & sc.front_end_mask) > 0 AND (d.SKILL_CODE & sc.python_mask) > 0 
            THEN 'A'
        WHEN (d.SKILL_CODE & sc.csharp_mask) > 0 
            THEN 'B'
        WHEN (d.SKILL_CODE & sc.front_end_mask) > 0 
            THEN 'C'
        ELSE NULL
    END IS NOT NULL
ORDER BY 
    GRADE ASC,
    ID ASC;