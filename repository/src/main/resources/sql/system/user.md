page
===
```sql
select 
    #{page('*')} 
from user 
where 1 = 1
-- @ if(!isBlank(status)) {
    and status = #{status}
-- @ }
-- @ if(!isBlank(name)) {
    and user.name like #{'%'+ name +'%'}
-- @ }
```