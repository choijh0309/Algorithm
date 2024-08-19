-- 코드를 작성해주세요
WITH MonthlyFishInfo AS (
    SELECT
        ID,
        MONTH(TIME) AS MONTH
    FROM
        FISH_INFO
)
SELECT
    COUNT(ID) AS FISH_COUNT,
    MONTH
FROM
    MonthlyFishInfo
GROUP BY
    MONTH
ORDER BY
    MONTH;