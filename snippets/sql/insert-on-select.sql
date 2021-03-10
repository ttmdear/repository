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

-- Inny przykład takiego zapytania
INSERT INTO BN_PROVIDERS_GROUPS_LOGOS
SELECT
    BPG.PRGR_ID + 1,
    BPG.PRGR_ID,
    PRGR_LOGO
FROM BN_PROVIDERS_GROUPS BPG
