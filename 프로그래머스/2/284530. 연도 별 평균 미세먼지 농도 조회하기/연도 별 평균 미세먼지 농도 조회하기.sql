-- 코드를 작성해주세요
select year(ym) year, round(avg(pm_val1), 2) pm10, round(avg(pm_val2), 2) 'pm2.5'
  from air_pollution
 group by year, location1, location2
having location2 = '수원' 
 order by 1;