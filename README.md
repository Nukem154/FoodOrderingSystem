1. select * from country join city c on country.id = c.country_id where population > 400

2. select country.name from country join city c on country.id = c.country_id
where (select count(*) from building join city c on c.id = building.city_id) = 0
