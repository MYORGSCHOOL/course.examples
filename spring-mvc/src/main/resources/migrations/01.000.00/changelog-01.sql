-- liquibase formatted sql

-- changeset kuzmina-ia:1-1

create table users
(
    id         serial primary key,
    first_name varchar(20),
    last_name  varchar(20)
);


create table car
(
    id       serial,
    model    varchar(20),
    owner_id int,
    constraint fk_owner_id FOREIGN KEY (owner_id)
        REFERENCES users (id)
);

-- rollback drop table users
-- rollback drop table car
