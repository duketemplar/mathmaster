-- CREATE OR REPLACE TYPE integer_array_type IS TABLE OF INTEGER;


-- Drop table mathmaster_users;
CREATE TABLE mathmaster_users (
  sid           INTEGER         NOT NULL,
  firstname       VARCHAR2(30)    NOT NULL,
  lastname        VARCHAR2(30)    NOT NULL,
  email           VARCHAR2(30)    NOT NULL,
  username        VARCHAR2(18)    NOT NULL,
  userpwd         VARCHAR2(20)    NOT NULL,
  cstno           INTEGER         NOT NULL,
  create_time     DATE            DEFAULT sysdate NOT NULL,
  tstamp          DATE            DEFAULT sysdate NOT NULL,
  dereg_date      DATE            DEFAULT NULL,
  country         VARCHAR2(3)     NOT NULL,
  status          INTEGER         NOT NULL,
  status_text     VARCHAR2(10)   DEFAULT NULL,
  user_ref        VARCHAR2(256)   DEFAULT NULL,
  CONSTRAINT pk_mahmaster PRIMARY KEY (sid)
);

CREATE INDEX ix_mathmaster_users_username ON mathmaster_users (username);

-- Drop sequence mathmaster_users_sid_seq;
CREATE SEQUENCE mathmaster_users_sid_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;



CREATE OR REPLACE TRIGGER mathmaster_users_ins
BEFORE INSERT ON mathmaster_users
FOR EACH ROW
DECLARE
seq_value int;
BEGIN
  select mathmaster_users_sid_seq.nextval into seq_value from dual;

  IF :NEW.sid IS NULL THEN
    :NEW.sid := seq_value;
  END IF;
END;

CREATE OR REPLACE TRIGGER mathmaster_users_upd
BEFORE UPDATE ON mathmaster_users
FOR EACH ROW
BEGIN
  :NEW.tstamp := sysdate;
END;