SELECT ROUND(AVG(daily_fee)) AS averge_fee
FROM car_rental_company_car
GROUP BY car_type
HAVING car_type = 'SUV';