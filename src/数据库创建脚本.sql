-- 删除数据表
DROP TABLE member PURGE ;
-- 创建数据表
CREATE TABLE member (
	mid 		VARCHAR2(50) ,
	name		VARCHAR2(50) ,
	age			NUMBER(3) ,
	phone		VARCHAR2(20) ,
	birthday	DATE ,
	note		CLOB ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) ;