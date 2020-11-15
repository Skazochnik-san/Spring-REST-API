CREATE TABLE user_subscriptions (
    channel_id BIGINT not null REFERENCES usr,
    subscriber_id BIGINT not null REFERENCES usr,
    primary key(channel_id, subscriber_id)
)