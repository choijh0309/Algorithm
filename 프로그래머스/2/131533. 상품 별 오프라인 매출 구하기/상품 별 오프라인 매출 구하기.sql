-- 코드를 입력하세요
SELECT p.product_code, sum(price * sales_amount) sales
  from product p join offline_sale o on p.product_id = o.product_id
 group by o.product_id 
 order by sales desc, product_code; 