-- 코드를 입력하세요
SELECT 
    h.HISTORY_ID,
    ROUND(
        CASE
            WHEN DATEDIFF(h.END_DATE, h.START_DATE) + 1 >= 90 THEN c.DAILY_FEE * (1 - d3.DISCOUNT_RATE / 100) * (DATEDIFF(h.END_DATE, h.START_DATE) + 1)
            WHEN DATEDIFF(h.END_DATE, h.START_DATE) + 1 >= 30 THEN c.DAILY_FEE * (1 - d2.DISCOUNT_RATE / 100) * (DATEDIFF(h.END_DATE, h.START_DATE) + 1)
            WHEN DATEDIFF(h.END_DATE, h.START_DATE) + 1 >= 7 THEN c.DAILY_FEE * (1 - d1.DISCOUNT_RATE / 100) * (DATEDIFF(h.END_DATE, h.START_DATE) + 1)
            ELSE c.DAILY_FEE * (DATEDIFF(h.END_DATE, h.START_DATE) + 1)
        END, 0
    ) AS FEE
FROM 
    CAR_RENTAL_COMPANY_CAR c
JOIN 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.CAR_ID = h.CAR_ID
LEFT JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN d1 ON c.CAR_TYPE = d1.CAR_TYPE AND d1.DURATION_TYPE = '7일 이상'
LEFT JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN d2 ON c.CAR_TYPE = d2.CAR_TYPE AND d2.DURATION_TYPE = '30일 이상'
LEFT JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN d3 ON c.CAR_TYPE = d3.CAR_TYPE AND d3.DURATION_TYPE = '90일 이상'
WHERE 
    c.CAR_TYPE = '트럭'
ORDER BY 
    FEE DESC,
    h.HISTORY_ID DESC;
