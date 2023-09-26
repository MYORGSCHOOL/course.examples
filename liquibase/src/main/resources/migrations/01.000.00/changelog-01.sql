-- liquibase formatted sql

-- changeset kuzmina-ia:1-1

create table test (
    id serial
);

-- changeset kuzmina-ia:1-2

alter table test add column version integer;

-- rollback alter table test drop column version
