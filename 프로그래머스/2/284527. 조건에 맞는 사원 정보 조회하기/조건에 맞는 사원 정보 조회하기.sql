WITH yearly_scores AS (
    SELECT 
        EMP_NO,
        SUM(SCORE) AS SCORE
    FROM HR_GRADE
    WHERE YEAR = 2022
    GROUP BY EMP_NO
),
max_score AS (
    SELECT MAX(SCORE) AS max_score
    FROM yearly_scores
)
SELECT 
    ys.SCORE,
    e.EMP_NO,
    e.EMP_NAME,
    e.POSITION,
    e.EMAIL
FROM yearly_scores ys
JOIN HR_EMPLOYEES e ON ys.EMP_NO = e.EMP_NO
JOIN max_score ms ON ys.SCORE = ms.max_score
ORDER BY e.EMP_NO;