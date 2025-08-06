SELECT 
    --Substract the Rank column from the subconsult
    sub.Department, sub.Employee, sub.Salary
    FROM (
        --Generate a Subconsult ranking the employees by salary and partitioning them by department
        SELECT 
            d.name as Department,
            e.name as Employee,   
            e.salary as Salary,
            --DENSE_RANK allows for multiple tuples in a single rank, without
            --skipping secuential ranking number
            --RANK() => 1, 2, 2, 4
            --DENSE_RANK() => 1, 2, 2, 3 <= This is the behaviour we need
            DENSE_RANK() OVER(PARTITION BY d.id ORDER BY e.salary DESC) as Rank
            FROM Employee e
                JOIN Department d
                    ON e.departmentId = d.id
    ) as sub
    --Get the all the top 3 higher earners from all the departments
    WHERE sub.Rank <= 3

