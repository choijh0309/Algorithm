-- 코드를 입력하세요
select a.car_id, a.car_type, round(a.daily_fee * 30 * (100 - p.discount_rate) / 100) fee
  from car_rental_company_car a 
  join (select *
                                        from car_rental_company_discount_plan
                                       where duration_type = '30일 이상') p
    on a.car_type = p.car_type     
 where a.car_type in ('세단', 'SUV')
   and a.car_id not in (select car_id
                          from car_rental_company_rental_history
                         where END_DATE>='2022-11-01'
                           and START_DATE<'2022-12-01'
                       )
 group by a.car_id 
having fee >= 500000 and fee < 2000000
 order by fee desc, a.car_type, a.car_id desc;  
 

     
   