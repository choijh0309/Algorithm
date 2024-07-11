-- 코드를 입력하세요
SELECT name, datetime
  from animal_ins i
 where not exists (select animal_id from animal_outs o where i.animal_id = o.animal_id)
 order by datetime
 limit 3;