DROP FUNCTION IF EXISTS get_this_month;

DELIMITER $$
CREATE FUNCTION get_this_month () 
RETURNS datetime
DETERMINISTIC
BEGIN 
  DECLARE monthfirst datetime;
  	SELECT DATE_SUB(LAST_DAY(NOW()),INTERVAL DAY(LAST_DAY(NOW()))-1 DAY) into monthfirst;
  RETURN monthfirst;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS get_employee_count;

DELIMITER $$
CREATE FUNCTION get_employee_count (hunter_id bigint, type_id bigint) 
RETURNS bigint
DETERMINISTIC
BEGIN 
  DECLARE emp_count bigint;
  	select count(em.id) into emp_count from employee em where 
	em.head_hunter_id= hunter_id && em.employee_type_id=type_id && (em.recruited_date between get_this_month () and NOW() );
	RETURN emp_count;
END$$
DELIMITER ;get_this_monthget_employee_count

create or replace view recruitment_overview as
select distinct em.employee_type_id as type_id, em.head_hunter_id as hunter_id, 
get_employee_count(em.head_hunter_id, em.employee_type_id) as employees_count,
get_employee_count(em.head_hunter_id, em.employee_type_id) div 5 as groups_count
from employee em;

create or replace view hunters_summary as 
select 
em.id as emp_id, em.first_name as emp_fname, em.last_name as emp_last_name, em.ssn_id as emp_ssn_id, em.recruited_date as emp_recruited_date,
hh.id as hh_id, hh.first_name as hh_fname, hh.last_name as hh_lname, hh.ssn_id as hh_ssn_id,
et.id as type_id, et.name as em_type, et.amount as em_value		 
from employee em 
inner join employee_type et on em.employee_type_id = et.id  
inner join head_hunter hh on hh.id = em.head_hunter_id;













