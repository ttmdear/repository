# if
if [ $x == 5 ];
then
    echo "Value of x is 5."
fi

# if-else
if [ $x == 5 ];
then
    echo "Value of x is 5."
else
    echo "Value of x is not 5."
fi

# elif
x=2
  
if [ $x -eq 1 ]; then
    echo "Value of x is 1."
elif [ $x -eq 2 ]; then
    echo "Value of x is 2."
else
    echo "Value of x is other than 1 and 2."
fi

# case
case $x in
9)
    echo Good Morning!
    ;;
12)
    echo Good Noon!
    ;;
17)
    echo Good Evening!
    ;;
21)
    echo Good Night!
    ;;
esac


