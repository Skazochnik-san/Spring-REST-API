# DROP TABLE hibernate_sequence;
# DROP TABLE messages;
# DROP TABLE user_role;
# DROP TABLE usr;

create table hibernate_sequence (
  next_val BIGINT
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table messages (
  id BIGINT not null auto_increment primary key,
  filename varchar(255),
  tag varchar(255),
  text varchar(2048),
  user_id BIGINT
);

create table user_role (
  user_id BIGINT not null,
  roles varchar(255)
);

create table usr (
  id BIGINT not null auto_increment primary key,
  activation_code varchar(255),
  active bit not null,
  email varchar(255),
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL
);

alter table messages
  add constraint messages_user_fk
  foreign key (user_id) references usr (id);

alter table user_role
  add constraint user_role_user_fk
  foreign key (user_id) references usr (id);