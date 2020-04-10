SET DATABASE SQL SYNTAX ORA TRUE;
DROP SCHEMA IF EXISTS TEST CASCADE;

CREATE SCHEMA TEST;

DROP SEQUENCE IF EXISTS SEQ_T_FACILITY;

DROP TABLE IF EXISTS T_FACILITY;

CREATE SEQUENCE SEQ_T_FACILITY START WITH 1 INCREMENT BY 1;

CREATE TABLE T_FACILITY
(
"ID" NUMBER(5, 0) NOT NULL,
"DESCRIPTION" VARCHAR2(200),
PRIMARY KEY("ID")
)
