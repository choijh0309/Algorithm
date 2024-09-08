-- 코드를 작성해주세요
select count(id) fish_count
  from fish_info
 where year(time) = '2021';