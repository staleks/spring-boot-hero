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

```
Hibernate: select jpapost0_.id as id1_2_0_, comments1_.id as id1_3_1_, jpapost0_.body as body2_2_0_, jpapost0_.title as title3_2_0_, jpapost0_.user_id as user_id4_2_0_, comments1_.body as body2_3_1_, comments1_.email as email3_3_1_, comments1_.name as name4_3_1_, comments1_.post_id as post_id5_3_1_, comments1_.post_id as post_id5_3_0__, comments1_.id as id1_3_0__ from tbl_post jpapost0_ left outer join tbl_post_comment comments1_ on jpapost0_.id=comments1_.post_id
```