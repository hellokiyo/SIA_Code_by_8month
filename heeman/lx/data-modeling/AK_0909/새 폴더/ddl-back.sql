#drop SCHEMA  if exists bank;

CREATE SCHEMA if exists bank;

use bank;

CREATE TABLE 거래내역 
    ( 
     일련번호    varchar (50)  NOT NULL , 
     거래일자    DATE , 
     거래시각    DATE , 
     거래금액    INT , 
     계좌_계좌번호 varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE 거래내역 
    ADD CONSTRAINT 거래내역_PK PRIMARY KEY ( 일련번호 ) ;

CREATE TABLE 계좌 
    ( 
     계좌번호    varchar (50)  NOT NULL , 
     잔고      INT , 
     계좌구분    CHAR (1) , 
     원금      INT , 
     이자      INT , 
     지점_고유번호 varchar (50)  NOT NULL , 
     직원_직원번호 varchar (50)  NOT NULL , 
     고객_고유번호 varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE 계좌 
    ADD CONSTRAINT 계좌_PK PRIMARY KEY ( 계좌번호 ) ;

CREATE TABLE 고객 
    ( 
     고유번호    varchar (50)  NOT NULL , 
     고객명     varchar (30) , 
     주민번호    varchar (20) , 
     주소      varchar (50) , 
     지점_고유번호 varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE 고객 
    ADD CONSTRAINT 고객_PK PRIMARY KEY ( 고유번호 ) ;

CREATE TABLE 지점 
    ( 
     고유번호    varchar (50)  NOT NULL , 
     지점명     varchar (30) , 
     주소      varchar (50) , 
     전화번호    varchar (20) , 
     직원_직원번호 varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE 지점 
    ADD CONSTRAINT 지점_PK PRIMARY KEY ( 고유번호 ) ;

CREATE TABLE 직원 
    ( 
     직원번호    varchar (50)  NOT NULL , 
     직원명     varchar (30) , 
     주소      varchar (50) , 
     전화번호    varchar (20) , 
     지점_고유번호 varchar (50)  NOT NULL 
    ) 
;

ALTER TABLE 직원 
    ADD CONSTRAINT 직원_PK PRIMARY KEY ( 직원번호 ) ;

ALTER TABLE 거래내역 
    ADD CONSTRAINT 거래내역_계좌_FK FOREIGN KEY 
    ( 
     계좌_계좌번호
    ) 
    REFERENCES 계좌 
    ( 
     계좌번호
    ) 
;

ALTER TABLE 계좌 
    ADD CONSTRAINT 계좌_고객_FK FOREIGN KEY 
    ( 
     고객_고유번호
    ) 
    REFERENCES 고객 
    ( 
     고유번호
    ) 
;

ALTER TABLE 계좌 
    ADD CONSTRAINT 계좌_지점_FK FOREIGN KEY 
    ( 
     지점_고유번호
    ) 
    REFERENCES 지점 
    ( 
     고유번호
    ) 
;

ALTER TABLE 계좌 
    ADD CONSTRAINT 계좌_직원_FK FOREIGN KEY 
    ( 
     직원_직원번호
    ) 
    REFERENCES 직원 
    ( 
     직원번호
    ) 
;

ALTER TABLE 고객 
    ADD CONSTRAINT 고객_지점_FK FOREIGN KEY 
    ( 
     지점_고유번호
    ) 
    REFERENCES 지점 
    ( 
     고유번호
    ) 
;

ALTER TABLE 지점 
    ADD CONSTRAINT 지점_직원_FK FOREIGN KEY 
    ( 
     직원_직원번호
    ) 
    REFERENCES 직원 
    ( 
     직원번호
    ) 
;

ALTER TABLE 직원 
    ADD CONSTRAINT 직원_지점_FK FOREIGN KEY 
    ( 
     지점_고유번호
    ) 
    REFERENCES 지점 
    ( 
     고유번호
    ) 
;



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
