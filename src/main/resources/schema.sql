DROP TABLE if exists employee;

CREATE TABLE employee (
  personNum varchar(255) ,
  companyCode varchar(255) ,
  costCenter varchar(255) ,
  eeGrp varchar(255) ,
  esGrp varchar(255) ,
  jobGrade varchar(255) ,
  baseSalary DECIMAL(10,2) ,
  currency varchar(255) ,
  wageType varchar(255) ,
  exceptions varchar(255) ,
  salesIndicator INTEGER,
  employeeType varchar(255) ,
  bonus DECIMAL(10,2) ,
  annualIncentive DECIMAL(10,2) ,
  holiday DECIMAL(10,2) ,
  laborUnion DECIMAL(10,2) ,
  personalSubArea varchar(255)
)