-- Aktualizacja wiersza ze złączeniem
update clients c
left join (select * from clients) c2 on c2.id = c.id
set
	c.fullName = concat(c2.lastName, ' ', c2.firstName)
where c.id = c2.id;

-- Aktualizacja kolumny wygenerowanymi wartościami
set @num = 0;

update dictionarygroup
set position = @num :=@num+1;
