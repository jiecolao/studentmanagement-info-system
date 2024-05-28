# 📌 FOR YOUR GUIDE


# 🔷 ADMIN DATABASE

> [!WARNING]
> ADMIN DATABASE TO HA. 

* *`user` TABLE*

| **admin_id** | **admin_pass** |
| --- | --- |
| 001 | 123qwe |
| *null* | *null* |

* *`info` TABLE* (unfinished)

| **admin_id** | **admin_name** | **admin_email** | **admin_contact** | **admin_birth** | 
| --- | --- | --- | --- | --- |
| 202212345 | Jograt | myemail@gmail.com | 09151234567 | CISTM |
| *null* | *null* | *null* | *null* | *null* |

* *`subject` TABLE* (unfinished)

| **admin_id** | **subj_code** | **subj_title** |
| --- | --- | --- |
| 001 | ICC 103 | Intermediate Programming (Lec) |
| *null* | *null* | *null* |

# 🔷 STUDENT DATABASE

> [!WARNING]
> STUDENT DATABASE TO HA.

* *`users` TABLE*

| **stud_id** | **stud_pass** |
| --- | --- |
| 202212345 | 123qwe |
| *null* | *null* |

* *`info` TABLE*

| **stud_id** | **stud_name** | **stud_email** | **stud_contact** | **stud_col** | **stud_crs** | **stud_type** | **stud_status** | **stud_yrlvl** |  
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 202212345 | user | user2022@plm.edu.ph | 09151234567 | CISTM | CS | Old | regular | 1 |
| *null* | *null* | *null* | *null* | *null* | *null* | *null* | *null* | *null* |

* *`attendance` TABLE*

| **stud_id** | **subj_code** | **subj_datetime** | **stud_attd** | 
| --- | --- | --- | --- |
| 202212345 | ICC 0103 | *pending* | PRESENT/ABSENT/EXCUSED |
| *null* | *null* | *null* | *null* |

* *`grades` TABLE*

| **stud_id** | **acad_yr** | **acad_sem** | **subj_code** | **subj_title** | **subj_gwa** |
| --- | --- | --- | --- | --- | --- |
| 202212345 | 1 | 1 | ICC 0103 | Intermediate Programming (Lec) | 1.00 |
| *null* | *null* | *null* | *null* | *null* | *null* |
