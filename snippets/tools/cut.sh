# Wyciecie danej kolumnu
cut -d' ' -f1

# Wycinanie po przecinku
echo "a,b,c" | cut -d',' -f1 > newFile
