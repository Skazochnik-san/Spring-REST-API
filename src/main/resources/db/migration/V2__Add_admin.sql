INSERT INTO usr (id, active, password, username)
            VALUES (1, true, '123', 'admin');


insert into user_role (user_id, roles)
        VALUES (1, 'USER'), (1, 'ADMIN');