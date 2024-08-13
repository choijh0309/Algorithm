-- 코드를 입력하세요
WITH RECURSIVE hours(hour) AS (
    SELECT 0
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 23
)
SELECT 
    hours.hour AS HOUR,
    COALESCE(COUNT(ANIMAL_OUTS.ANIMAL_ID), 0) AS COUNT
FROM 
    hours
LEFT JOIN 
    ANIMAL_OUTS ON hours.hour = HOUR(ANIMAL_OUTS.DATETIME)
GROUP BY 
    hours.hour
ORDER BY 
    hours.hour;