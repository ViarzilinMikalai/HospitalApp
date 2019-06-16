create sequence hibernate_sequence start 1 increment 1;


create table patient (
  id int8 not null,
  created_date timestamp,
  updated_date timestamp,
  firstname varchar(50),
  lastname varchar(50),
  surname varchar(50),
  apartment int4 not null check (apartment>=1),
  birth_date date,
  building varchar(255),
  city varchar(255),
  street varchar(255),
  primary key (id)
);

create table user_table (
  id int8 not null,
  created_date timestamp,
  updated_date timestamp,
  firstname varchar(50),
  lastname varchar(50),
  surname varchar(50),
  department varchar(255) not null,
  email varchar(20) not null,
  isactive boolean,
  password varchar(16) not null,
  user_role varchar(255),
  username varchar(255) not null,
  primary key (id)
);

alter table if exists user_table add constraint email_unique unique (email);

alter table if exists user_table add constraint username_unique unique (username);
