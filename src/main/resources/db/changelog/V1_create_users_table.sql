create table appUsers (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    locked BOOLEAN,
    enabled BOOLEAN
);

--     private var id: Long,
--     private var name: String,
--     private var email: String,
--     private var password: String,
--     private var locked: Boolean,
--     private var enabled: Boolean

INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('FalseTrue', 'FalseTrue@email.com', 'pass', false, true);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('TrueTrue', 'TrueTrue@email.com', 'pass', true, true);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('TrueFalse', 'TrueFalse@email.com', 'pass', true, false);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('FalseFalse', 'FalseFalse@email.com', 'pass', false, false);

