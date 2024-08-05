SELECT 
    a.AUTHOR_ID, 
    a.AUTHOR_NAME, 
    b.CATEGORY, 
    SUM(bs.SALES * b.PRICE) AS TOTAL_SALES
FROM 
    BOOK_SALES bs
JOIN 
    BOOK b ON bs.BOOK_ID = b.BOOK_ID
JOIN 
    AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE 
    bs.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY 
    a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
ORDER BY 
    a.AUTHOR_ID ASC, 
    b.CATEGORY DESC;