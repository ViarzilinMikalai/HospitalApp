create table departments (
  id int8 not null,
  created_date timestamp,
  updated_date timestamp,
  name varchar(50),
  primary key (id)
);

alter table if exists departments add constraint name_unique unique (name);