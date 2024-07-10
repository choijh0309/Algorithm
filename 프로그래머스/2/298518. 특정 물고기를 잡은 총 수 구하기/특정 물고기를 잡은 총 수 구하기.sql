-- 코드를 작성해주세요
select count(n.fish_name) as fish_count
  from fish_info as i
  join fish_name_info as n
    on i.fish_type = n.fish_type
 where n.fish_name in ('bass', 'snapper');   