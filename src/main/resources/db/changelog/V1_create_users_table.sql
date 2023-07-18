create table person (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

INSERT INTO person (name) VALUES ('John Doe');
INSERT INTO person (name) VALUES ('Jane Smith');
INSERT INTO person (name) VALUES ('Michael Johnson');