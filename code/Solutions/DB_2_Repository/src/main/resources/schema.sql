DROP TABLE TRACK IF EXISTS;

CREATE USER IF NOT EXISTS TRACKER SALT 'f2d97d5e5c194fe4' HASH 'bf9ac7082b79123183a1a58f3f23b3822cbedc5c1161394f43bd4d0d03237c59' ADMIN;
-- CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_1E1E9410_2EB3_4490_B509_D78C2389694F START WITH 1 BELONGS_TO_TABLE;
CREATE MEMORY TABLE PUBLIC.TRACK(
    --ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_1E1E9410_2EB3_4490_B509_D78C2389694F) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_1E1E9410_2EB3_4490_B509_D78C2389694F,
    ID BIGINT primary key auto_increment NOT NULL,
    TITLE VARCHAR(255),
    ARTIST VARCHAR(255),
    ALBUM VARCHAR(255),
    DURATION VARCHAR(255),
    DATE VARCHAR(255)
);
-- ALTER TABLE PUBLIC.TRACK ADD CONSTRAINT PUBLIC.CONSTRAINT_7 PRIMARY KEY(ID);
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.COURSE;   
