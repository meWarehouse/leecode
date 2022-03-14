https://www.nowcoder.com/ta/sql-factory-interview

留存
```sql
id  uid artical_id  in_time out_time    sign_cin


tb_user_log





SELECT
    t1.first_login_date,
    COUNT(t1.uid) c0,
    COUNT(t2.uid) c1,
    ROUND(COUNT(t1.uid) / COUNT(t1.uid),2) p
FROM 
(
    -- 每天新增用户 
    SELECT 
        uid,
        MIN(DATE_FORMAT(in_time,'%Y%m%d')) first_login_date
    FROM tb_user_log GROUP BY uid
)t1
LEFT JOIN 
(
    -- 每天登录用户
    SELECT uid,DATE_FORMAT(in_time,'%Y%m%d') login_date FROM tb_user_log GROUP BY uid,DATE_FORMAT(in_time,'%Y%m%d') 


    select
        uid,
        login_date
    from 
    (
    select
        uid,
        date_format(in_time,'%Y%m%d') login_date
    from tb_user_log
    union 
    select
        uid,
        date_format(out_time,'%Y%m%d') login_date
    from tb_user_log
    )a1 
    group by uid,login_date
    order by login_date

)t2
ON t1.uid=t2.uid AND t1.first_login_date=DATE_SUB(t2.login_date,INTERVAL 1 DAY)
GROUP BY t1.first_login_date



01
    101 102 103

02
    101 103 104

03 
    101 104 105

04 
    101


===========================================
        用户id，用户注册日期，用户登陆日期（活跃日期）


        drop table test_retention;
        create table test_retention(
        user_id string
        ,regist_time string
        ,active_time string
        )
        partitioned by ( dt string )
        ;


        08-01
        1 2 3 4 5

        08-02
        1 2 3 6 7 8 9 10

        08-03
        1 2 6 7

        08-04
        1 2 3 6 7 8 9


        select
        user_id
        regist_time
        from test_retention where
        group by user_id



        select
        '08-03',
        '一日留存',
        sum(if(regist_time='2021-08-03'),1,0) count_03_new,
        sum(if(regist_time='2021-08-03' and active_time='2021-08-04',1,0)) as count_03_new_l
        from test_retention


        select
        '08-01',
        '一日留存',
        sum(if(regist_time='2021-08-01',1,0)) count_03_new,
        sum(if(regist_time='2021-08-01' and active_time='2021-08-02',1,0)) as count_03_new_l
        from test_retention

        select
        '08-01',
        '两日留存',
        sum(if(regist_time='2021-08-01',1,0)) count_03_new,
        sum(if(regist_time='2021-08-01' and active_time='2021-08-03',1,0)) as count_03_new_l
        from test_retention


        select
        '08-01',
        '三日留存',
        sum(if(regist_time='2021-08-01',1,0)) count_03_new,
        sum(if(regist_time='2021-08-01' and active_time='2021-08-04',1,0)) as count_03_new_l
        from test_retention



```



### 连续问题


#### 问题1：找出连续 3 天及以上减少碳排放量在 100 以上的用户
如下数据为蚂蚁森林中用户领取的减少碳排放量
id dt lowcarbon
1001 2021-12-12 123
1002 2021-12-12 45
1001 2021-12-13 43
1001 2021-12-13 45
1001 2021-12-13 23
1002 2021-12-14 45
1001 2021-12-14 230
1002 2021-12-15 45
1001 2021-12-15 23

建表插入数据
```sql
create table if not exists test1(
   id int,
   dt string,
   lowcarbon int 
)


insert into table test1 values
    (1001,'2021-12-12','123')
    ,(1002, '2021-12-12', 45)
    ,(1001, '2021-12-13', 43)
    ,(1001, '2021-12-13', 45)
    ,(1001, '2021-12-13', 23)
    ,(1002, '2021-12-14', 45)
    ,(1001, '2021-12-14', 230)
    ,(1002, '2021-12-15', 45)
    ,(1001, '2021-12-15', 23);
```

1.每天碳排放大于100的用户
```sql
t1
select id,dt,sum(lowcarbon) from test1 group by id,dt having sum(lowcarbon)>100
```
+-------+-------------+------+
|  id   |     dt      | _c2  |
+-------+-------------+------+
| 1001  | 2021-12-13  | 111  |
| 1001  | 2021-12-14  | 230  |
| 1001  | 2021-12-12  | 123  |
+-------+-------------+------+

2.按用户分组，同时按dt排序，计算美团数据的rn
```sql
t2
select
    id,
    dt,
    row_number() over(partition by id order by dt) rn
from t1
```
+-------+-------------+-----+
|  id   |     dt      | rn  |
+-------+-------------+-----+
| 1001  | 2021-12-12  | 1   |
| 1001  | 2021-12-13  | 2   |
| 1001  | 2021-12-14  | 3   |
+-------+-------------+-----+

3.计算dt rn 等差数列
```sql
t3
select
    id,
    date_sub(dt,rn) diff
from t2
```
+-------+-------------+
|  id   |    diff     |
+-------+-------------+
| 1001  | 2021-12-11  |
| 1001  | 2021-12-11  |
| 1001  | 2021-12-11  |
+-------+-------------+

4.统计结果
```sql
select
    id
from t3
group by id,diff
having count(id) >=3 
```
+-------+
|  id   |
+-------+
| 1001  |
+-------+


### 分组问题
```sql
id ts(秒)
1001 17523641234
1001 17523641256
1002 17523641278
1001 17523641334
1002 17523641434
1001 17523641534
1001 17523641544
1002 17523641634
1001 17523641638
1001 17523641654


create table if not exists test2(id int,ts bigint)

insert into table test2 values
(1001,17523641234)
,(1001,17523641256)
,(1002,17523641278)
,(1001,17523641334)
,(1002,17523641434)
,(1001,17523641534)
,(1001,17523641544)
,(1002,17523641634)
,(1001,17523641638)
,(1001,17523641654)

某个用户连续的访问记录如果时间间隔小于 60 秒，则分为同一个组

select
    id,
    ts,
    lag(ts,1,ts) over(partition by id order by ts ) lagts
from test2



select
    id,
    ts,
    sum(if(tt>=60,1,0)) over(partition by id order by ts)
from
(
    select
        id,
        ts,
        ts - lagts as tt
    from
    (
        select
            id,
            ts,
            lag(ts,1,0) over(partition by id order by ts ) lagts
        from test2
    )t1
)t2

```






























