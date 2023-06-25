create table employee(empid int primary key, empname varchar(100), department varchar(50), contactno bigint, emailid varchar(100), empheadid int);


create table empdept(deptid varchar(50) primary key, deptname varchar(100), dept_off varchar(100), depthead int, foreign key (depthead) references employee(empid));


create table empsalary(empid int, foreign key (empid) references employee(empid), salary int, ispermanent varchar(3));


create table project(projectid varchar(50) primary key, duration int);


create table country(cid varchar(50) primary key, cname varchar(100));


create table clienttable(clientid varchar(50) primary key, clientname varchar(100), cid varchar(50), foreign key (cid) references country(cid));


create table empproject(empid int, foreign key (empid) references employee(empid), projectid varchar(50), foreign key (projectid) references project(projectid), clientid varchar(50), foreign key (clientid) references clienttable(clientid), startyear int, endyear int);


insert into employee (empid, empname, department, contactno, emailid, empheadid) values
		(101, 'Monica', 'E-101', 9191919191, 'monica@gmail.com', 105),
		(102, 'Rachel', 'E-104', 9191919191, 'rachel@gmail.com', 103),
		(103, 'Phoebe', 'E-101', 9191919191, 'phoebe@gmail.com', 101),
		(104, 'Chandler', 'E-102', 9191919191, 'chandler@gmail.com', 105),
		(105, 'Ross', 'E-101', 9191919191, 'ross@gmail.com', 102);
		

insert into empdept values 
('E-101', 'HR', 'Monday', 105),
('E-102', 'Development', 'Monday', 101),
('E-103', 'House Keeping', 'Monday', 103),
('E-104', 'Sales', 'Monday', 104),
('E-105', 'Purchase', 'Monday', 104);
	
	
insert into empsalary values
(101, 2000, 'Yes'),
(102, 10000, 'Yes'),
(103, 5000, 'No'),
(104, 1900, 'Yes'),
(105, 2300, 'Yes');


insert into project values
('p-1', 23),
('p-2', 15),
('p-3', 45),
('p-4', 2),
('p-5', 30);

insert into country values
('c-1', 'India'),
('c-2', 'USA'),
('c-3', 'Chine'),
('c-4', 'Pakistan'),
('c-5', 'Russia');


insert into clienttable values
('cl-1', 'ABC Group', 'c-1'),
('cl-2', 'PQR', 'c-1'),
('cl-3', 'XYZ', 'c-2'),
('cl-4', 'tech altum', 'c-3'),
('cl-5', 'mnp', 'c-5');


insert into empproject values
('101', 'p-1', 'cl-1', 2010, 2010),
('102', 'p-2', 'cl-2', 2010, 2012),
('103', 'p-1', 'cl-3', 2013, 2016),
('104', 'p-4', 'cl-1', 2014, 2015),
('105', 'p-4', 'cl-5', 2015, 2017);

select * from employee where empname like 'P%';

select count(*) from empsalary where salary>5000 and ispermanent = 'Yes';


select * from employee where department = 'E-102' or department = 'E-104';

select deptname from empdept where deptid = 'E-102';

select sum(salary) from empsalary where ispermanent = 'Yes';

select * from employee where empname like '%a';

select count(empid) as employee, projectid from empproject group by projectid having count(empid) > 1;

select empname from employee where empheadid = (select empid from employee where empname = 'Ross');

select t.empid, t.salary from (select empid, salary from empsalary order by salary desc limit 3) as t order by t.salary limit 1;

select * from empsalary where salary between 2000 and 3000;

select emp.empid, emp.empname from employee as emp inner join empproject as empproj on emp.empid = empproj.empid and empproj.projectid = 'p-1';

create view department_salary_info as 
select emp.department as Department, max(esal.salary) as Maximum_Salary
from employee as emp 
inner join 
empsalary as esal 
on emp.empid = esal.empid group by emp.department;
select * from department_salary_info;

insert into employee values 
(106, 'Joey', 'E-102', 9191919191, 'joey@gmail.com', 103);

delete from employee where empid = 106;


alter table employee drop column contactno;
select * from employee;

select * from employee limit 3;

delimiter //
create procedure display_department (dept varchar(50))
begin
select * from employee where department = dept;
end // 
delimiter ;

call display_department('E-102');