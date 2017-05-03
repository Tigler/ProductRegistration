--------------------------------------------------------
--  File created - среда-мая-03-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AKTVOZVRAT
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."AKTVOZVRAT" 
   (	"PK_AKTVOZVRAT" NUMBER, 
	"CURDATE" DATE, 
	"OFORMLEN" DATE, 
	"PK_POSTAV" NUMBER, 
	"NUM" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table COST
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."COST" 
   (	"PK_COST" VARCHAR2(30 BYTE), 
	"ZAKUPKA" NUMBER(10,2), 
	"NDS" NUMBER(10,2), 
	"NACENKA" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table COUNTS
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."COUNTS" 
   (	"PK_COUNTS" NUMBER, 
	"CURDATE" DATE, 
	"STARTCOUNT" VARCHAR2(20 BYTE), 
	"ENDCOUNT" VARCHAR2(20 BYTE), 
	"PK_TOVAR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table POSTAV
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."POSTAV" 
   (	"PK_POSTAV" NUMBER, 
	"FULLNAME" VARCHAR2(250 BYTE), 
	"SHORTNAME" VARCHAR2(100 BYTE), 
	"YURADDRESS" VARCHAR2(300 BYTE), 
	"FACTADDRESS" VARCHAR2(300 BYTE), 
	"TELEPHONE" VARCHAR2(40 BYTE), 
	"EMAIL" VARCHAR2(150 BYTE), 
	"INN" VARCHAR2(100 BYTE), 
	"SCHET" VARCHAR2(150 BYTE), 
	"MANAGER" VARCHAR2(200 BYTE), 
	"DIRECTOR" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SCHETFACT
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."SCHETFACT" 
   (	"PK_SCHETFACT" NUMBER, 
	"CURDATE" DATE, 
	"PROVEDENO" DATE, 
	"PK_POSTAV" NUMBER, 
	"NUM" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STRCHECK
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."STRCHECK" 
   (	"PK_STRCHECK" NUMBER, 
	"COUNT" NUMBER, 
	"PK_TOVARCHECK" NUMBER, 
	"PK_TOVAR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STRFACT
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."STRFACT" 
   (	"PK_STRFACT" NUMBER, 
	"COUNT" NUMBER, 
	"PK_SCHETFACT" NUMBER, 
	"PK_TOVAR" NUMBER, 
	"PK_COST" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STRVOZVRAT
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."STRVOZVRAT" 
   (	"PK_STRACT" NUMBER, 
	"COUNT" NUMBER, 
	"PK_ACTVOZVRAT" NUMBER, 
	"PK_COST" VARCHAR2(30 BYTE), 
	"PK_TOVAR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TOVAR
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."TOVAR" 
   (	"PK_TOVAR" NUMBER, 
	"NAMETOVAR" VARCHAR2(200 BYTE), 
	"EDIZMER" VARCHAR2(20 BYTE), 
	"PK_COST" VARCHAR2(30 BYTE), 
	"OSTATOK" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TOVARCHECK
--------------------------------------------------------

  CREATE TABLE "PRODUSER"."TOVARCHECK" 
   (	"PK_TOVARCHECK" NUMBER, 
	"CURDATE" DATE, 
	"OTPUSCHENO" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence AKTVOZVRAT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."AKTVOZVRAT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 31 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."COST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence POSTAV_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."POSTAV_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 15 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SCHETFACT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."SCHETFACT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 57 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence STRCHECK_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."STRCHECK_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 18 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence STRFACT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."STRFACT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 46 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence STRVOZVRAT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."STRVOZVRAT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 22 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TOVARCHECK_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."TOVARCHECK_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TOVAR_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUSER"."TOVAR_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 12 NOCACHE  NOORDER  NOCYCLE ;
REM INSERTING into PRODUSER.AKTVOZVRAT
SET DEFINE OFF;
Insert into PRODUSER.AKTVOZVRAT (PK_AKTVOZVRAT,CURDATE,OFORMLEN,PK_POSTAV,NUM) values ('28',null,null,'0',null);
Insert into PRODUSER.AKTVOZVRAT (PK_AKTVOZVRAT,CURDATE,OFORMLEN,PK_POSTAV,NUM) values ('29',null,null,'0',null);
Insert into PRODUSER.AKTVOZVRAT (PK_AKTVOZVRAT,CURDATE,OFORMLEN,PK_POSTAV,NUM) values ('30',null,null,'0',null);
Insert into PRODUSER.AKTVOZVRAT (PK_AKTVOZVRAT,CURDATE,OFORMLEN,PK_POSTAV,NUM) values ('22',to_date('02.04.17','DD.MM.RR'),to_date('22.04.17','DD.MM.RR'),'13','122');
Insert into PRODUSER.AKTVOZVRAT (PK_AKTVOZVRAT,CURDATE,OFORMLEN,PK_POSTAV,NUM) values ('27',null,null,'0',null);
REM INSERTING into PRODUSER.COST
SET DEFINE OFF;
Insert into PRODUSER.COST (PK_COST,ZAKUPKA,NDS,NACENKA) values ('1','30','18','50');
Insert into PRODUSER.COST (PK_COST,ZAKUPKA,NDS,NACENKA) values ('12','0','0','0');
Insert into PRODUSER.COST (PK_COST,ZAKUPKA,NDS,NACENKA) values ('11','42','20','37');
REM INSERTING into PRODUSER.COUNTS
SET DEFINE OFF;
REM INSERTING into PRODUSER.POSTAV
SET DEFINE OFF;
Insert into PRODUSER.POSTAV (PK_POSTAV,FULLNAME,SHORTNAME,YURADDRESS,FACTADDRESS,TELEPHONE,EMAIL,INN,SCHET,MANAGER,DIRECTOR) values ('13','ООО "Рога и копыта"','Рога и копыта','г.Барнаул ул.Ленина 1','г.Барнаул ул.Ленина 2','22-3-45','roga@mail.ru','223456789','580983311','Иванов Дмитрий Алексеевич','Петров Виктор Иванович');
REM INSERTING into PRODUSER.SCHETFACT
SET DEFINE OFF;
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('1',to_date('12.12.12','DD.MM.RR'),to_date('12.12.12','DD.MM.RR'),'13','1');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('14',to_date('08.04.17','DD.MM.RR'),to_date('08.04.17','DD.MM.RR'),'13','2');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('15',to_date('08.04.17','DD.MM.RR'),to_date('08.04.17','DD.MM.RR'),'13','3');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('53',null,null,'0',null);
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('13',null,null,'0','5');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('16',to_date('07.04.17','DD.MM.RR'),to_date('07.04.17','DD.MM.RR'),'13','6');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('54',to_date('22.04.17','DD.MM.RR'),to_date('23.04.17','DD.MM.RR'),'13','555');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('55',null,null,'0',null);
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('19',to_date('13.01.17','DD.MM.RR'),to_date('26.01.17','DD.MM.RR'),'13','9');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('20',null,null,'0','0');
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('52',null,null,'0',null);
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('56',null,null,'0',null);
Insert into PRODUSER.SCHETFACT (PK_SCHETFACT,CURDATE,PROVEDENO,PK_POSTAV,NUM) values ('31',to_date('06.04.17','DD.MM.RR'),to_date('07.04.17','DD.MM.RR'),'13','12');
REM INSERTING into PRODUSER.STRCHECK
SET DEFINE OFF;
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('1','2','1','1');
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('13','4','12','1');
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('14','1','12','10');
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('15','4','13','1');
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('16','11','13','10');
Insert into PRODUSER.STRCHECK (PK_STRCHECK,COUNT,PK_TOVARCHECK,PK_TOVAR) values ('17','1','20','10');
REM INSERTING into PRODUSER.STRFACT
SET DEFINE OFF;
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('1','9','1','1','1');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('22','3','13','10','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('23','2','14','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('24','4','14','10','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('20','1','0','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('21','3','13','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('25','1','15','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('26','1','16','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('36','1','-1','10','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('28','8','19','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('29','1','20','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('30','4','0','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('31','3','0','10','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('32','3','19','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('37','1','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('35','2','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('38','1','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('39','1','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('40','2','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('41','1','-1','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('42','2','31','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('43','2','54','1','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('44','6','14','10','0');
Insert into PRODUSER.STRFACT (PK_STRFACT,COUNT,PK_SCHETFACT,PK_TOVAR,PK_COST) values ('45','2','56','1','0');
REM INSERTING into PRODUSER.STRVOZVRAT
SET DEFINE OFF;
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('10','1','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('11','3','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('12','2','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('13','1','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('14','1','-1','0','10');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('15','1','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('16','1','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('17','2','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('18','2','-1','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('19','2','22','0','1');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('20','10','22','0','10');
Insert into PRODUSER.STRVOZVRAT (PK_STRACT,COUNT,PK_ACTVOZVRAT,PK_COST,PK_TOVAR) values ('21','2','30','0','1');
REM INSERTING into PRODUSER.TOVAR
SET DEFINE OFF;
Insert into PRODUSER.TOVAR (PK_TOVAR,NAMETOVAR,EDIZMER,PK_COST,OSTATOK) values ('1','Шоколад Милка','ШТ','1','50');
Insert into PRODUSER.TOVAR (PK_TOVAR,NAMETOVAR,EDIZMER,PK_COST,OSTATOK) values ('10','Апельсины','КГ','11','11');
REM INSERTING into PRODUSER.TOVARCHECK
SET DEFINE OFF;
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('1',to_date('06.04.17','DD.MM.RR'),to_date('07.04.17','DD.MM.RR'));
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('13',to_date('06.04.17','DD.MM.RR'),to_date('18.04.17','DD.MM.RR'));
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('19',to_date('01.01.17','DD.MM.RR'),null);
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('12',to_date('01.01.17','DD.MM.RR'),null);
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('20',to_date('01.01.17','DD.MM.RR'),null);
Insert into PRODUSER.TOVARCHECK (PK_TOVARCHECK,CURDATE,OTPUSCHENO) values ('18',to_date('01.01.17','DD.MM.RR'),null);
--------------------------------------------------------
--  DDL for Index COUNTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUSER"."COUNTS_PK" ON "PRODUSER"."COUNTS" ("PK_COUNTS") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger td_AKTVOZVRAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_AKTVOZVRAT" 
after delete on "AKTVOZVRAT" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "STRVOZVRAT" when parent "AKTVOZVRAT" deleted
	select count(*) into numrows
	from "STRVOZVRAT"
	where	"STRVOZVRAT"."PK_ACTVOZVRAT" = :old_del."PK_AKTVOZVRAT";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRVOZVRAT. Cannot delete from parent table AKTVOZVRAT.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_AKTVOZVRAT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger td_COST
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_COST" 
after delete on "COST" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "STRFACT" when parent "COST" deleted
	select count(*) into numrows
	from "STRFACT"
	where	"STRFACT"."PK_COST" = :old_del."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRFACT. Cannot delete from parent table COST.');
	end if;
-- Restrict child "STRVOZVRAT" when parent "COST" deleted
	select count(*) into numrows
	from "STRVOZVRAT"
	where	"STRVOZVRAT"."PK_COST" = :old_del."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRVOZVRAT. Cannot delete from parent table COST.');
	end if;
-- Restrict child "TOVAR" when parent "COST" deleted
	select count(*) into numrows
	from "TOVAR"
	where	"TOVAR"."PK_COST" = :old_del."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table TOVAR. Cannot delete from parent table COST.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_COST" ENABLE;
--------------------------------------------------------
--  DDL for Trigger td_POSTAV
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_POSTAV" 
after delete on "POSTAV" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "SCHETFACT" when parent "POSTAV" deleted
	select count(*) into numrows
	from "SCHETFACT"
	where	"SCHETFACT"."PK_POSTAV" = :old_del."PK_POSTAV";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table SCHETFACT. Cannot delete from parent table POSTAV.');
	end if;
-- Restrict child "AKTVOZVRAT" when parent "POSTAV" deleted
	select count(*) into numrows
	from "AKTVOZVRAT"
	where	"AKTVOZVRAT"."PK_POSTAV" = :old_del."PK_POSTAV";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table AKTVOZVRAT. Cannot delete from parent table POSTAV.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_POSTAV" ENABLE;
--------------------------------------------------------
--  DDL for Trigger td_SCHETFACT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_SCHETFACT" 
after delete on "SCHETFACT" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "STRFACT" when parent "SCHETFACT" deleted
	select count(*) into numrows
	from "STRFACT"
	where	"STRFACT"."PK_SCHETFACT" = :old_del."PK_SCHETFACT";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRFACT. Cannot delete from parent table SCHETFACT.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_SCHETFACT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger td_TOVAR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_TOVAR" 
after delete on "TOVAR" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "STRCHECK" when parent "TOVAR" deleted
	select count(*) into numrows
	from "STRCHECK"
	where	"STRCHECK"."PK_TOVAR" = :old_del."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRCHECK. Cannot delete from parent table TOVAR.');
	end if;
-- Restrict child "STRFACT" when parent "TOVAR" deleted
	select count(*) into numrows
	from "STRFACT"
	where	"STRFACT"."PK_TOVAR" = :old_del."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRFACT. Cannot delete from parent table TOVAR.');
	end if;
-- Restrict child "STRVOZVRAT" when parent "TOVAR" deleted
	select count(*) into numrows
	from "STRVOZVRAT"
	where	"STRVOZVRAT"."PK_TOVAR" = :old_del."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRVOZVRAT. Cannot delete from parent table TOVAR.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_TOVAR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger td_TOVARCHECK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."td_TOVARCHECK" 
after delete on "TOVARCHECK" 
referencing old as old_del
for each row
declare numrows integer;
begin
-- Restrict child "STRCHECK" when parent "TOVARCHECK" deleted
	select count(*) into numrows
	from "STRCHECK"
	where	"STRCHECK"."PK_TOVARCHECK" = :old_del."PK_TOVARCHECK";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20003,'Children still exist in child table STRCHECK. Cannot delete from parent table TOVARCHECK.');
	end if;
 
end;
/
ALTER TRIGGER "PRODUSER"."td_TOVARCHECK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_AKTVOZVRAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_AKTVOZVRAT" 
   before insert on "PRODUSER"."AKTVOZVRAT" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_AKTVOZVRAT" is null then 
         select AKTVOZVRAT_SEQ.nextval into :NEW."PK_AKTVOZVRAT" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_AKTVOZVRAT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_COST
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_COST" 
   before insert on "PRODUSER"."COST" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_COST" is null then 
         select COST_SEQ.nextval into :NEW."PK_COST" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_COST" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_POSTAV
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_POSTAV" 
   before insert on "PRODUSER"."POSTAV" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_POSTAV" is null then 
         select POSTAV_SEQ.nextval into :NEW."PK_POSTAV" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_POSTAV" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_SCHETFACT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_SCHETFACT" 
   before insert on "PRODUSER"."SCHETFACT" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_SCHETFACT" is null then 
         select SCHETFACT_SEQ.nextval into :NEW."PK_SCHETFACT" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_SCHETFACT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_STRCHECK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_STRCHECK" 
   before insert on "PRODUSER"."STRCHECK" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_STRCHECK" is null then 
         select STRCHECK_SEQ.nextval into :NEW."PK_STRCHECK" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_STRCHECK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_STRFACT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_STRFACT" 
   before insert on "PRODUSER"."STRFACT" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_STRFACT" is null then 
         select STRFACT_SEQ.nextval into :NEW."PK_STRFACT" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_STRFACT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_STRVOZVRAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_STRVOZVRAT" 
   before insert on "PRODUSER"."STRVOZVRAT" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_STRACT" is null then 
         select STRVOZVRAT_SEQ.nextval into :NEW."PK_STRACT" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_STRVOZVRAT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_TOVAR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_TOVAR" 
   before insert on "PRODUSER"."TOVAR" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_TOVAR" is null then 
         select TOVAR_SEQ.nextval into :NEW."PK_TOVAR" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_TOVAR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TI_TOVARCHECK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."TI_TOVARCHECK" 
   before insert on "PRODUSER"."TOVARCHECK" 
   for each row 
begin  
   if inserting then 
      if :NEW."PK_TOVARCHECK" is null then 
         select TOVARCHECK_SEQ.nextval into :NEW."PK_TOVARCHECK" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "PRODUSER"."TI_TOVARCHECK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_AKTVOZVRAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_AKTVOZVRAT" 
after update of "PK_AKTVOZVRAT","PK_POSTAV" on "AKTVOZVRAT" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "STRVOZVRAT" when parent "AKTVOZVRAT" changed
if (:old_upd."PK_AKTVOZVRAT" != :new_upd."PK_AKTVOZVRAT")  then
	begin
	select count(*) 
	into numrows
	from "STRVOZVRAT"
	where "STRVOZVRAT"."PK_ACTVOZVRAT" = :old_upd."PK_AKTVOZVRAT";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRVOZVRAT. Cannot update parent table AKTVOZVRAT.');
	end if;
	end;
end if;
 
-- Restrict parent "POSTAV" when child "AKTVOZVRAT" updated
if :new_upd."PK_POSTAV" != :old_upd."PK_POSTAV" then
	begin
	select count(*) into numrows
	from "POSTAV"
	where	:new_upd."PK_POSTAV" = "POSTAV"."PK_POSTAV";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table POSTAV. Cannot update child table AKTVOZVRAT.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_AKTVOZVRAT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_COST
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_COST" 
after update of "PK_COST" on "COST" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "STRFACT" when parent "COST" changed
if (:old_upd."PK_COST" != :new_upd."PK_COST")  then
	begin
	select count(*) 
	into numrows
	from "STRFACT"
	where "STRFACT"."PK_COST" = :old_upd."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRFACT. Cannot update parent table COST.');
	end if;
	end;
end if;
-- Restrict child "STRVOZVRAT" when parent "COST" changed
if (:old_upd."PK_COST" != :new_upd."PK_COST")  then
	begin
	select count(*) 
	into numrows
	from "STRVOZVRAT"
	where "STRVOZVRAT"."PK_COST" = :old_upd."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRVOZVRAT. Cannot update parent table COST.');
	end if;
	end;
end if;
-- Restrict child "TOVAR" when parent "COST" changed
if (:old_upd."PK_COST" != :new_upd."PK_COST")  then
	begin
	select count(*) 
	into numrows
	from "TOVAR"
	where "TOVAR"."PK_COST" = :old_upd."PK_COST";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table TOVAR. Cannot update parent table COST.');
	end if;
	end;
end if;
 

end;
/
ALTER TRIGGER "PRODUSER"."tu_COST" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_POSTAV
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_POSTAV" 
after update of "PK_POSTAV" on "POSTAV" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "SCHETFACT" when parent "POSTAV" changed
if (:old_upd."PK_POSTAV" != :new_upd."PK_POSTAV")  then
	begin
	select count(*) 
	into numrows
	from "SCHETFACT"
	where "SCHETFACT"."PK_POSTAV" = :old_upd."PK_POSTAV";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table SCHETFACT. Cannot update parent table POSTAV.');
	end if;
	end;
end if;
-- Restrict child "AKTVOZVRAT" when parent "POSTAV" changed
if (:old_upd."PK_POSTAV" != :new_upd."PK_POSTAV")  then
	begin
	select count(*) 
	into numrows
	from "AKTVOZVRAT"
	where "AKTVOZVRAT"."PK_POSTAV" = :old_upd."PK_POSTAV";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table AKTVOZVRAT. Cannot update parent table POSTAV.');
	end if;
	end;
end if;
 

end;
/
ALTER TRIGGER "PRODUSER"."tu_POSTAV" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_SCHETFACT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_SCHETFACT" 
after update of "PK_SCHETFACT","PK_POSTAV" on "SCHETFACT" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "STRFACT" when parent "SCHETFACT" changed
if (:old_upd."PK_SCHETFACT" != :new_upd."PK_SCHETFACT")  then
	begin
	select count(*) 
	into numrows
	from "STRFACT"
	where "STRFACT"."PK_SCHETFACT" = :old_upd."PK_SCHETFACT";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRFACT. Cannot update parent table SCHETFACT.');
	end if;
	end;
end if;
 
-- Restrict parent "POSTAV" when child "SCHETFACT" updated
if :new_upd."PK_POSTAV" != :old_upd."PK_POSTAV" then
	begin
	select count(*) into numrows
	from "POSTAV"
	where	:new_upd."PK_POSTAV" = "POSTAV"."PK_POSTAV";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table POSTAV. Cannot update child table SCHETFACT.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_SCHETFACT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_STRCHECK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_STRCHECK" 
after update of "PK_STRCHECK","PK_TOVARCHECK","PK_TOVAR" on "STRCHECK" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
 
-- Restrict parent "TOVARCHECK" when child "STRCHECK" updated
if :new_upd."PK_TOVARCHECK" != :old_upd."PK_TOVARCHECK" then
	begin
	select count(*) into numrows
	from "TOVARCHECK"
	where	:new_upd."PK_TOVARCHECK" = "TOVARCHECK"."PK_TOVARCHECK";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table TOVARCHECK. Cannot update child table STRCHECK.');
	end if;
	end;
end if;
-- Restrict parent "TOVAR" when child "STRCHECK" updated
if :new_upd."PK_TOVAR" != :old_upd."PK_TOVAR" then
	begin
	select count(*) into numrows
	from "TOVAR"
	where	:new_upd."PK_TOVAR" = "TOVAR"."PK_TOVAR";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table TOVAR. Cannot update child table STRCHECK.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_STRCHECK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_STRFACT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_STRFACT" 
after update of "PK_STRFACT","PK_SCHETFACT","PK_TOVAR","PK_COST" on "STRFACT" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
 
-- Restrict parent "SCHETFACT" when child "STRFACT" updated
if :new_upd."PK_SCHETFACT" != :old_upd."PK_SCHETFACT" then
	begin
	select count(*) into numrows
	from "SCHETFACT"
	where	:new_upd."PK_SCHETFACT" = "SCHETFACT"."PK_SCHETFACT";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table SCHETFACT. Cannot update child table STRFACT.');
	end if;
	end;
end if;
-- Restrict parent "TOVAR" when child "STRFACT" updated
if :new_upd."PK_TOVAR" != :old_upd."PK_TOVAR" then
	begin
	select count(*) into numrows
	from "TOVAR"
	where	:new_upd."PK_TOVAR" = "TOVAR"."PK_TOVAR";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table TOVAR. Cannot update child table STRFACT.');
	end if;
	end;
end if;
-- Restrict parent "COST" when child "STRFACT" updated
if :new_upd."PK_COST" != :old_upd."PK_COST" then
	begin
	select count(*) into numrows
	from "COST"
	where	:new_upd."PK_COST" = "COST"."PK_COST";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table COST. Cannot update child table STRFACT.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_STRFACT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_STRVOZVRAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_STRVOZVRAT" 
after update of "PK_ACTVOZVRAT","PK_COST","PK_TOVAR" on "STRVOZVRAT" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
 
-- Restrict parent "AKTVOZVRAT" when child "STRVOZVRAT" updated
if :new_upd."PK_ACTVOZVRAT" != :old_upd."PK_ACTVOZVRAT" then
	begin
	select count(*) into numrows
	from "AKTVOZVRAT"
	where	:new_upd."PK_ACTVOZVRAT" = "AKTVOZVRAT"."PK_AKTVOZVRAT";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table AKTVOZVRAT. Cannot update child table STRVOZVRAT.');
	end if;
	end;
end if;
-- Restrict parent "COST" when child "STRVOZVRAT" updated
if :new_upd."PK_COST" != :old_upd."PK_COST" then
	begin
	select count(*) into numrows
	from "COST"
	where	:new_upd."PK_COST" = "COST"."PK_COST";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table COST. Cannot update child table STRVOZVRAT.');
	end if;
	end;
end if;
-- Restrict parent "TOVAR" when child "STRVOZVRAT" updated
if :new_upd."PK_TOVAR" != :old_upd."PK_TOVAR" then
	begin
	select count(*) into numrows
	from "TOVAR"
	where	:new_upd."PK_TOVAR" = "TOVAR"."PK_TOVAR";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table TOVAR. Cannot update child table STRVOZVRAT.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_STRVOZVRAT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_TOVAR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_TOVAR" 
after update of "PK_TOVAR","PK_COST" on "TOVAR" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "STRCHECK" when parent "TOVAR" changed
if (:old_upd."PK_TOVAR" != :new_upd."PK_TOVAR")  then
	begin
	select count(*) 
	into numrows
	from "STRCHECK"
	where "STRCHECK"."PK_TOVAR" = :old_upd."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRCHECK. Cannot update parent table TOVAR.');
	end if;
	end;
end if;
-- Restrict child "STRFACT" when parent "TOVAR" changed
if (:old_upd."PK_TOVAR" != :new_upd."PK_TOVAR")  then
	begin
	select count(*) 
	into numrows
	from "STRFACT"
	where "STRFACT"."PK_TOVAR" = :old_upd."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRFACT. Cannot update parent table TOVAR.');
	end if;
	end;
end if;
-- Restrict child "STRVOZVRAT" when parent "TOVAR" changed
if (:old_upd."PK_TOVAR" != :new_upd."PK_TOVAR")  then
	begin
	select count(*) 
	into numrows
	from "STRVOZVRAT"
	where "STRVOZVRAT"."PK_TOVAR" = :old_upd."PK_TOVAR";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRVOZVRAT. Cannot update parent table TOVAR.');
	end if;
	end;
end if;
 
-- Restrict parent "COST" when child "TOVAR" updated
if :new_upd."PK_COST" != :old_upd."PK_COST" then
	begin
	select count(*) into numrows
	from "COST"
	where	:new_upd."PK_COST" = "COST"."PK_COST";
	if (numrows = 0) then
		RAISE_APPLICATION_ERROR(-20002,'Parent does not exist in parent table COST. Cannot update child table TOVAR.');
	end if;
	end;
end if;

end;
/
ALTER TRIGGER "PRODUSER"."tu_TOVAR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger tu_TOVARCHECK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUSER"."tu_TOVARCHECK" 
after update of "PK_TOVARCHECK" on "TOVARCHECK" 
referencing new as new_upd old as old_upd
for each row
declare numrows integer;
begin
-- Restrict child "STRCHECK" when parent "TOVARCHECK" changed
if (:old_upd."PK_TOVARCHECK" != :new_upd."PK_TOVARCHECK")  then
	begin
	select count(*) 
	into numrows
	from "STRCHECK"
	where "STRCHECK"."PK_TOVARCHECK" = :old_upd."PK_TOVARCHECK";
	if (numrows > 0) then
		RAISE_APPLICATION_ERROR(-20001,'Children still exist in child table STRCHECK. Cannot update parent table TOVARCHECK.');
	end if;
	end;
end if;
 

end;
/
ALTER TRIGGER "PRODUSER"."tu_TOVARCHECK" ENABLE;
--------------------------------------------------------
--  Constraints for Table TOVARCHECK
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."TOVARCHECK" ADD PRIMARY KEY ("PK_TOVARCHECK")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."TOVARCHECK" MODIFY ("PK_TOVARCHECK" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COUNTS
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."COUNTS" ADD CONSTRAINT "COUNTS_PK" PRIMARY KEY ("PK_COUNTS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."COUNTS" MODIFY ("PK_TOVAR" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."COUNTS" MODIFY ("PK_COUNTS" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table POSTAV
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."POSTAV" ADD PRIMARY KEY ("PK_POSTAV")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."POSTAV" MODIFY ("PK_POSTAV" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AKTVOZVRAT
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."AKTVOZVRAT" ADD PRIMARY KEY ("PK_AKTVOZVRAT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."AKTVOZVRAT" MODIFY ("PK_POSTAV" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."AKTVOZVRAT" MODIFY ("PK_AKTVOZVRAT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TOVAR
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."TOVAR" ADD PRIMARY KEY ("PK_TOVAR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."TOVAR" MODIFY ("PK_COST" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."TOVAR" MODIFY ("PK_TOVAR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STRVOZVRAT
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."STRVOZVRAT" MODIFY ("PK_TOVAR" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRVOZVRAT" MODIFY ("PK_COST" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRVOZVRAT" MODIFY ("PK_ACTVOZVRAT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SCHETFACT
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."SCHETFACT" ADD PRIMARY KEY ("PK_SCHETFACT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."SCHETFACT" MODIFY ("PK_POSTAV" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."SCHETFACT" MODIFY ("PK_SCHETFACT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STRFACT
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."STRFACT" ADD PRIMARY KEY ("PK_STRFACT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."STRFACT" MODIFY ("PK_COST" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRFACT" MODIFY ("PK_TOVAR" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRFACT" MODIFY ("PK_SCHETFACT" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRFACT" MODIFY ("PK_STRFACT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STRCHECK
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."STRCHECK" ADD PRIMARY KEY ("PK_STRCHECK")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."STRCHECK" MODIFY ("PK_TOVAR" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRCHECK" MODIFY ("PK_TOVARCHECK" NOT NULL ENABLE);
  ALTER TABLE "PRODUSER"."STRCHECK" MODIFY ("PK_STRCHECK" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COST
--------------------------------------------------------

  ALTER TABLE "PRODUSER"."COST" ADD PRIMARY KEY ("PK_COST")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PRODUSER"."COST" MODIFY ("PK_COST" NOT NULL ENABLE);
