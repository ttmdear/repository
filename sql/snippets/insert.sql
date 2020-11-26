-- INSERT na bazie SELECTa
insert into dictionaries
select
	null,
	'countries',
	base.value
from (
	select
		u.countryId as value
	from users u
	group by u.countryId
) as base
