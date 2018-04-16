CREATE TABLE local_pg.emp
(
    e_id integer,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    contact_no bigint NOT NULL,
    PRIMARY KEY (e_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE local_pg.emp
    OWNER to postgres;
