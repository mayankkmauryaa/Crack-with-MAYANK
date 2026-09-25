-- # Write your MySQL query statement below
select
D.name as Department,
E.name as Employee,
E.salary as Salary 
from Employee E 
join Department D 
on E.departmentId = D.id 
where (
    select 
    count(distinct salary) 
    from Employee e2 
    where e2.departmentId = D.id and e2.salary >= E.salary
) <=3 
order by Department, Salary desc;