# create database clients
CREATE DATABASE IF NOT EXISTS `mvc_project_db` DEFAULT CHARACTER SET utf8mb4;
USE `mvc_project_db`;
create table if not exists client
(
    id              bigint auto_increment
        primary key,
    login           varchar(45)                         not null,
    password        varchar(100)                        not null,
    name            varchar(45)                         not null,
    surname         varchar(45)                         null,
    email           varchar(50)                         not null,
    permission      varchar(25)                         not null,
    updated_date    timestamp default CURRENT_TIMESTAMP not null,
    registered_date timestamp default CURRENT_TIMESTAMP not null,
    constraint client_pk
        unique (login),
    constraint client_pk2
        unique (email)
);


