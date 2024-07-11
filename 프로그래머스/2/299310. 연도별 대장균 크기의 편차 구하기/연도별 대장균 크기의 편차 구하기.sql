-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) year, max(SIZE_OF_COLONY) over(partition by year(DIFFERENTIATION_DATE)) - size_of_colony year_dev, id
  from ecoli_data e
 order by year, year_dev;