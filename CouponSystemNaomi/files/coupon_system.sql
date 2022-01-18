create schema coupon_system;
use coupon_system;

create table COMPANIES(
	`id` int primary key auto_increment,
    `name` varchar(50),
    `email` varchar(50),
    `password` varchar(50));
    
create table CUSTOMERS(
	`id` int primary key auto_increment,
    `first_name` varchar(50),
    `last_name` varchar(50),
    `email` varchar(50),
    `password` varchar(50));

create table COUPONS(
	`id` int primary key auto_increment,
    `company_id` int,
    foreign key (`company_id`) references COMPANIES(`id`),
    `category` varchar(50),
    `title` varchar(50),
    `description` varchar(100),
    `start_date` date,
    `end_date` date,
    `amount` int,
    `price` float,
    `image` varchar(250));
    
create table CUSTOMERS_VS_COUPONS(
	`customer_id` int,
    foreign key (`customer_id`) references CUSTOMERS(`id`),
    `coupon_id` int,
    foreign key (`coupon_id`) references COUPONS(`id`),
    primary key(`customer_id`, `coupon_id`));

select * from COMPANIES;
select * from customers;
select * from customers_vs_coupons;
select * from coupons;

drop schema coupon_system;