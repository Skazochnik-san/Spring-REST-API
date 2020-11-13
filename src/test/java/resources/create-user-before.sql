DELETE FROM user_role;
DELETE FROM usr;

INSERT INTO usr(id, active, password, username) VALUES
(1, 1, '$2a$08$kg9qnSYn4sC5FK3cj8IB6eq0JcZl4QyzXv1syMI2C1TujryqgZb.K', '123'),
(2, 1, '$2a$08$kg9qnSYn4sC5FK3cj8IB6eq0JcZl4QyzXv1syMI2C1TujryqgZb.K', '2020');

INSERT INTO user_role(user_id, roles) VALUES
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');