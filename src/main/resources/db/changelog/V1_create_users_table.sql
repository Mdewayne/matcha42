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

-- all encrypted passwords same - "check"
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('FalseTrue', 'FalseTrue@email.com', '$2a$10$dSATX7AHM4L7M.ac7Ta.Xuee2q91jjXbSHmJv.YEZLG28SotO9Pji', false, true);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('TrueTrue', 'TrueTrue@email.com', '$2a$10$dSATX7AHM4L7M.ac7Ta.Xuee2q91jjXbSHmJv.YEZLG28SotO9Pji', true, true);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('TrueFalse', 'TrueFalse@email.com', '$2a$10$dSATX7AHM4L7M.ac7Ta.Xuee2q91jjXbSHmJv.YEZLG28SotO9Pji', true, false);
INSERT INTO appUsers (name, email, password, locked, enabled)
VALUES ('FalseFalse', 'FalseFalse@email.com', '$2a$10$dSATX7AHM4L7M.ac7Ta.Xuee2q91jjXbSHmJv.YEZLG28SotO9Pji', false, false);

