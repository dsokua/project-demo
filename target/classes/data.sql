insert into healthcare_criteria (healthcare_criteria_id, factor, description)
values(1, 0.15, 'Tobacco User');
insert into healthcare_criteria (healthcare_criteria_id, factor, description)
values(2, 0.3, 'Into Extreme Sports');
insert into healthcare_criteria (healthcare_criteria_id, factor, description)
values(3, 0.2, 'Hazardous Occupation');

insert into healthcare_price (healthcare_price_id, age_from, age_to, annual_price)
values(1, 12, 18, 110);
insert into healthcare_price (healthcare_price_id, age_from, age_to, annual_price)
values(2, 19, 32, 100);
insert into healthcare_price (healthcare_price_id, age_from, age_to, annual_price)
values(3, 33, 40, 110);
insert into healthcare_price (healthcare_price_id, age_from, age_to, annual_price)
values(4, 41, 50, 120);
insert into healthcare_price (healthcare_price_id, age_from, age_to, annual_price)
values(5, 51, 65, 140);

insert into healthcare_payment_type (healthcare_payment_type_id, payment_type, multiplier)
values(1, 'Annual', 1);
insert into healthcare_payment_type (healthcare_payment_type_id, payment_type, multiplier)
values(2, 'Semi-annual', 0.525);
insert into healthcare_payment_type (healthcare_payment_type_id, payment_type, multiplier)
values(3, 'Quarterly', 0.26);
insert into healthcare_payment_type (healthcare_payment_type_id, payment_type, multiplier)
values(4, 'Monthly', 0.1);