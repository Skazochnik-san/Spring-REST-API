INSERT INTO usr (id, active, password, username)
            VALUES (1, true, '$2a$08$sN6agpiSipKaMqlp2qIUwuB6i9FywENyl7nRZSdoiyKNqbRB1G4qi', 'admin');


insert into user_role (user_id, roles)
        VALUES (1, 'USER'), (1, 'ADMIN');