# for-loop
arr=( "apple" "banana" "cherry" )
  
for i in "${arr[@]}"
do
    echo "Fruit : $i"
done

# while
count=10
i=0
 
while [ $i -lt $count ];
do
   echo "$i"
   let i++
done

# until
count=10
i=0
 
until [ $i -gt $count ];
do
   echo "$i"
   let i++
done
