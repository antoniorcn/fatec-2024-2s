lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

lista2 = lista.copy()

txt1 = "ABC 123"
txt2 = txt1

txt2 = txt2 + ""

if txt1 == txt2:
    print("Tem o mesmo texto")
else:
    print("Possuem textos diferentes")

# if 15 in lista: 
#     print("15 está na lista")
# else:
#     print("15 não esta na lista")

if txt1 is txt2:
    print("São a mesma coisa")
else: 
    print("São diferentes")