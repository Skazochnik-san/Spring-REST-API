create table hibernate_sequence (
  next_val BIGINT
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table messages (
  id BIGINT not null auto_increment primary key,
  filename varchar(255),
  tag varchar(255),
  text varchar(255),
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
  add constraint FK5f19dxsguyxb310o6hn9ccmbt
  foreign key (user_id) references usr (id);

alter table user_role
  add constraint FKfpm8swft53ulq2hl11yplpr5
  foreign key (user_id) references usr (id);