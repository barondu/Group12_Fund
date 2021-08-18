create table fund
(
    id         int auto_increment
        primary key,
    fundId     varchar(255) default '' not null,
    name       varchar(255) default '' not null,
    employeeId varchar(255) default '' not null,
    constraint fundIndex
        unique (fundId)
);

create table funduser
(
    id         int auto_increment
        primary key,
    fundId     varchar(255) default '' not null,
    email      varchar(255) default '' not null,
    employeeId varchar(255) default '' not null
);

create table position
(
    id            int auto_increment
        primary key,
    positionId    varchar(255) default ''           not null,
    securityId    varchar(255) default ''           not null,
    quantity      int          default 0            not null,
    datePurchased date         default '2021-01-01' null,
    fundId        varchar(255) default ''           not null,
    constraint positionIndex
        unique (positionId)
);

create table security
(
    id         int auto_increment
        primary key,
    securityId varchar(255) default '' not null,
    symbol     varchar(255) default '' not null,
    constraint securityId
        unique (securityId)
);

create table user
(
    id         int auto_increment,
    firstName  varchar(255) default '' not null,
    lastName   varchar(255) default '' not null,
    email      varchar(255) default '' not null,
    password   varchar(255) default '' not null,
    isManager  int          default 0  not null,
    employeeId varchar(255)            null,
    primary key (id, email),
    constraint emailIndex
        unique (email)
);