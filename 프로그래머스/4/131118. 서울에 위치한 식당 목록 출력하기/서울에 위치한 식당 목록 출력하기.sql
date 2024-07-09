-- 코드를 입력하세요
SELECT r.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score), 2) as score
  from rest_review as r
  left join rest_info as i
    on r.rest_id = i.rest_id
 group by r.rest_id
having i.address like '서울%'
 order by score desc, i.favorites desc;
    