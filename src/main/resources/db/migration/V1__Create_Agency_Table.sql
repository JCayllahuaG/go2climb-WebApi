DROP TABLE IF EXISTS agency;
CREATE TABLE agency (
    id SERIAL NOT NULL,
    user_id integer,
    name varchar(50),
    brand_url varchar(200),
    email varchar(50),
    description varchar(100),
    ruc varchar(11),
    phone varchar(20),
    location varchar(70),
    constraint agency_pk primary key (id)
);