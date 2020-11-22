CREATE TABLE message_likes (
  user_id BIGINT NOT NULL REFERENCES usr,
  message_id BIGINT NOT NULL REFERENCES messages,
  PRIMARY KEY (user_id, message_id)
)