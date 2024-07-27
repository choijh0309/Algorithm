-- 코드를 입력하세요
SELECT mcdp_cd 진료과코드, count(apnt_ymd) 5월예약건수
  from appointment
 where apnt_ymd like '2022-05-%'
 group by mcdp_cd
 order by count(apnt_ymd), mcdp_cd