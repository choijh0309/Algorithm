-- 코드를 입력하세요
select left(product_code, 2) category, count(product_id) products
  from product
 group by category; 