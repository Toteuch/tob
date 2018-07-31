------------------------------------------
--				tobuser					--
------------------------------------------
CREATE TABLE tob_dev.tobuser
(
    id serial NOT NULL,
    login text NOT NULL,
    passwd text NOT NULL,
    CONSTRAINT pk_tobuser PRIMARY KEY (id),
    CONSTRAINT unique_tobuser_login UNIQUE (login)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE tob_dev.tobuser
    OWNER to tob_dev;
    
------------------------------------------
--				ConfigXY				--
------------------------------------------
CREATE TABLE tob_dev.configxy
(
    id serial NOT NULL,
    tobuser serial NOT NULL,
    label text NOT NULL,
    coordx integer NOT NULL,
    coordy integer NOT NULL,
    CONSTRAINT pk_configxy PRIMARY KEY (id),
    CONSTRAINT unique_configxy_tobuser_text UNIQUE (tobuser, label)
    CONSTRAINT fk_configxy_tobuser FOREIGN KEY (tobuser) 
    	REFERENCES tob_dev.tobuser (id) 
    	MATCH SIMPLE 
    	ON UPDATE NO ACTION 
    	ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
ALTER TABLE tob_dev.tobuser
    OWNER to tob_dev;
CREATE INDEX fki_fk_configxy_tobuser
    ON tob_dev.configxy(tobuser);
    
------------------------------------------
--				........				--
------------------------------------------