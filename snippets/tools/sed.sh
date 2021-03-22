# Wyciągnięcie określonego pola na na podstawie wyrażenia regularnego. W
# wyrażeniu grupę umieszczam (.*) a a potem do grupy odwołuję się przez \1, \2
# itp.
sed -n -E 's/.*"type":"(.*)","data":\[(.*)\],"version":\{"present":false\}\}\]\)/\1/p'

# Print
sed -n 1p # Print line 1
sed -n 1,+2p # Print line 1 and 2 next
sed -n 1,2p # Print line from 1 to 2

# Deleting, command is simmilar like print byt use 'd'.
sed 1d # Print line 1
sed 1,+2d # Detele line 1 and 2 next
sed 1,2d # Detele line from 1 to 2
sed 3,+2d # Detele from 3 , 3 lines
sed -i.bak '1~2d' everyother.txt

# Replace all second occurance of " M" to " R" and print line
sed -n 's/ M/ R/2p'

# Replace all second occurance of " M" or " m" to " R" and print line
sed -n 's/ M/ R/2pi'
sed -n 's/M/R/gp'

# Replace every occurrence of Nick with John in report.txt
sed 's/Nick/John/g' report.txt

# Replace every occurrence of Nick or nick with John.
sed 's/Nick|nick/John/g' report.txt

# Add 8 spaces to the left of a text for pretty printing.
sed 's/^/ /' file.txt >file_new.txt

# Display only one paragraph, starting with "Of course"
# and ending in "attention you pay"
sed -n '/Of course/,/attention you pay/p' myfile

# Show only lines 12-18 of file.txt
sed -n 12,18p file.txt

# Show all of file.txt except for lines from 12 to 18
sed 12,18d file.txt

# Double-space file.txt
sed G file.txt

# Write all commands in script.sed and execute them
sed -f script.sed file.txt

# Replace ham with cheese in file.txt except in the 5th line
sed '5!s/ham/cheese/' file.txt

# Delete the last line
sed '$d' file.txt

# Print only lines with three consecutive digits
sed '/[0-9]\{3\}/p' file.txt

# Unless boom is found replace aaa with bb
sed '/boom/!s/aaa/bb/' file.txt

# Delete all lines from line 17 to 'disk'
# echo ONE TWO | sed "s/one/unos/I"
# Replaces one with unos in a case-insensitive manner,
# so it will print "unos TWO"
sed '17,/disk/d' file.txt

# Triple-space a file
sed 'G;G' file.txt

# A way to replace dos2unix :)
sed 's/.$//' file.txt

# Delete all spaces in front of every line of file.txt
sed 's/^[ ^t]*//' file.txt

# Delete all spaces at the end of every line of file.txt
sed 's/[ ^t]*$//' file.txt

# Delete all spaces in front and at the end of every line of file.txt
sed 's/^[ ^t]*//;s/[ ^]*$//' file.txt

# Replace foo with bar only for the first instance in a line.
sed 's/foo/bar/' file.txt

# Replace foo with bar only for the 4th instance in a line.
sed 's/foo/bar/4' file.txt

# Replace foo with bar for all instances in a line.
sed 's/foo/bar/g' file.txt

# Only if line contains baz, substitute foo with bar
sed '/baz/s/foo/bar/g' file.txt

# Delete all consecutive blank lines except for EOF
sed '/./,/^$/!d' file.txt

# Delete all consecutive blank lines, but allows only top blank line
sed '/^$/N;/\n$/D' file.txt

# Delete all leading blank lines
sed '/./,$!d' file.txt

# Match regex plus the next 5 lines
sed '/regex/,+5/expr/'

# Delete every third line, starting with the first
sed '1~3d' file.txt

# Print every 5th line starting with the second
sed -n '2~5p' file.txt

# Delete only the first match
sed '0,/RE/{//d;}' file.txt

# Change only the first match
sed '0,/RE/s//to_that/' file.txt

# Change first field to 9999 in a CSV file
sed 's/^[^,]*,/9999,/' file.csv

# # Script
# s/^ *\(.*[^ ]\) *$/||/;
# s/" *, */"|/g;
# : loop
# s/| *\([^",|][^,|]*\) *, */||/g;
# s/| *, */||/g;
# t loop
# s/ *|/|/g;
# s/| */|/g;
# s/^|\(.*\)|$//;
# sed script to convert CSV file to bar-separated
#
# (works only on some types of CSV,
#
# with embedded "s and commas)

# Change numbers from file.txt from 1234.56 form to 1.234.56
sed ':a;s/\(^\|[^0-9.]\)\([0-9]\+\)\ ([0-9]\{3\}\)/,/g;ta' file.txt

# Convert any word starting with reg or exp to uppercase
sed -r "s/\<(reg|exp)[a-z]+/\U&/g"

# Do replacement of Johnson with White only on lines between 1 and 20
sed '1,20 s/Johnson/White/g' file.txt

# The above reversed (match all except lines 1-20)
sed '1,20 !s/Johnson/White/g' file.txt

# Replace only between "from" and "until"
sed '/from/,/until/ { s/\<red\>/magenta/g; s/\<blue\>/cyan/g; }' file.txt

# Replace only from the word "ENDNOTES:" until EOF
sed '/ENDNOTES:/,$ { s/Schaff/Herzog/g; s/Kraft/Ebbing/g; }' file.txt
