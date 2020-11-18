DELETE FROM messages;

ALTER TABLE messages AUTO_INCREMENT=1;

INSERT INTO messages(id, text, tag, user_id) VALUES
(NULL , 'first', 'my-tag', 1),
(NULL, 'second', 'more', 1),
(NULL, 'third', 'my-tag', 1),
(NULL, 'fourth', 'another', 1);

ALTER TABLE messages AUTO_INCREMENT=10;

# ALTER TABLE hibernate_sequence AUTO_INCREMENT=10;
