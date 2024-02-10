SELECT 
    r.FOOD_TYPE, 
    r.REST_ID, 
    r.REST_NAME, 
    r.FAVORITES 
FROM 
    REST_INFO r 
JOIN 
    (SELECT 
        FOOD_TYPE, 
        MAX(FAVORITES) as MaxFavorites 
     FROM 
        REST_INFO 
     GROUP BY 
        FOOD_TYPE) groupedr 
ON 
    r.FOOD_TYPE = groupedr.FOOD_TYPE AND 
    r.FAVORITES = groupedr.MaxFavorites 
ORDER BY 
    r.FOOD_TYPE DESC;