1. select * from country join city c on country.id = c.country_id where population > 400

2. select country.name from country join city c on country.id = c.country_id
    where not exists(select * from building where city_id = c.id)
