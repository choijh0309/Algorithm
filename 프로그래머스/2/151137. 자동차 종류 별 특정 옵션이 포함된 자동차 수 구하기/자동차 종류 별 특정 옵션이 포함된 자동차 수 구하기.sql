-- 코드를 입력하세요
SELECT car_type, COUNT(car_type) AS cars
FROM car_rental_company_car
WHERE options like '%열선시트%' or options like '%통풍시트%' or options like '%가죽시트%'
GROUP BY car_type
ORDER BY car_type; 