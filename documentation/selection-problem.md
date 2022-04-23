# N+1 selection problem

```
Hibernate: select jpacity0_.id as id1_0_, jpacity0_.active as active2_0_, jpacity0_.country_id as country_5_0_, jpacity0_.name as name3_0_, jpacity0_.zip_code as zip_code4_0_ from tbl_city jpacity0_ limit ?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
Hibernate: select jpacountry0_.id as id1_1_0_, jpacountry0_.active as active2_1_0_, jpacountry0_.alpha_2 as alpha_3_1_0_, jpacountry0_.alpha_3 as alpha_4_1_0_, jpacountry0_.name as name5_1_0_ from tbl_country jpacountry0_ where jpacountry0_.id=?
```