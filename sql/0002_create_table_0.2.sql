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
--				tabname					--
------------------------------------------
