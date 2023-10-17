DROP TABLE IF EXISTS location;
CREATE TABLE location (
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    constraint location_pk primary key (id)
);